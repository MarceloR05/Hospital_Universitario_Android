package sv.edu.catolica.hospital_universitario

import android.app.TimePickerDialog
import android.text.InputType
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar
import java.util.Locale

/** Qué lleva delante del título: nada, una hora (con selector) o un código automático. */
enum class LeadMode { NONE, TIME, CODE }

/** Qué se puede cambiar de un registro al tocarlo. */
enum class EditMode { FULL, STATUS_ONLY, NONE }

data class ExtraAction(@StringRes val labelRes: Int, val onClick: (Entry) -> Unit)

data class ListScreenConfig(
    val statusOptions: List<StatusOption>,
    val editMode: EditMode,
    val canAdd: Boolean = false,
    val canDelete: Boolean = false,
    val leadMode: LeadMode = LeadMode.NONE,
    val codePrefix: String = "",
    val icon: String = "✚",
    val compactRows: Boolean = false,
    @StringRes val formTitleNew: Int = R.string.list_form_new,
    @StringRes val formTitleEdit: Int = R.string.list_form_edit,
    @StringRes val titleHint: Int = R.string.list_hint_name,
    @StringRes val metaHint: Int? = null,
    val suggestPatients: Boolean = false,
    @StringRes val saveConfirmMessage: Int? = null,
    val extraAction: ExtraAction? = null
)

/**
 * Controlador reutilizable de una pantalla de lista: carga desde el repositorio, búsqueda en la
 * misma barra (con teclado), detalle/acciones, cambio de estado, formulario y eliminar.
 */
class ListScreen(
    private val activity: AppCompatActivity,
    private val repository: EntryRepository,
    private val config: ListScreenConfig,
    private val views: Views
) {

    class Views(
        val recycler: RecyclerView,
        val empty: TextView,
        val search: EditText,
        val clearSearch: View,
        val searchCard: View,
        val newButton: View?,
        val root: View,
        val snackbarAnchor: View
    )

    private var query: String = ""
    private lateinit var adapter: ListAdapter<Entry, *>

    fun attach() {
        // El teclado no sube la barra inferior ni el botón, y no aparece solo al abrir la pantalla
        activity.window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
        )

        adapter = if (config.compactRows) {
            ShiftAdapter { entry -> onEntryClick(entry) }
        } else {
            EntryAdapter { entry -> onEntryClick(entry) }
        }
        views.recycler.layoutManager = LinearLayoutManager(activity)
        views.recycler.adapter = adapter

        val newButton = views.newButton
        if (newButton != null) {
            if (config.canAdd) {
                newButton.setOnClickListener { showForm(null) }
            } else {
                newButton.visibility = View.GONE
            }
        }

        setupSearch()
        load()
    }

    // ------------------------------------------------------------------ lista

    private fun load() {
        val items = repository.search(query)
        adapter.submitList(items)
        if (items.isEmpty()) {
            views.empty.text = if (query.isBlank()) {
                activity.getString(R.string.list_empty)
            } else {
                activity.getString(R.string.list_no_results, query)
            }
            views.empty.visibility = View.VISIBLE
        } else {
            views.empty.visibility = View.GONE
        }
    }

    // --------------------------------------------------------------- búsqueda

    private fun setupSearch() {
        // Tocar cualquier parte de la barra enfoca el campo y abre el teclado
        views.searchCard.setOnClickListener { focusSearch() }

        views.search.addTextChangedListener { text ->
            query = text?.toString().orEmpty().trim()
            views.clearSearch.visibility = if (text.isNullOrEmpty()) View.GONE else View.VISIBLE
            load()
        }

        views.search.setOnEditorActionListener { view, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard(view)
                view.clearFocus()
                true
            } else {
                false
            }
        }

        views.clearSearch.setOnClickListener {
            views.search.text.clear()
            focusSearch()
        }
    }

    private fun focusSearch() {
        views.search.requestFocus()
        activity.getSystemService(InputMethodManager::class.java)
            ?.showSoftInput(views.search, InputMethodManager.SHOW_IMPLICIT)
    }

    private fun hideKeyboard(view: View) {
        activity.getSystemService(InputMethodManager::class.java)
            ?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // ---------------------------------------------------------------- acciones

    private fun onEntryClick(entry: Entry) {
        if (config.editMode == EditMode.NONE && config.extraAction == null) {
            showInfo(entry)
            return
        }

        val labels = mutableListOf<String>()
        val actions = mutableListOf<() -> Unit>()

        val extra = config.extraAction
        if (extra != null) {
            labels.add(activity.getString(extra.labelRes))
            actions.add { extra.onClick(entry) }
        }
        if (config.editMode != EditMode.NONE) {
            labels.add(activity.getString(R.string.list_action_status))
            actions.add { showStatusPicker(entry) }
        }
        if (config.editMode == EditMode.FULL) {
            labels.add(activity.getString(R.string.list_action_edit))
            actions.add { showForm(entry) }
        }
        if (config.canDelete) {
            labels.add(activity.getString(R.string.list_action_delete))
            actions.add { confirmDelete(entry) }
        }

        MaterialAlertDialogBuilder(activity)
            .setTitle(entry.displayTitle)
            .setItems(labels.toTypedArray()) { _, which -> actions[which]() }
            .setNegativeButton(R.string.list_close, null)
            .show()
    }

    private fun showInfo(entry: Entry) {
        val message = listOf(entry.meta, activity.getString(entry.status.labelRes))
            .filter { it.isNotBlank() }
            .joinToString("\n")
        MaterialAlertDialogBuilder(activity)
            .setTitle(entry.displayTitle)
            .setMessage(message)
            .setPositiveButton(R.string.list_close, null)
            .show()
    }

    private fun showStatusPicker(entry: Entry) {
        val labels = config.statusOptions.map { activity.getString(it.labelRes) }.toTypedArray()
        val checked = config.statusOptions.indexOfFirst { it == entry.status }
        MaterialAlertDialogBuilder(activity)
            .setTitle(R.string.list_status_title)
            .setSingleChoiceItems(labels, checked) { dialog, which ->
                repository.update(entry.copy(status = config.statusOptions[which]))
                dialog.dismiss()
                load()
                showMessage(R.string.list_status_updated)
            }
            .setNegativeButton(R.string.list_cancel, null)
            .show()
    }

    private fun confirmDelete(entry: Entry) {
        MaterialAlertDialogBuilder(activity)
            .setTitle(R.string.list_delete_title)
            .setMessage(activity.getString(R.string.list_delete_message, entry.displayTitle))
            .setPositiveButton(R.string.list_action_delete) { _, _ ->
                repository.delete(entry.id)
                load()
                showMessage(R.string.list_deleted)
            }
            .setNegativeButton(R.string.list_cancel, null)
            .show()
    }

    // --------------------------------------------------------------- formulario

    /** [existing] == null: crear. Si no, editar ese registro. */
    private fun showForm(existing: Entry?) {
        var selectedTime = existing?.lead?.takeIf { TIME_REGEX.matches(it) } ?: currentTime()

        val titleField: EditText = if (config.suggestPatients) {
            AutoCompleteTextView(activity).apply {
                threshold = 1
                setAdapter(
                    ArrayAdapter(
                        activity,
                        android.R.layout.simple_dropdown_item_1line,
                        AppContainer.patientRepository.getAll().map { it.fullName }
                    )
                )
            }
        } else {
            EditText(activity)
        }
        titleField.hint = activity.getString(config.titleHint)
        titleField.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
        titleField.setText(existing?.title.orEmpty())

        val metaHint = config.metaHint
        val metaField: EditText? = if (metaHint != null) {
            EditText(activity).apply {
                hint = activity.getString(metaHint)
                inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_SENTENCES
                setText(existing?.meta.orEmpty())
            }
        } else {
            null
        }

        val timeButton: Button? = if (config.leadMode == LeadMode.TIME) {
            Button(activity).apply {
                text = activity.getString(R.string.list_time_label, selectedTime)
                setOnClickListener {
                    val parts = selectedTime.split(":").map { it.toInt() }
                    TimePickerDialog(
                        activity,
                        { _, hour, minute ->
                            selectedTime = String.format(Locale.US, "%02d:%02d", hour, minute)
                            text = activity.getString(R.string.list_time_label, selectedTime)
                        },
                        parts[0],
                        parts[1],
                        true
                    ).show()
                }
            }
        } else {
            null
        }

        val statusSpinner = Spinner(activity).apply {
            adapter = ArrayAdapter(
                activity,
                android.R.layout.simple_spinner_dropdown_item,
                config.statusOptions.map { activity.getString(it.labelRes) }
            )
            val index = config.statusOptions.indexOfFirst { it == existing?.status }
            setSelection(if (index >= 0) index else 0)
        }

        val container = LinearLayout(activity).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(20), dp(8), dp(20), 0)
            if (timeButton != null) addView(timeButton)
            addView(titleField)
            if (metaField != null) addView(metaField)
            addView(statusSpinner)
        }

        val dialog = MaterialAlertDialogBuilder(activity)
            .setTitle(if (existing == null) config.formTitleNew else config.formTitleEdit)
            .setView(container)
            .setPositiveButton(R.string.list_form_save, null) // se define abajo para validar
            .setNegativeButton(R.string.list_cancel, null)
            .create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val title = titleField.text.toString().trim()
                val meta = if (metaField != null) {
                    metaField.text.toString().trim()
                } else {
                    existing?.meta.orEmpty()
                }

                var valid = true
                if (title.length < 3) {
                    titleField.error = activity.getString(R.string.list_error_title)
                    valid = false
                }
                if (metaField != null && meta.length < 3) {
                    metaField.error = activity.getString(R.string.list_error_meta)
                    valid = false
                }
                if (!valid) return@setOnClickListener

                val status = config.statusOptions[statusSpinner.selectedItemPosition]
                val lead = when (config.leadMode) {
                    LeadMode.TIME -> selectedTime
                    LeadMode.CODE -> existing?.lead ?: repository.nextCode(config.codePrefix)
                    LeadMode.NONE -> ""
                }

                val commit = {
                    if (existing == null) {
                        repository.add(
                            Entry(icon = config.icon, lead = lead, title = title, meta = meta, status = status)
                        )
                        showMessage(R.string.list_saved)
                    } else {
                        repository.update(
                            existing.copy(lead = lead, title = title, meta = meta, status = status)
                        )
                        showMessage(R.string.list_updated)
                    }
                    dialog.dismiss()
                    load()
                }

                val confirmMessage = config.saveConfirmMessage
                if (confirmMessage != null) {
                    MaterialAlertDialogBuilder(activity)
                        .setTitle(R.string.list_confirm_title)
                        .setMessage(confirmMessage)
                        .setPositiveButton(R.string.list_confirm_save) { _, _ -> commit() }
                        .setNegativeButton(R.string.list_confirm_review, null)
                        .show()
                } else {
                    commit()
                }
            }
        }
        dialog.show()
    }

    // ---------------------------------------------------------------- helpers

    private fun showMessage(@StringRes messageRes: Int) {
        Snackbar.make(views.root, messageRes, Snackbar.LENGTH_SHORT)
            .setAnchorView(views.snackbarAnchor)
            .show()
    }

    private fun currentTime(): String {
        val now = Calendar.getInstance()
        return String.format(
            Locale.US,
            "%02d:%02d",
            now.get(Calendar.HOUR_OF_DAY),
            now.get(Calendar.MINUTE)
        )
    }

    private fun dp(value: Int): Int = (value * activity.resources.displayMetrics.density).toInt()

    private companion object {
        val TIME_REGEX = Regex("^\\d{2}:\\d{2}$")
    }
}

package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import sv.edu.catolica.hospital_universitario.databinding.ActivityPatientsBinding

class PatientsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPatientsBinding
    private val repository: PatientRepository = AppContainer.patientRepository
    private lateinit var adapter: PatientAdapter
    private var currentQuery: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // El teclado no sube la barra inferior ni el botón, y no aparece solo al abrir la pantalla
        window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN or
                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN
        )
        binding = ActivityPatientsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupList()
        setupListeners()
        loadPatients()
    }

    private fun setupList() {
        adapter = PatientAdapter { patient -> showPatientDetail(patient) }
        binding.rvPatients.layoutManager = LinearLayoutManager(this)
        binding.rvPatients.adapter = adapter
    }

    /** Vuelve a leer del repositorio (aplicando la búsqueda actual) y actualiza la lista. */
    private fun loadPatients() {
        val patients = repository.search(currentQuery)
        adapter.submitList(patients)
        if (patients.isEmpty()) {
            binding.tvEmpty.text = if (currentQuery.isBlank()) {
                getString(R.string.patients_empty)
            } else {
                getString(R.string.patients_no_results, currentQuery)
            }
            binding.tvEmpty.visibility = View.VISIBLE
        } else {
            binding.tvEmpty.visibility = View.GONE
        }
    }

    private fun setupListeners() {
        setupSearch()
        binding.btnNewPatient.setOnClickListener { showPatientForm(null) }

        // Bottom Navigation (Recepción)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.ReceptionTab.PATIENTS,
            tabInicio = binding.tabInicio,
            tabPacientes = binding.tabPacientes,
            tabCitas = binding.tabCitas,
            tabTurnos = binding.tabTurnos,
            tabMas = binding.tabMas
        )
    }

    // ---------------------------------------------------------------- búsqueda

    /** Búsqueda en la misma barra: filtra mientras se escribe. */
    private fun setupSearch() {
        // Tocar cualquier parte de la barra enfoca el campo y abre el teclado
        binding.cardSearch.setOnClickListener { focusSearch() }

        binding.etSearch.addTextChangedListener { text ->
            currentQuery = text?.toString().orEmpty().trim()
            binding.btnClearSearch.visibility =
                if (text.isNullOrEmpty()) View.GONE else View.VISIBLE
            loadPatients()
        }

        // Tecla "buscar" del teclado: cierra el teclado y deja el filtro aplicado
        binding.etSearch.setOnEditorActionListener { view, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                hideKeyboard(view)
                view.clearFocus()
                true
            } else {
                false
            }
        }

        binding.btnClearSearch.setOnClickListener {
            binding.etSearch.text.clear()
            focusSearch()
        }
    }

    private fun focusSearch() {
        binding.etSearch.requestFocus()
        getSystemService(InputMethodManager::class.java)
            ?.showSoftInput(binding.etSearch, InputMethodManager.SHOW_IMPLICIT)
    }

    private fun hideKeyboard(view: View) {
        getSystemService(InputMethodManager::class.java)
            ?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // ----------------------------------------------------------------- detalle

    private fun showPatientDetail(patient: Patient) {
        val message = getString(
            R.string.patients_detail_message,
            patient.fullName,
            patient.record,
            getString(patient.status.labelRes),
            patient.age,
            patient.phone
        )
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.patients_detail_title)
            .setMessage(message)
            .setPositiveButton(R.string.patients_detail_edit) { _, _ -> showPatientForm(patient) }
            .setNeutralButton(R.string.patients_detail_delete) { _, _ -> confirmDelete(patient) }
            .setNegativeButton(R.string.patients_detail_close, null)
            .show()
    }

    // -------------------------------------------------------- crear / editar

    /** [existing] == null: crear paciente nuevo. Si no, editar ese paciente. */
    private fun showPatientForm(existing: Patient?) {
        val etName = EditText(this).apply {
            hint = getString(R.string.patients_form_name_hint)
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
            setText(existing?.fullName.orEmpty())
        }
        val etAge = EditText(this).apply {
            hint = getString(R.string.patients_form_age_hint)
            inputType = InputType.TYPE_CLASS_NUMBER
            setText(existing?.age?.toString().orEmpty())
        }
        val etPhone = EditText(this).apply {
            hint = getString(R.string.patients_form_phone_hint)
            inputType = InputType.TYPE_CLASS_PHONE
            setText(existing?.phone.orEmpty())
        }
        val statusLabels = PatientStatus.entries.map { getString(it.labelRes) }
        val spStatus = Spinner(this).apply {
            adapter = ArrayAdapter(
                this@PatientsActivity,
                android.R.layout.simple_spinner_dropdown_item,
                statusLabels
            )
            setSelection((existing?.status ?: PatientStatus.ACTIVE).ordinal)
        }

        val container = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(20), dp(8), dp(20), 0)
            addView(etName)
            addView(etAge)
            addView(etPhone)
            addView(spStatus)
        }

        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle(
                if (existing == null) R.string.patients_form_title_new
                else R.string.patients_form_title_edit
            )
            .setView(container)
            .setPositiveButton(R.string.patients_form_save, null) // se define abajo para validar
            .setNegativeButton(R.string.patients_search_cancel, null)
            .create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val name = etName.text.toString().trim()
                val age = etAge.text.toString().toIntOrNull()
                val phoneDigits = etPhone.text.toString().filter { it.isDigit() }

                var valid = true
                if (name.length < 3) {
                    etName.error = getString(R.string.patients_error_name)
                    valid = false
                }
                if (age == null || age !in 0..120) {
                    etAge.error = getString(R.string.patients_error_age)
                    valid = false
                }
                if (phoneDigits.length != 8) {
                    etPhone.error = getString(R.string.patients_error_phone)
                    valid = false
                }
                if (!valid || age == null) return@setOnClickListener

                val phone = phoneDigits.substring(0, 4) + "-" + phoneDigits.substring(4)
                val status = PatientStatus.entries[spStatus.selectedItemPosition]

                if (existing == null) {
                    repository.add(Patient(fullName = name, status = status, age = age, phone = phone))
                    showMessage(R.string.patients_saved)
                } else {
                    repository.update(
                        existing.copy(fullName = name, status = status, age = age, phone = phone)
                    )
                    showMessage(R.string.patients_updated)
                }
                dialog.dismiss()
                loadPatients()
            }
        }
        dialog.show()
    }

    // --------------------------------------------------------------- eliminar

    private fun confirmDelete(patient: Patient) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.patients_delete_title)
            .setMessage(getString(R.string.patients_delete_message, patient.fullName))
            .setPositiveButton(R.string.patients_detail_delete) { _, _ ->
                repository.delete(patient.id)
                loadPatients()
                showMessage(R.string.patients_deleted)
            }
            .setNegativeButton(R.string.patients_search_cancel, null)
            .show()
    }

    // ---------------------------------------------------------------- helpers

    private fun showMessage(messageRes: Int) {
        Snackbar.make(binding.root, messageRes, Snackbar.LENGTH_SHORT)
            .setAnchorView(binding.bottomNavContainer)
            .show()
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()
}

package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingPreconsultBinding
import java.util.Locale

class NursingPreconsultActivity : AppCompatActivity() {

    private enum class Kind { BLOOD_PRESSURE, WHOLE, DECIMAL }

    /** Un signo vital: tarjeta tocable, texto con el valor y rango permitido. */
    private class Vital(
        val key: String,
        val card: View,
        val valueView: TextView,
        @StringRes val labelRes: Int,
        @StringRes val formatRes: Int,
        @StringRes val hintRes: Int,
        val kind: Kind,
        val min: Double,
        val max: Double,
        val defaultValue: String
    )

    private lateinit var binding: ActivityNursingPreconsultBinding
    private lateinit var vitals: List<Vital>
    private val current = mutableMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingPreconsultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Rangos ilustrativos y amplios: validar con personal clínico antes de uso real.
        vitals = listOf(
            Vital("bp", binding.cardBp, binding.tvBpValue, R.string.label_bp, R.string.vitals_format_bp,
                R.string.vitals_hint_bp, Kind.BLOOD_PRESSURE, 30.0, 260.0, "120/80"),
            Vital("hr", binding.cardHr, binding.tvHrValue, R.string.label_hr, R.string.vitals_format_hr,
                R.string.vitals_hint_value, Kind.WHOLE, 20.0, 250.0, "78"),
            Vital("temp", binding.cardTemp, binding.tvTempValue, R.string.label_temp, R.string.vitals_format_temp,
                R.string.vitals_hint_value, Kind.DECIMAL, 30.0, 45.0, "36.7"),
            Vital("spo2", binding.cardSpo2, binding.tvSpo2Value, R.string.label_spo2, R.string.vitals_format_spo2,
                R.string.vitals_hint_value, Kind.WHOLE, 50.0, 100.0, "98"),
            Vital("rr", binding.cardRr, binding.tvRrValue, R.string.label_rr, R.string.vitals_format_rr,
                R.string.vitals_hint_value, Kind.WHOLE, 4.0, 60.0, "18"),
            Vital("weight", binding.cardWeight, binding.tvWeightValue, R.string.label_weight, R.string.vitals_format_weight,
                R.string.vitals_hint_value, Kind.DECIMAL, 1.0, 400.0, "68")
        )

        setupListeners()
        showSelectedPatient()
    }

    private fun setupListeners() {
        // La barra de búsqueda permite elegir el paciente
        binding.cardSearch.setOnClickListener {
            PatientPicker.show(this) { patient ->
                AppContainer.selectedPatientName = patient.fullName
                showSelectedPatient()
            }
        }

        binding.cardSelectedPatient.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.nursing_selected_patient_title)
                .setMessage("${binding.tvPatientName.text}\n${binding.tvPatientMeta.text}")
                .setPositiveButton(R.string.list_close, null)
                .show()
        }

        for (vital in vitals) {
            vital.card.setOnClickListener { editVital(vital) }
        }

        binding.btnSavePreconsult.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.vitals_save_title)
                .setMessage(getString(R.string.vitals_save_message, currentPatientName()))
                .setPositiveButton(R.string.vitals_save_yes) { _, _ -> savePreconsult() }
                .setNegativeButton(R.string.list_cancel, null)
                .show()
        }

        // Bottom Navigation (Enfermería)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.NursingTab.PRECONSULT,
            tabInicio = binding.tabInicio,
            tabPacientes = binding.tabPacientes,
            tabPreconsulta = binding.tabPreconsulta,
            tabHabitaciones = binding.tabHabitaciones,
            tabMas = binding.tabMas
        )
    }

    private fun currentPatientName(): String =
        AppContainer.selectedPatientName
            ?: getString(R.string.nursing_selected_patient_name).substringBefore(" · ")

    /** Muestra el paciente elegido y sus signos vitales guardados (o los valores por defecto). */
    private fun showSelectedPatient() {
        val name = AppContainer.selectedPatientName
        if (name != null) {
            val patient = AppContainer.patientRepository.getAll().firstOrNull { it.fullName == name }
            if (patient != null) {
                binding.tvPatientName.text = getString(R.string.patient_card_name, patient.fullName, patient.record)
                binding.tvPatientMeta.text = getString(R.string.patient_card_meta, patient.age)
            } else {
                binding.tvPatientName.text = name
                binding.tvPatientMeta.text = ""
            }
        }
        val patientName = currentPatientName()
        for (vital in vitals) {
            current[vital.key] = VitalsStore.get(patientName, vital.key) ?: vital.defaultValue
            render(vital)
        }
    }

    private fun render(vital: Vital) {
        val value = current[vital.key] ?: vital.defaultValue
        vital.valueView.text = getString(vital.formatRes, value)
    }

    private fun editVital(vital: Vital) {
        val input = EditText(this).apply {
            hint = getString(vital.hintRes)
            inputType = when (vital.kind) {
                Kind.BLOOD_PRESSURE -> InputType.TYPE_CLASS_TEXT
                Kind.WHOLE -> InputType.TYPE_CLASS_NUMBER
                Kind.DECIMAL -> InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
            }
            setText(current[vital.key].orEmpty())
            setSelection(text.length)
        }
        val container = FrameLayout(this).apply {
            setPadding(dp(20), dp(8), dp(20), 0)
            addView(input)
        }

        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle(vital.labelRes)
            .setView(container)
            .setPositiveButton(R.string.list_form_save, null) // se define abajo para validar
            .setNegativeButton(R.string.list_cancel, null)
            .create()

        dialog.setOnShowListener {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener {
                val normalized = normalize(vital, input.text.toString())
                if (normalized == null) {
                    input.error = getString(R.string.vitals_error_invalid, getString(vital.labelRes))
                    return@setOnClickListener
                }
                current[vital.key] = normalized
                render(vital)
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    /** Devuelve el valor normalizado, o null si no es válido o está fuera de rango. */
    private fun normalize(vital: Vital, raw: String): String? {
        val text = raw.trim().replace(',', '.')
        return when (vital.kind) {
            Kind.BLOOD_PRESSURE -> {
                val match = Regex("^(\\d{2,3})/(\\d{2,3})$").find(text) ?: return null
                val systolic = match.groupValues[1].toInt()
                val diastolic = match.groupValues[2].toInt()
                val inRange = systolic in 50..260 && diastolic in 30..160 && systolic > diastolic
                if (inRange) "$systolic/$diastolic" else null
            }
            Kind.WHOLE -> {
                val number = text.toIntOrNull() ?: return null
                if (number.toDouble() in vital.min..vital.max) number.toString() else null
            }
            Kind.DECIMAL -> {
                val number = text.toDoubleOrNull() ?: return null
                if (number !in vital.min..vital.max) return null
                if (number == number.toLong().toDouble()) {
                    number.toLong().toString()
                } else {
                    String.format(Locale.US, "%.1f", number)
                }
            }
        }
    }

    private fun savePreconsult() {
        val patientName = currentPatientName()
        for (vital in vitals) {
            VitalsStore.put(patientName, vital.key, current[vital.key] ?: vital.defaultValue)
        }
        Toast.makeText(this, R.string.msg_preconsult_saved, Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()
}

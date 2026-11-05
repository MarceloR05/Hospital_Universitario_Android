package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorConsultBinding

class DoctorConsultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorConsultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorConsultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
        showSelectedPatient()
    }

    private fun setupListeners() {
        // La barra de búsqueda permite elegir el paciente en atención
        binding.cardSearch.setOnClickListener {
            PatientPicker.show(this) { patient ->
                AppContainer.selectedPatientName = patient.fullName
                showSelectedPatient()
            }
        }

        // Tarjeta del paciente: muestra sus datos
        binding.cardSelectedPatient.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.doctor_consult_patient_section)
                .setMessage("${binding.tvPatientName.text}\n${binding.tvPatientMeta.text}")
                .setPositiveButton(R.string.list_close, null)
                .show()
        }

        // Finalizar consulta: valida, confirma y marca la cita como atendida
        binding.btnFinishConsult.setOnClickListener {
            val reason = binding.etConsultReason.text.toString().trim()
            val notes = binding.etConsultNotes.text.toString().trim()

            var valid = true
            if (reason.isEmpty()) {
                binding.etConsultReason.error = getString(R.string.consult_error_reason)
                valid = false
            }
            if (notes.isEmpty()) {
                binding.etConsultNotes.error = getString(R.string.consult_error_notes)
                valid = false
            }
            if (!valid) return@setOnClickListener

            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.consult_confirm_title)
                .setMessage(getString(R.string.consult_confirm_message, currentPatientName()))
                .setPositiveButton(R.string.consult_confirm_yes) { _, _ -> finishConsult() }
                .setNegativeButton(R.string.list_cancel, null)
                .show()
        }

        // Bottom Navigation (Médico)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.DoctorTab.CONSULT,
            tabInicio = binding.tabInicio,
            tabCitas = binding.tabCitas,
            tabConsulta = binding.tabConsulta,
            tabExpediente = binding.tabExpediente,
            tabMas = binding.tabMas
        )
    }

    private fun currentPatientName(): String =
        AppContainer.selectedPatientName
            ?: getString(R.string.doctor_consult_patient_name).substringBefore(" · ")

    private fun showSelectedPatient() {
        val name = AppContainer.selectedPatientName ?: return
        val patient = AppContainer.patientRepository.getAll().firstOrNull { it.fullName == name }
        if (patient != null) {
            binding.tvPatientName.text = getString(R.string.patient_card_name, patient.fullName, patient.record)
            binding.tvPatientMeta.text = getString(R.string.patient_card_meta, patient.age)
        } else {
            binding.tvPatientName.text = name
            binding.tvPatientMeta.text = ""
        }
    }

    /** Marca como atendida la cita pendiente del paciente, en agenda del doctor y de recepción. */
    private fun finishConsult() {
        val name = currentPatientName()
        for (repository in listOf(AppContainer.doctorAppointmentRepository, AppContainer.appointmentRepository)) {
            val appointment = repository.getAll().firstOrNull {
                it.title == name && it.status != Statuses.ATENDIDA && it.status != Statuses.CANCELADA
            }
            if (appointment != null) {
                repository.update(appointment.copy(status = Statuses.ATENDIDA))
            }
        }
        Toast.makeText(this, R.string.msg_consult_finished, Toast.LENGTH_SHORT).show()
        finish()
    }
}

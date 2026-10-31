package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorConsultBinding

class DoctorConsultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorConsultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorConsultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda en consulta médica", Toast.LENGTH_SHORT).show()
        }

        // Patient card click
        binding.cardSelectedPatient.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_doctor_appointment_details)} ${getString(R.string.doctor_consult_patient_name)}", Toast.LENGTH_SHORT).show()
        }

        // Finish consult button click
        binding.btnFinishConsult.setOnClickListener {
            val notes = binding.etConsultNotes.text.toString().trim()
            if (notes.isEmpty()) {
                binding.etConsultNotes.error = "Por favor ingresa las notas médicas"
                binding.etConsultNotes.requestFocus()
                return@setOnClickListener
            }
            Toast.makeText(this, R.string.msg_consult_finished, Toast.LENGTH_SHORT).show()
            finish()
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
}

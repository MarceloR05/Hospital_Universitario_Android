package sv.edu.catolica.hospital_universitario

import android.content.Intent
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

        // Bottom Navigation Tabs clicks
        binding.tabInicio.setOnClickListener {
            val intent = Intent(this, DoctorHomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabCitas.setOnClickListener {
            val intent = Intent(this, DoctorAppointmentsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabConsulta.setOnClickListener {
            Toast.makeText(this, R.string.nav_doctor_consult, Toast.LENGTH_SHORT).show()
        }

        binding.tabExpediente.setOnClickListener {
            val intent = Intent(this, DoctorRecordsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabMas.setOnClickListener {
            val intent = Intent(this, DoctorMoreActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

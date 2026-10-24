package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorAppointmentsBinding

class DoctorAppointmentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorAppointmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de citas médicas", Toast.LENGTH_SHORT).show()
        }

        // Appointment cards clicks
        binding.cardApt1.setOnClickListener {
            // Open DoctorConsultActivity for the selected appointment patient
            val intent = Intent(this, DoctorConsultActivity::class.java)
            startActivity(intent)
        }

        binding.cardApt2.setOnClickListener {
            val intent = Intent(this, DoctorConsultActivity::class.java)
            startActivity(intent)
        }

        binding.cardApt3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_doctor_appointment_details)} ${getString(R.string.doc_apt_3_time_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardApt4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_doctor_appointment_details)} ${getString(R.string.doc_apt_4_time_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardApt5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_doctor_appointment_details)} ${getString(R.string.doc_apt_5_time_name)}", Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation Tabs clicks
        binding.tabInicio.setOnClickListener {
            val intent = Intent(this, DoctorHomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabCitas.setOnClickListener {
            Toast.makeText(this, R.string.nav_doctor_appointments, Toast.LENGTH_SHORT).show()
        }

        binding.tabConsulta.setOnClickListener {
            val intent = Intent(this, DoctorConsultActivity::class.java)
            startActivity(intent)
            finish()
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

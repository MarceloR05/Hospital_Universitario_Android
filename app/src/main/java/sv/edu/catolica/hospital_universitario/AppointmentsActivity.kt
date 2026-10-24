package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityAppointmentsBinding

class AppointmentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de citas", Toast.LENGTH_SHORT).show()
        }

        // Appointment cards clicks
        binding.cardApt1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_appointment_details)} ${getString(R.string.apt_1_time_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardApt2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_appointment_details)} ${getString(R.string.apt_2_time_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardApt3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_appointment_details)} ${getString(R.string.apt_3_time_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardApt4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_appointment_details)} ${getString(R.string.apt_4_time_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardApt5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_appointment_details)} ${getString(R.string.apt_5_time_name)}", Toast.LENGTH_SHORT).show()
        }

        // + Agendar cita button click
        binding.btnNewAppointment.setOnClickListener {
            Toast.makeText(this, R.string.msg_new_appointment, Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation Tabs clicks
        binding.tabInicio.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabPacientes.setOnClickListener {
            val intent = Intent(this, PatientsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabCitas.setOnClickListener {
            // Already here
            Toast.makeText(this, R.string.nav_appointments, Toast.LENGTH_SHORT).show()
        }

        binding.tabTurnos.setOnClickListener {
            val intent = Intent(this, TurnsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabMas.setOnClickListener {
            val intent = Intent(this, AdmissionsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

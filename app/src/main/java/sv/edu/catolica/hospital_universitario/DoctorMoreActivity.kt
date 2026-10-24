package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorMoreBinding

class DoctorMoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda en opciones del sistema", Toast.LENGTH_SHORT).show()
        }

        // Option cards clicks
        binding.cardOpt1.setOnClickListener {
            val intent = Intent(this, DoctorLabActivity::class.java)
            startActivity(intent)
        }

        binding.cardOpt2.setOnClickListener {
            val intent = Intent(this, DoctorPrescriptionsActivity::class.java)
            startActivity(intent)
        }

        binding.cardOpt3.setOnClickListener {
            val intent = Intent(this, DoctorScheduleActivity::class.java)
            startActivity(intent)
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
            Toast.makeText(this, R.string.nav_more, Toast.LENGTH_SHORT).show()
        }
    }
}

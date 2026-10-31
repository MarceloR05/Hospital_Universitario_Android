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

        binding.cardOpt4.setOnClickListener {
            Navigator.logout(this)
        }

        // Bottom Navigation (Médico)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.DoctorTab.MORE,
            tabInicio = binding.tabInicio,
            tabCitas = binding.tabCitas,
            tabConsulta = binding.tabConsulta,
            tabExpediente = binding.tabExpediente,
            tabMas = binding.tabMas
        )
    }
}

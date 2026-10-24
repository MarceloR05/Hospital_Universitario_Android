package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de servicios y pacientes", Toast.LENGTH_SHORT).show()
        }

        // Quick Actions clicks
        binding.cardAction1.setOnClickListener {
            // Navigate to PatientsActivity
            val intent = Intent(this, PatientsActivity::class.java)
            startActivity(intent)
        }

        binding.cardAction2.setOnClickListener {
            // Navigate to AppointmentsActivity
            val intent = Intent(this, AppointmentsActivity::class.java)
            startActivity(intent)
        }

        binding.cardAction3.setOnClickListener {
            // Navigate to AdmissionsActivity
            val intent = Intent(this, AdmissionsActivity::class.java)
            startActivity(intent)
        }

        binding.cardAction4.setOnClickListener {
            // Navigate to RoomsActivity
            val intent = Intent(this, RoomsActivity::class.java)
            startActivity(intent)
        }

        // Bottom Navigation Tabs clicks
        binding.tabInicio.setOnClickListener {
            // Already on home
            Toast.makeText(this, R.string.nav_inicio, Toast.LENGTH_SHORT).show()
        }

        binding.tabPacientes.setOnClickListener {
            val intent = Intent(this, PatientsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabCitas.setOnClickListener {
            val intent = Intent(this, AppointmentsActivity::class.java)
            startActivity(intent)
            finish()
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

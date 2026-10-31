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

        // Bottom Navigation (Recepción)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.ReceptionTab.HOME,
            tabInicio = binding.tabInicio,
            tabPacientes = binding.tabPacientes,
            tabCitas = binding.tabCitas,
            tabTurnos = binding.tabTurnos,
            tabMas = binding.tabMas
        )
    }
}

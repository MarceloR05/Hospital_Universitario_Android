package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingMoreBinding

class NursingMoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNursingMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, R.string.msg_search_more_options, Toast.LENGTH_SHORT).show()
        }

        // Option cards clicks
        binding.cardOpt1.setOnClickListener {
            Navigator.goToNursingTurns(this)
        }

        binding.cardOpt2.setOnClickListener {
            Navigator.goToNursingIndications(this)
        }

        binding.cardOpt3.setOnClickListener {
            Navigator.showLogoutSnackbar(this)
        }

        // Bottom Navigation (Enfermería)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.NursingTab.MORE,
            tabInicio = binding.tabInicio,
            tabPacientes = binding.tabPacientes,
            tabPreconsulta = binding.tabPreconsulta,
            tabHabitaciones = binding.tabHabitaciones,
            tabMas = binding.tabMas
        )
    }
}

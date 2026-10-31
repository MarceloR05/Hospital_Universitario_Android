package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityReceptionMoreBinding

class ReceptionMoreActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReceptionMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceptionMoreBinding.inflate(layoutInflater)
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
            Navigator.goToAdmissions(this)
        }

        binding.cardOpt2.setOnClickListener {
            Navigator.goToRooms(this)
        }

        binding.cardOpt3.setOnClickListener {
            Navigator.showLogoutSnackbar(this)
        }

        // Bottom Navigation (Recepción)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.ReceptionTab.MORE,
            tabInicio = binding.tabInicio,
            tabPacientes = binding.tabPacientes,
            tabCitas = binding.tabCitas,
            tabTurnos = binding.tabTurnos,
            tabMas = binding.tabMas
        )
    }
}

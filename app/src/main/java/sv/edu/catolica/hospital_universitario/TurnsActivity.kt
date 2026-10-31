package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityTurnsBinding

class TurnsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTurnsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurnsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de turnos de atención", Toast.LENGTH_SHORT).show()
        }

        // Turn cards clicks
        binding.cardTurn1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_turn_details)} ${getString(R.string.turn_1_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardTurn2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_turn_details)} ${getString(R.string.turn_2_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardTurn3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_turn_details)} ${getString(R.string.turn_3_name)}", Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation (Recepción)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.ReceptionTab.TURNS,
            tabInicio = binding.tabInicio,
            tabPacientes = binding.tabPacientes,
            tabCitas = binding.tabCitas,
            tabTurnos = binding.tabTurnos,
            tabMas = binding.tabMas
        )
    }
}

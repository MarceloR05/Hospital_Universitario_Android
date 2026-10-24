package sv.edu.catolica.hospital_universitario

import android.content.Intent
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
            val intent = Intent(this, AppointmentsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabTurnos.setOnClickListener {
            // Already here
            Toast.makeText(this, R.string.nav_turns, Toast.LENGTH_SHORT).show()
        }

        binding.tabMas.setOnClickListener {
            val intent = Intent(this, AdmissionsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

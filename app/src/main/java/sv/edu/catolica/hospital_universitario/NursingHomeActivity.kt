package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingHomeBinding

class NursingHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNursingHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de tareas y pacientes", Toast.LENGTH_SHORT).show()
        }

        // Summary Cards clicks
        binding.cardStat1.setOnClickListener {
            val intent = Intent(this, NursingPatientsActivity::class.java)
            startActivity(intent)
        }

        binding.cardStat2.setOnClickListener {
            // Navigate to NursingPreconsultActivity
            val intent = Intent(this, NursingPreconsultActivity::class.java)
            startActivity(intent)
        }

        binding.cardStat3.setOnClickListener {
            // Navigate to NursingIndicationsActivity
            val intent = Intent(this, NursingIndicationsActivity::class.java)
            startActivity(intent)
        }

        binding.cardStat4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.nursing_stat_shift_change)}: 1 nota", Toast.LENGTH_SHORT).show()
        }

        // Quick Actions clicks
        binding.cardAction1.setOnClickListener {
            // Navigate to NursingPreconsultActivity
            val intent = Intent(this, NursingPreconsultActivity::class.java)
            startActivity(intent)
        }

        binding.cardAction2.setOnClickListener {
            // Navigate to NursingPatientsActivity
            val intent = Intent(this, NursingPatientsActivity::class.java)
            startActivity(intent)
        }

        binding.cardAction3.setOnClickListener {
            // Navigate to NursingRoomsActivity
            val intent = Intent(this, NursingRoomsActivity::class.java)
            startActivity(intent)
        }

        binding.cardAction4.setOnClickListener {
            // Navigate to NursingIndicationsActivity
            val intent = Intent(this, NursingIndicationsActivity::class.java)
            startActivity(intent)
        }

        // Bottom Navigation Tabs clicks
        binding.tabInicio.setOnClickListener {
            Toast.makeText(this, R.string.nav_inicio, Toast.LENGTH_SHORT).show()
        }

        binding.tabPacientes.setOnClickListener {
            val intent = Intent(this, NursingPatientsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabPreconsulta.setOnClickListener {
            val intent = Intent(this, NursingPreconsultActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabHabitaciones.setOnClickListener {
            val intent = Intent(this, NursingRoomsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabMas.setOnClickListener {
            val intent = Intent(this, NursingTurnsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

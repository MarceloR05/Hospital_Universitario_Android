package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingTurnsBinding

class NursingTurnsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNursingTurnsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingTurnsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de turnos laborales", Toast.LENGTH_SHORT).show()
        }

        // Next guard card click
        binding.cardNextGuard.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_shift_details)} ${getString(R.string.nursing_next_guard_date)} - ${getString(R.string.nursing_next_guard_time)}", Toast.LENGTH_SHORT).show()
        }

        // Shift cards clicks
        binding.cardShift1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_shift_details)} ${getString(R.string.day_1_name)} (${getString(R.string.day_1_time)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardShift2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_shift_details)} ${getString(R.string.day_2_name)} (${getString(R.string.day_2_time)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardShift3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_shift_details)} ${getString(R.string.day_3_name)} (${getString(R.string.day_3_time)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardShift4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_shift_details)} ${getString(R.string.day_4_name)} (${getString(R.string.day_4_desc)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardShift5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_shift_details)} ${getString(R.string.day_5_name)} (${getString(R.string.day_5_time)})", Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation Tabs clicks
        binding.tabInicio.setOnClickListener {
            val intent = Intent(this, NursingHomeActivity::class.java)
            startActivity(intent)
            finish()
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
            Toast.makeText(this, R.string.nav_more, Toast.LENGTH_SHORT).show()
        }
    }
}

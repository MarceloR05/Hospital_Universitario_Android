package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingRoomsBinding

class NursingRoomsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNursingRoomsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingRoomsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de habitaciones de enfermería", Toast.LENGTH_SHORT).show()
        }

        // Room cards clicks
        binding.cardRoom1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_nursing_room_details)} ${getString(R.string.nursing_room_1_name)} (${getString(R.string.nursing_room_1_patient)} - ${getString(R.string.status_occupied)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardRoom2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_nursing_room_details)} ${getString(R.string.nursing_room_2_name)} (${getString(R.string.nursing_room_2_patient)} - ${getString(R.string.status_available)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardRoom3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_nursing_room_details)} ${getString(R.string.nursing_room_3_name)} (${getString(R.string.nursing_room_3_patient)} - ${getString(R.string.status_occupied)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardRoom4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_nursing_room_details)} ${getString(R.string.nursing_room_4_name)} (${getString(R.string.nursing_room_4_patient)} - ${getString(R.string.status_occupied)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardRoom5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_nursing_room_details)} ${getString(R.string.nursing_room_5_name)} (${getString(R.string.nursing_room_5_patient)} - ${getString(R.string.status_available)})", Toast.LENGTH_SHORT).show()
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
            // Already here
            Toast.makeText(this, R.string.nav_nursing_rooms, Toast.LENGTH_SHORT).show()
        }

        binding.tabMas.setOnClickListener {
            val intent = Intent(this, NursingTurnsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

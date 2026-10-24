package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityRoomsBinding

class RoomsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de disponibilidad de habitaciones", Toast.LENGTH_SHORT).show()
        }

        // Room cards clicks
        binding.cardRoom1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_room_details)} VIP-301 (${getString(R.string.status_occupied)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardRoom2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_room_details)} VIP-302 (${getString(R.string.status_available)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardRoom3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_room_details)} VIP-303 (${getString(R.string.status_occupied)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardRoom4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_room_details)} VIP-304 (${getString(R.string.status_occupied)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardRoom5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_room_details)} VIP-305 (${getString(R.string.status_available)})", Toast.LENGTH_SHORT).show()
        }

        // Consult link click
        binding.tvConsultLink.setOnClickListener {
            Toast.makeText(this, "Consultando disponibilidad completa...", Toast.LENGTH_SHORT).show()
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

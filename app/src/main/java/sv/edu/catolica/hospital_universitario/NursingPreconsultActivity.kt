package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingPreconsultBinding

class NursingPreconsultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNursingPreconsultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingPreconsultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de preconsulta", Toast.LENGTH_SHORT).show()
        }

        // Patient card click
        binding.cardSelectedPatient.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_nursing_patient_details)} ${getString(R.string.nursing_selected_patient_name)}", Toast.LENGTH_SHORT).show()
        }

        // Save preconsult button click
        binding.btnSavePreconsult.setOnClickListener {
            Toast.makeText(this, R.string.msg_preconsult_saved, Toast.LENGTH_SHORT).show()
            finish()
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
            // Already here
            Toast.makeText(this, R.string.nav_nursing_preconsult, Toast.LENGTH_SHORT).show()
        }

        binding.tabHabitaciones.setOnClickListener {
            Toast.makeText(this, R.string.nav_nursing_rooms, Toast.LENGTH_SHORT).show()
        }

        binding.tabMas.setOnClickListener {
            Toast.makeText(this, R.string.msg_feature_in_development, Toast.LENGTH_SHORT).show()
        }
    }
}

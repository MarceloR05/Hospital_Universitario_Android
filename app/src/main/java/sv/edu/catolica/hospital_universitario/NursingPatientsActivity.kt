package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingPatientsBinding

class NursingPatientsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNursingPatientsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingPatientsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de pacientes asignados", Toast.LENGTH_SHORT).show()
        }

        // Patient cards clicks
        binding.cardPatient1.setOnClickListener {
            // Navigate to NursingPreconsultActivity for preconsultation evaluation
            val intent = Intent(this, NursingPreconsultActivity::class.java)
            startActivity(intent)
        }

        binding.cardPatient2.setOnClickListener {
            val intent = Intent(this, NursingPreconsultActivity::class.java)
            startActivity(intent)
        }

        binding.cardPatient3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_nursing_patient_details)} ${getString(R.string.nursing_pat_3_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardPatient4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_nursing_patient_details)} ${getString(R.string.nursing_pat_4_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardPatient5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_nursing_patient_details)} ${getString(R.string.nursing_pat_5_name)}", Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation Tabs clicks
        binding.tabInicio.setOnClickListener {
            val intent = Intent(this, NursingHomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabPacientes.setOnClickListener {
            Toast.makeText(this, R.string.nav_patients, Toast.LENGTH_SHORT).show()
        }

        binding.tabPreconsulta.setOnClickListener {
            val intent = Intent(this, NursingPreconsultActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabHabitaciones.setOnClickListener {
            Toast.makeText(this, R.string.nav_nursing_rooms, Toast.LENGTH_SHORT).show()
        }

        binding.tabMas.setOnClickListener {
            Toast.makeText(this, R.string.msg_feature_in_development, Toast.LENGTH_SHORT).show()
        }
    }
}

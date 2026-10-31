package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityPatientsBinding

class PatientsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPatientsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatientsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de pacientes", Toast.LENGTH_SHORT).show()
        }

        // View Record clicks for each patient
        binding.btnViewRecord1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_view_record)} ${getString(R.string.patient_1_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.btnViewRecord2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_view_record)} ${getString(R.string.patient_2_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.btnViewRecord3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_view_record)} ${getString(R.string.patient_3_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.btnViewRecord4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_view_record)} ${getString(R.string.patient_4_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.btnViewRecord5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_view_record)} ${getString(R.string.patient_5_name)}", Toast.LENGTH_SHORT).show()
        }

        // + Nuevo paciente button click
        binding.btnNewPatient.setOnClickListener {
            Toast.makeText(this, R.string.msg_new_patient, Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation (Recepción)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.ReceptionTab.PATIENTS,
            tabInicio = binding.tabInicio,
            tabPacientes = binding.tabPacientes,
            tabCitas = binding.tabCitas,
            tabTurnos = binding.tabTurnos,
            tabMas = binding.tabMas
        )
    }
}

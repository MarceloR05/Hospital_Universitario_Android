package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorHomeBinding

class DoctorHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de pacientes y citas médicas", Toast.LENGTH_SHORT).show()
        }

        // Summary Cards clicks
        binding.cardStat1.setOnClickListener {
            val intent = Intent(this, DoctorAppointmentsActivity::class.java)
            startActivity(intent)
        }

        binding.cardStat2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.doctor_stat_inpatients)}: 5 pacientes internados", Toast.LENGTH_SHORT).show()
        }

        binding.cardStat3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.doctor_stat_waiting)}: 3 en sala de espera", Toast.LENGTH_SHORT).show()
        }

        binding.cardStat4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.doctor_stat_prescriptions)}: 12 recetas pendientes", Toast.LENGTH_SHORT).show()
        }

        // Quick Actions clicks
        binding.cardAction1.setOnClickListener {
            val intent = Intent(this, DoctorAppointmentsActivity::class.java)
            startActivity(intent)
        }

        binding.cardAction2.setOnClickListener {
            val intent = Intent(this, DoctorConsultActivity::class.java)
            startActivity(intent)
        }

        binding.cardAction3.setOnClickListener {
            val intent = Intent(this, DoctorRecordsActivity::class.java)
            startActivity(intent)
        }

        // Bottom Navigation (Médico)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.DoctorTab.HOME,
            tabInicio = binding.tabInicio,
            tabCitas = binding.tabCitas,
            tabConsulta = binding.tabConsulta,
            tabExpediente = binding.tabExpediente,
            tabMas = binding.tabMas
        )
    }
}

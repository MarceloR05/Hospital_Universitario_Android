package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorPrescriptionsBinding

class DoctorPrescriptionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorPrescriptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorPrescriptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de recetas y prescripciones", Toast.LENGTH_SHORT).show()
        }

        // Prescription cards clicks
        binding.cardRx1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_prescription_details)} ${getString(R.string.rx_1_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardRx2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_prescription_details)} ${getString(R.string.rx_2_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardRx3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_prescription_details)} ${getString(R.string.rx_3_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardRx4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_prescription_details)} ${getString(R.string.rx_4_name)}", Toast.LENGTH_SHORT).show()
        }

        // Allergy banner click
        binding.cardAllergyBanner.setOnClickListener {
            Toast.makeText(this, getString(R.string.doctor_prescriptions_allergy_banner), Toast.LENGTH_SHORT).show()
        }

        // New prescription button click
        binding.btnNewPrescription.setOnClickListener {
            Toast.makeText(this, getString(R.string.msg_new_prescription), Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation (Médico)
        // Recetas no es una pestaña de la barra: ninguna queda marcada.
        Navigator.setupBottomNav(
            activity = this,
            currentTab = null,
            tabInicio = binding.tabInicio,
            tabCitas = binding.tabCitas,
            tabConsulta = binding.tabConsulta,
            tabExpediente = binding.tabExpediente,
            tabMas = binding.tabMas
        )
    }
}

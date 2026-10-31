package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorLabBinding

class DoctorLabActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorLabBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorLabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de órdenes de laboratorio", Toast.LENGTH_SHORT).show()
        }

        // Lab cards clicks
        binding.cardLab1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_lab_details)} ${getString(R.string.lab_1_name)} - ${getString(R.string.lab_1_meta)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardLab2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_lab_details)} ${getString(R.string.lab_2_name)} - ${getString(R.string.lab_2_meta)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardLab3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_lab_details)} ${getString(R.string.lab_3_name)} - ${getString(R.string.lab_3_meta)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardLab4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_lab_details)} ${getString(R.string.lab_4_name)} - ${getString(R.string.lab_4_meta)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardLab5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_lab_details)} ${getString(R.string.lab_5_name)} - ${getString(R.string.lab_5_meta)}", Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation (Médico)
        // Laboratorio no es una pestaña de la barra: ninguna queda marcada.
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

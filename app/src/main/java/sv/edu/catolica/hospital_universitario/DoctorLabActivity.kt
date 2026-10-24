package sv.edu.catolica.hospital_universitario

import android.content.Intent
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

        // Bottom Navigation Tabs clicks
        binding.tabInicio.setOnClickListener {
            val intent = Intent(this, DoctorHomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabCitas.setOnClickListener {
            val intent = Intent(this, DoctorAppointmentsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabConsulta.setOnClickListener {
            val intent = Intent(this, DoctorConsultActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabExpediente.setOnClickListener {
            val intent = Intent(this, DoctorRecordsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabMas.setOnClickListener {
            val intent = Intent(this, DoctorMoreActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

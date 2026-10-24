package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorRecordsBinding

class DoctorRecordsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorRecordsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorRecordsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda en expediente clínico", Toast.LENGTH_SHORT).show()
        }

        // Summary cards clicks
        binding.cardRec1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_doctor_record_details)} ${getString(R.string.doc_rec_1_title)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardRec2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_doctor_record_details)} ${getString(R.string.doc_rec_2_title)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardRec3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_doctor_record_details)} ${getString(R.string.doc_rec_3_title)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardRec4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_doctor_record_details)} ${getString(R.string.doc_rec_4_title)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardRec5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_doctor_record_details)} ${getString(R.string.doc_rec_5_title)}", Toast.LENGTH_SHORT).show()
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
            Toast.makeText(this, R.string.nav_doctor_records, Toast.LENGTH_SHORT).show()
        }

        binding.tabMas.setOnClickListener {
            val intent = Intent(this, DoctorMoreActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

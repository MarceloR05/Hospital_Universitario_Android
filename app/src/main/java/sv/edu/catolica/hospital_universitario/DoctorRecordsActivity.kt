package sv.edu.catolica.hospital_universitario

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

        // Bottom Navigation (Médico)
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.DoctorTab.RECORDS,
            tabInicio = binding.tabInicio,
            tabCitas = binding.tabCitas,
            tabConsulta = binding.tabConsulta,
            tabExpediente = binding.tabExpediente,
            tabMas = binding.tabMas
        )
    }
}

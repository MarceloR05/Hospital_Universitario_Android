package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorScheduleBinding

class DoctorScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda en mi horario", Toast.LENGTH_SHORT).show()
        }

        // Next shift card click
        binding.cardNextShift.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_schedule_details)} ${getString(R.string.doctor_next_shift_date)} - ${getString(R.string.doctor_next_shift_time)}", Toast.LENGTH_SHORT).show()
        }

        // Shift cards clicks
        binding.cardShift1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_schedule_details)} ${getString(R.string.doc_sch_1_day)} (${getString(R.string.doc_sch_1_time)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardShift2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_schedule_details)} ${getString(R.string.doc_sch_2_day)} (${getString(R.string.doc_sch_2_time)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardShift3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_schedule_details)} ${getString(R.string.doc_sch_3_day)} (${getString(R.string.doc_sch_3_time)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardShift4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_schedule_details)} ${getString(R.string.doc_sch_4_day)} (${getString(R.string.doc_sch_4_desc)})", Toast.LENGTH_SHORT).show()
        }

        binding.cardShift5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_schedule_details)} ${getString(R.string.doc_sch_5_day)} (${getString(R.string.doc_sch_5_desc)})", Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation (Médico)
        // Horario no es una pestaña de la barra: ninguna queda marcada.
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

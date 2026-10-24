package sv.edu.catolica.hospital_universitario

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityAdmissionsBinding

class AdmissionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdmissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdmissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de ingresos", Toast.LENGTH_SHORT).show()
        }

        // Admission cards clicks
        binding.cardAdm1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_admission_details)} ${getString(R.string.adm_1_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardAdm2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_admission_details)} ${getString(R.string.adm_2_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardAdm3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_admission_details)} ${getString(R.string.adm_3_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardAdm4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_admission_details)} ${getString(R.string.adm_4_name)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardAdm5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_admission_details)} ${getString(R.string.adm_5_name)}", Toast.LENGTH_SHORT).show()
        }

        // + Nuevo ingreso button click
        binding.btnNewAdmission.setOnClickListener {
            Toast.makeText(this, R.string.msg_new_admission, Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation Tabs clicks
        binding.tabInicio.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabPacientes.setOnClickListener {
            val intent = Intent(this, PatientsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabCitas.setOnClickListener {
            val intent = Intent(this, AppointmentsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabTurnos.setOnClickListener {
            val intent = Intent(this, TurnsActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tabMas.setOnClickListener {
            Toast.makeText(this, R.string.nav_more, Toast.LENGTH_SHORT).show()
        }
    }
}

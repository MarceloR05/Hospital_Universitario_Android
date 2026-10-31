package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingIndicationsBinding

class NursingIndicationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNursingIndicationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingIndicationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Search bar click
        binding.cardSearch.setOnClickListener {
            Toast.makeText(this, "Búsqueda de indicaciones autorizadas", Toast.LENGTH_SHORT).show()
        }

        // Indication cards clicks
        binding.cardInd1.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_indication_details)} ${getString(R.string.ind_1_name)} - ${getString(R.string.ind_1_meta)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardInd2.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_indication_details)} ${getString(R.string.ind_2_name)} - ${getString(R.string.ind_2_meta)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardInd3.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_indication_details)} ${getString(R.string.ind_3_name)} - ${getString(R.string.ind_3_meta)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardInd4.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_indication_details)} ${getString(R.string.ind_4_name)} - ${getString(R.string.ind_4_meta)}", Toast.LENGTH_SHORT).show()
        }

        binding.cardInd5.setOnClickListener {
            Toast.makeText(this, "${getString(R.string.msg_indication_details)} ${getString(R.string.ind_5_name)} - ${getString(R.string.ind_5_meta)}", Toast.LENGTH_SHORT).show()
        }

        // Bottom Navigation (Enfermería)
        // Indicaciones no es una pestaña de la barra: ninguna queda marcada.
        Navigator.setupBottomNav(
            activity = this,
            currentTab = null,
            tabInicio = binding.tabInicio,
            tabPacientes = binding.tabPacientes,
            tabPreconsulta = binding.tabPreconsulta,
            tabHabitaciones = binding.tabHabitaciones,
            tabMas = binding.tabMas
        )
    }
}

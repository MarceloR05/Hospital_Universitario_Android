package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorPrescriptionsBinding

class DoctorPrescriptionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorPrescriptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorPrescriptionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lista, búsqueda, detalle y formularios (ver ListScreen / ListConfigs)
        ListScreen(
            activity = this,
            repository = AppContainer.prescriptionRepository,
            config = ListConfigs.prescriptions(),
            views = ListScreen.Views(
                recycler = binding.rvList,
                empty = binding.tvEmpty,
                search = binding.etSearch,
                clearSearch = binding.btnClearSearch,
                searchCard = binding.cardSearch,
                newButton = binding.btnNewPrescription,
                root = binding.root,
                snackbarAnchor = binding.bottomNavContainer
            )
        ).attach()

        // Aviso de seguridad del paciente
        binding.cardAllergyBanner.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.cfg_rx_allergy_title)
                .setMessage(R.string.cfg_rx_allergy_notice)
                .setPositiveButton(R.string.list_close, null)
                .show()
        }

        // Bottom Navigation
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

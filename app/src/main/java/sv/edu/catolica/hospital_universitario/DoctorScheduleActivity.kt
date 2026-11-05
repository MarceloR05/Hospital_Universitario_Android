package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorScheduleBinding

class DoctorScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorScheduleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lista, búsqueda, detalle y formularios (ver ListScreen / ListConfigs)
        ListScreen(
            activity = this,
            repository = AppContainer.doctorScheduleRepository,
            config = ListConfigs.schedule(),
            views = ListScreen.Views(
                recycler = binding.rvList,
                empty = binding.tvEmpty,
                search = binding.etSearch,
                clearSearch = binding.btnClearSearch,
                searchCard = binding.cardSearch,
                newButton = null,
                root = binding.root,
                snackbarAnchor = binding.bottomNavContainer
            )
        ).attach()

        // Próximo turno: muestra el detalle
        binding.cardNextShift.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(binding.tvShiftDate.text)
                .setMessage("${binding.tvShiftTime.text}\n${binding.tvShiftStatus.text}")
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

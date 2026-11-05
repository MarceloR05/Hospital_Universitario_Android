package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingTurnsBinding

class NursingTurnsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNursingTurnsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingTurnsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lista, búsqueda, detalle y formularios (ver ListScreen / ListConfigs)
        ListScreen(
            activity = this,
            repository = AppContainer.nursingTurnRepository,
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

        // Próxima guardia: muestra el detalle
        binding.cardNextGuard.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle(binding.tvGuardDate.text)
                .setMessage("${binding.tvGuardTime.text}\n${binding.tvGuardStatus.text}")
                .setPositiveButton(R.string.list_close, null)
                .show()
        }

        // Bottom Navigation
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

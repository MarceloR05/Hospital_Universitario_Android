package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityNursingIndicationsBinding

class NursingIndicationsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNursingIndicationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNursingIndicationsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lista, búsqueda, detalle y formularios (ver ListScreen / ListConfigs)
        ListScreen(
            activity = this,
            repository = AppContainer.nursingIndicationRepository,
            config = ListConfigs.nursingIndications(),
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

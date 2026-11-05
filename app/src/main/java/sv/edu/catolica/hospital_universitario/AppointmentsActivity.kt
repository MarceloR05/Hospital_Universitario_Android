package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityAppointmentsBinding

class AppointmentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppointmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lista, búsqueda, detalle y formularios (ver ListScreen / ListConfigs)
        ListScreen(
            activity = this,
            repository = AppContainer.appointmentRepository,
            config = ListConfigs.appointments(),
            views = ListScreen.Views(
                recycler = binding.rvList,
                empty = binding.tvEmpty,
                search = binding.etSearch,
                clearSearch = binding.btnClearSearch,
                searchCard = binding.cardSearch,
                newButton = binding.btnNewAppointment,
                root = binding.root,
                snackbarAnchor = binding.bottomNavContainer
            )
        ).attach()

        // Bottom Navigation
        Navigator.setupBottomNav(
            activity = this,
            currentTab = Navigator.ReceptionTab.APPOINTMENTS,
            tabInicio = binding.tabInicio,
            tabPacientes = binding.tabPacientes,
            tabCitas = binding.tabCitas,
            tabTurnos = binding.tabTurnos,
            tabMas = binding.tabMas
        )
    }
}

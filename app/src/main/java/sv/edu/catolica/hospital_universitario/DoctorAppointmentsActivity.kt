package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityDoctorAppointmentsBinding

class DoctorAppointmentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoctorAppointmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lista, búsqueda, detalle y formularios (ver ListScreen / ListConfigs)
        ListScreen(
            activity = this,
            repository = AppContainer.doctorAppointmentRepository,
            config = ListConfigs.doctorAppointments(this),
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
            currentTab = Navigator.DoctorTab.APPOINTMENTS,
            tabInicio = binding.tabInicio,
            tabCitas = binding.tabCitas,
            tabConsulta = binding.tabConsulta,
            tabExpediente = binding.tabExpediente,
            tabMas = binding.tabMas
        )
    }
}

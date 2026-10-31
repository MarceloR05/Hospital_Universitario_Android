package sv.edu.catolica.hospital_universitario

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * Navegación centralizada.
 *
 * Las pantallas no crean Intents: piden el destino aquí. Cuando cambie la forma de
 * navegar (por ejemplo al enchufar la base de datos real) se toca un solo archivo.
 */
object Navigator {

    /** Pestañas de la barra inferior del rol Recepción. */
    enum class ReceptionTab(@param:StringRes val titleRes: Int) {
        HOME(R.string.nav_inicio),
        PATIENTS(R.string.nav_patients),
        APPOINTMENTS(R.string.nav_appointments),
        TURNS(R.string.nav_turns),
        MORE(R.string.nav_more)
    }

    // ---------------------------------------------------------------------
    // Recepción
    // ---------------------------------------------------------------------

    fun goToLogin(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, MainActivity::class.java, closeCurrent)

    fun goToReceptionHome(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, HomeActivity::class.java, closeCurrent)

    fun goToPatients(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, PatientsActivity::class.java, closeCurrent)

    fun goToAppointments(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, AppointmentsActivity::class.java, closeCurrent)

    fun goToTurns(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, TurnsActivity::class.java, closeCurrent)

    fun goToAdmissions(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, AdmissionsActivity::class.java, closeCurrent)

    fun goToRooms(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, RoomsActivity::class.java, closeCurrent)

    // ---------------------------------------------------------------------
    // Enfermería
    // ---------------------------------------------------------------------

    fun goToNursingHome(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, NursingHomeActivity::class.java, closeCurrent)

    fun goToNursingPatients(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, NursingPatientsActivity::class.java, closeCurrent)

    fun goToNursingPreconsult(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, NursingPreconsultActivity::class.java, closeCurrent)

    fun goToNursingRooms(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, NursingRoomsActivity::class.java, closeCurrent)

    fun goToNursingTurns(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, NursingTurnsActivity::class.java, closeCurrent)

    fun goToNursingIndications(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, NursingIndicationsActivity::class.java, closeCurrent)

    // ---------------------------------------------------------------------
    // Médico
    // ---------------------------------------------------------------------

    fun goToDoctorHome(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, DoctorHomeActivity::class.java, closeCurrent)

    fun goToDoctorAppointments(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, DoctorAppointmentsActivity::class.java, closeCurrent)

    fun goToDoctorConsult(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, DoctorConsultActivity::class.java, closeCurrent)

    fun goToDoctorRecords(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, DoctorRecordsActivity::class.java, closeCurrent)

    fun goToDoctorMore(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, DoctorMoreActivity::class.java, closeCurrent)

    fun goToDoctorLab(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, DoctorLabActivity::class.java, closeCurrent)

    fun goToDoctorPrescriptions(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, DoctorPrescriptionsActivity::class.java, closeCurrent)

    fun goToDoctorSchedule(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, DoctorScheduleActivity::class.java, closeCurrent)

    // ---------------------------------------------------------------------
    // Barra inferior del rol Recepción
    // ---------------------------------------------------------------------

    /**
     * Conecta las cinco pestañas de la barra inferior de Recepción.
     *
     * [currentTab] es la pestaña de la pantalla actual: al pulsarla se muestra el
     * Toast del nombre de la sección, igual que antes. Pasa `null` si la pantalla
     * no está en la barra (habitaciones), para que todas las pestañas naveguen.
     */
    fun setupBottomNav(
        activity: Activity,
        currentTab: ReceptionTab?,
        tabInicio: View,
        tabPacientes: View,
        tabCitas: View,
        tabTurnos: View,
        tabMas: View
    ) {
        bindTab(activity, tabInicio, ReceptionTab.HOME, currentTab) {
            goToReceptionHome(activity, closeCurrent = true)
        }
        bindTab(activity, tabPacientes, ReceptionTab.PATIENTS, currentTab) {
            goToPatients(activity, closeCurrent = true)
        }
        bindTab(activity, tabCitas, ReceptionTab.APPOINTMENTS, currentTab) {
            goToAppointments(activity, closeCurrent = true)
        }
        bindTab(activity, tabTurnos, ReceptionTab.TURNS, currentTab) {
            goToTurns(activity, closeCurrent = true)
        }
        // TODO: "Más" hoy abre Ingresos (comportamiento actual). Confirmar si debe
        // ser un menú propio cuando exista la pantalla de opciones.
        bindTab(activity, tabMas, ReceptionTab.MORE, currentTab) {
            goToAdmissions(activity, closeCurrent = true)
        }
    }

    private fun bindTab(
        activity: Activity,
        view: View,
        tab: ReceptionTab,
        currentTab: ReceptionTab?,
        action: () -> Unit
    ) {
        view.setOnClickListener {
            if (tab == currentTab) {
                Toast.makeText(activity, tab.titleRes, Toast.LENGTH_SHORT).show()
            } else {
                action()
            }
        }
    }

    private fun navigate(activity: Activity, target: Class<out Activity>, closeCurrent: Boolean) {
        activity.startActivity(Intent(activity, target))
        if (closeCurrent) {
            activity.finish()
        }
    }
}

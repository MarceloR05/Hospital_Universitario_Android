package sv.edu.catolica.hospital_universitario

import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

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

    /** Pestañas de la barra inferior del rol Enfermería. */
    enum class NursingTab(@param:StringRes val titleRes: Int) {
        HOME(R.string.nav_inicio),
        PATIENTS(R.string.nav_patients),
        PRECONSULT(R.string.nav_nursing_preconsult),
        ROOMS(R.string.nav_nursing_rooms),
        MORE(R.string.nav_more)
    }

    /** Pestañas de la barra inferior del rol Médico. */
    enum class DoctorTab(@param:StringRes val titleRes: Int) {
        HOME(R.string.nav_inicio),
        APPOINTMENTS(R.string.nav_doctor_appointments),
        CONSULT(R.string.nav_doctor_consult),
        RECORDS(R.string.nav_doctor_records),
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
     *
     * "Más" ya no abre una pantalla: muestra el menú con las pantallas que no
     * tienen pestaña.
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
        bindTab(activity, tabInicio, ReceptionTab.HOME.titleRes, currentTab == ReceptionTab.HOME) {
            goToReceptionHome(activity, closeCurrent = true)
        }
        bindTab(activity, tabPacientes, ReceptionTab.PATIENTS.titleRes, currentTab == ReceptionTab.PATIENTS) {
            goToPatients(activity, closeCurrent = true)
        }
        bindTab(activity, tabCitas, ReceptionTab.APPOINTMENTS.titleRes, currentTab == ReceptionTab.APPOINTMENTS) {
            goToAppointments(activity, closeCurrent = true)
        }
        bindTab(activity, tabTurnos, ReceptionTab.TURNS.titleRes, currentTab == ReceptionTab.TURNS) {
            goToTurns(activity, closeCurrent = true)
        }
        // "Más" siempre abre el menú, también en las pantallas que lo marcan como
        // pestaña actual (hoy: Ingresos).
        tabMas.setOnClickListener { showReceptionMoreMenu(activity, tabMas) }
    }

    // ---------------------------------------------------------------------
    // Barra inferior del rol Enfermería
    // ---------------------------------------------------------------------

    /**
     * Conecta las cinco pestañas de la barra inferior de Enfermería.
     *
     * [currentTab] es la pestaña de la pantalla actual y muestra su Toast al pulsarla;
     * pasa `null` si la pantalla no está en la barra (indicaciones).
     *
     * "Más" ya no abre Turnos laborales: muestra el menú con las pantallas que no
     * tienen pestaña.
     */
    fun setupBottomNav(
        activity: Activity,
        currentTab: NursingTab?,
        tabInicio: View,
        tabPacientes: View,
        tabPreconsulta: View,
        tabHabitaciones: View,
        tabMas: View
    ) {
        bindTab(activity, tabInicio, NursingTab.HOME.titleRes, currentTab == NursingTab.HOME) {
            goToNursingHome(activity, closeCurrent = true)
        }
        bindTab(activity, tabPacientes, NursingTab.PATIENTS.titleRes, currentTab == NursingTab.PATIENTS) {
            goToNursingPatients(activity, closeCurrent = true)
        }
        bindTab(activity, tabPreconsulta, NursingTab.PRECONSULT.titleRes, currentTab == NursingTab.PRECONSULT) {
            goToNursingPreconsult(activity, closeCurrent = true)
        }
        bindTab(activity, tabHabitaciones, NursingTab.ROOMS.titleRes, currentTab == NursingTab.ROOMS) {
            goToNursingRooms(activity, closeCurrent = true)
        }
        // "Más" siempre abre el menú, también en las pantallas que lo marcan como
        // pestaña actual (hoy: Turnos laborales).
        tabMas.setOnClickListener { showNursingMoreMenu(activity, tabMas) }
    }

    // ---------------------------------------------------------------------
    // Barra inferior del rol Médico
    // ---------------------------------------------------------------------

    /**
     * Conecta las cinco pestañas de la barra inferior del rol Médico.
     *
     * [currentTab] es la pestaña de la pantalla actual y muestra su Toast al pulsarla.
     * Pasa `null` en las pantallas que se abren desde "Más" y no tienen pestaña propia
     * (Laboratorio, Recetas, Horario): así las cinco pestañas navegan.
     */
    fun setupBottomNav(
        activity: Activity,
        currentTab: DoctorTab?,
        tabInicio: View,
        tabCitas: View,
        tabConsulta: View,
        tabExpediente: View,
        tabMas: View
    ) {
        bindTab(activity, tabInicio, DoctorTab.HOME.titleRes, currentTab == DoctorTab.HOME) {
            goToDoctorHome(activity, closeCurrent = true)
        }
        bindTab(activity, tabCitas, DoctorTab.APPOINTMENTS.titleRes, currentTab == DoctorTab.APPOINTMENTS) {
            goToDoctorAppointments(activity, closeCurrent = true)
        }
        bindTab(activity, tabConsulta, DoctorTab.CONSULT.titleRes, currentTab == DoctorTab.CONSULT) {
            goToDoctorConsult(activity, closeCurrent = true)
        }
        bindTab(activity, tabExpediente, DoctorTab.RECORDS.titleRes, currentTab == DoctorTab.RECORDS) {
            goToDoctorRecords(activity, closeCurrent = true)
        }
        bindTab(activity, tabMas, DoctorTab.MORE.titleRes, currentTab == DoctorTab.MORE) {
            goToDoctorMore(activity, closeCurrent = true)
        }
    }

    // ---------------------------------------------------------------------
    // Menú "Más" (Recepción y Enfermería)
    // ---------------------------------------------------------------------

    /** Menú de Recepción: pantallas sin pestaña y cierre de sesión. */
    private fun showReceptionMoreMenu(activity: Activity, anchor: View) =
        showMoreMenu(
            activity,
            anchor,
            MoreMenuEntry(R.string.admissions_title) { goToAdmissions(activity) },
            MoreMenuEntry(R.string.rooms_title) { goToRooms(activity) },
            MoreMenuEntry(R.string.menu_logout) { showLogoutSnackbar(activity) }
        )

    /** Menú de Enfermería: pantallas sin pestaña y cierre de sesión. */
    private fun showNursingMoreMenu(activity: Activity, anchor: View) =
        showMoreMenu(
            activity,
            anchor,
            MoreMenuEntry(R.string.nursing_turns_title) { goToNursingTurns(activity) },
            MoreMenuEntry(R.string.nursing_indications_title) { goToNursingIndications(activity) },
            MoreMenuEntry(R.string.menu_logout) { showLogoutSnackbar(activity) }
        )

    private fun showMoreMenu(
        activity: Activity,
        anchor: View,
        vararg entries: MoreMenuEntry
    ) {
        PopupMenu(activity, anchor).apply {
            entries.forEachIndexed { index, entry ->
                menu.add(Menu.NONE, index, index, entry.titleRes)
            }
            setOnMenuItemClickListener { item ->
                entries.getOrNull(item.itemId)?.action?.invoke()
                true
            }
            show()
        }
    }

    private fun showLogoutSnackbar(activity: Activity) {
        Snackbar.make(
            activity.findViewById(android.R.id.content),
            R.string.msg_logout_simulated,
            Snackbar.LENGTH_SHORT
        ).show()
    }

    private class MoreMenuEntry(@param:StringRes val titleRes: Int, val action: () -> Unit)

    private fun bindTab(
        activity: Activity,
        view: View,
        @StringRes currentTabTitleRes: Int,
        isCurrentTab: Boolean,
        action: () -> Unit
    ) {
        view.setOnClickListener {
            if (isCurrentTab) {
                Toast.makeText(activity, currentTabTitleRes, Toast.LENGTH_SHORT).show()
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

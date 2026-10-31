package sv.edu.catolica.hospital_universitario

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.material.dialog.MaterialAlertDialogBuilder

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

    /** Abre el Home que corresponde al [role] de la sesión. */
    fun goToHomeForRole(
        activity: Activity,
        role: SessionManager.Role,
        closeCurrent: Boolean = false
    ) {
        when (role) {
            SessionManager.Role.RECEPTION -> goToReceptionHome(activity, closeCurrent)
            SessionManager.Role.NURSING -> goToNursingHome(activity, closeCurrent)
            SessionManager.Role.DOCTOR -> goToDoctorHome(activity, closeCurrent)
        }
    }

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

    fun goToReceptionMore(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, ReceptionMoreActivity::class.java, closeCurrent)

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

    fun goToNursingMore(activity: Activity, closeCurrent: Boolean = false) =
        navigate(activity, NursingMoreActivity::class.java, closeCurrent)

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
     * no está en la barra (ingresos, habitaciones), para que todas las pestañas naveguen.
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
        bindTab(activity, tabMas, ReceptionTab.MORE.titleRes, currentTab == ReceptionTab.MORE) {
            goToReceptionMore(activity, closeCurrent = true)
        }
    }

    // ---------------------------------------------------------------------
    // Barra inferior del rol Enfermería
    // ---------------------------------------------------------------------

    /**
     * Conecta las cinco pestañas de la barra inferior de Enfermería.
     *
     * [currentTab] es la pestaña de la pantalla actual y muestra su Toast al pulsarla;
     * pasa `null` si la pantalla no está en la barra (turnos laborales, indicaciones).
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
        bindTab(activity, tabMas, NursingTab.MORE.titleRes, currentTab == NursingTab.MORE) {
            goToNursingMore(activity, closeCurrent = true)
        }
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
    // Cierre de sesión
    // ---------------------------------------------------------------------

    /**
     * Pide confirmación, limpia [SessionManager] y vuelve al login borrando toda
     * la pila de pantallas.
     */
    fun logout(activity: Activity) {
        MaterialAlertDialogBuilder(activity)
            .setTitle(R.string.dialog_logout_title)
            .setMessage(R.string.dialog_logout_message)
            .setNegativeButton(R.string.dialog_logout_cancel, null)
            .setPositiveButton(R.string.dialog_logout_confirm) { _, _ ->
                SessionManager.logout()
                val intent = Intent(activity, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                activity.startActivity(intent)
            }
            .show()
    }

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

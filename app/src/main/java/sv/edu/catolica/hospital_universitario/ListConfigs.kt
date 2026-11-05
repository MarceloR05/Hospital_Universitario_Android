package sv.edu.catolica.hospital_universitario

import android.app.Activity

/** Configuración de cada pantalla de lista: qué puede hacerse y con qué textos. */
object ListConfigs {

    private val appointmentStatuses = listOf(
        Statuses.CONFIRMADA, Statuses.EN_ESPERA, Statuses.PENDIENTE,
        Statuses.EN_CURSO, Statuses.ATENDIDA, Statuses.CANCELADA
    )

    fun appointments() = ListScreenConfig(
        statusOptions = appointmentStatuses,
        editMode = EditMode.FULL,
        canAdd = true,
        canDelete = true,
        leadMode = LeadMode.TIME,
        suggestPatients = true,
        formTitleNew = R.string.cfg_apt_new,
        formTitleEdit = R.string.cfg_apt_edit,
        titleHint = R.string.list_hint_patient,
        metaHint = R.string.cfg_apt_meta_hint
    )

    fun admissions() = ListScreenConfig(
        statusOptions = listOf(
            Statuses.INGRESADO, Statuses.INGRESADA, Statuses.OBSERVACION,
            Statuses.EN_TRIAGE, Statuses.ALTA
        ),
        editMode = EditMode.FULL,
        canAdd = true,
        canDelete = true,
        suggestPatients = true,
        formTitleNew = R.string.cfg_adm_new,
        formTitleEdit = R.string.cfg_adm_edit,
        titleHint = R.string.list_hint_patient,
        metaHint = R.string.cfg_adm_meta_hint
    )

    fun turns() = ListScreenConfig(
        statusOptions = listOf(
            Statuses.EN_ESPERA, Statuses.LLAMADO, Statuses.EN_ATENCION, Statuses.ATENDIDO
        ),
        editMode = EditMode.FULL,
        canAdd = true,
        canDelete = true,
        leadMode = LeadMode.CODE,
        codePrefix = "A-",
        suggestPatients = true,
        formTitleNew = R.string.cfg_turn_new,
        formTitleEdit = R.string.cfg_turn_edit,
        titleHint = R.string.list_hint_patient,
        metaHint = R.string.cfg_turn_meta_hint
    )

    /** El doctor no crea citas: cambia su estado o inicia la consulta. */
    fun doctorAppointments(activity: Activity) = ListScreenConfig(
        statusOptions = appointmentStatuses,
        editMode = EditMode.STATUS_ONLY,
        icon = "▦",
        extraAction = ExtraAction(R.string.cfg_start_consult) { entry ->
            AppContainer.selectedPatientName = entry.title
            Navigator.goToDoctorConsult(activity)
        }
    )

    fun lab() = ListScreenConfig(
        statusOptions = listOf(Statuses.PENDIENTE, Statuses.EN_PROCESO, Statuses.COMPLETADO),
        editMode = EditMode.FULL,
        canAdd = true,
        canDelete = true,
        leadMode = LeadMode.CODE,
        codePrefix = "LAB-",
        suggestPatients = true,
        formTitleNew = R.string.cfg_lab_new,
        formTitleEdit = R.string.cfg_lab_edit,
        titleHint = R.string.list_hint_patient,
        metaHint = R.string.cfg_lab_meta_hint
    )

    /** La dosis y el medicamento los escribe el médico; la app no sugiere nada. */
    fun prescriptions() = ListScreenConfig(
        statusOptions = listOf(Statuses.ACTIVA, Statuses.PENDIENTE, Statuses.SUSPENDIDA),
        editMode = EditMode.FULL,
        canAdd = true,
        canDelete = true,
        suggestPatients = true,
        formTitleNew = R.string.cfg_rx_new,
        formTitleEdit = R.string.cfg_rx_edit,
        titleHint = R.string.list_hint_patient,
        metaHint = R.string.cfg_rx_meta_hint,
        saveConfirmMessage = R.string.cfg_rx_confirm
    )

    /** Enfermería no crea pacientes: cambia el seguimiento o registra la preconsulta. */
    fun nursingPatients(activity: Activity) = ListScreenConfig(
        statusOptions = listOf(Statuses.EN_SEGUIMIENTO, Statuses.EN_ESPERA, Statuses.ESTABLE),
        editMode = EditMode.STATUS_ONLY,
        extraAction = ExtraAction(R.string.cfg_register_preconsult) { entry ->
            AppContainer.selectedPatientName = entry.title
            Navigator.goToNursingPreconsult(activity)
        }
    )

    /** Las indicaciones las autoriza el médico: enfermería solo actualiza su avance. */
    fun nursingIndications() = ListScreenConfig(
        statusOptions = listOf(Statuses.EN_ESPERA, Statuses.EN_CURSO, Statuses.COMPLETADA),
        editMode = EditMode.STATUS_ONLY
    )

    fun schedule() = ListScreenConfig(
        statusOptions = listOf(Statuses.MANANA, Statuses.TARDE, Statuses.LIBRE),
        editMode = EditMode.NONE,
        compactRows = true
    )
}

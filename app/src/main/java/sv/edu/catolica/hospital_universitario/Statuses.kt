package sv.edu.catolica.hospital_universitario

/** Estados reutilizables (texto en strings.xml, color según StatusStyle). */
object Statuses {
    val CONFIRMADA = StatusOption(R.string.st_confirmada, StatusStyle.CONFIRMED)
    val EN_ESPERA = StatusOption(R.string.st_en_espera, StatusStyle.WAITING)
    val EN_CURSO = StatusOption(R.string.st_en_curso, StatusStyle.IN_PROGRESS)
    val PENDIENTE = StatusOption(R.string.st_pendiente, StatusStyle.WAITING)
    val INGRESADO = StatusOption(R.string.st_ingresado, StatusStyle.CONFIRMED)
    val OBSERVACION = StatusOption(R.string.st_observacion, StatusStyle.WAITING)
    val EN_TRIAGE = StatusOption(R.string.st_en_triage, StatusStyle.TRIAGE)
    val INGRESADA = StatusOption(R.string.st_ingresada, StatusStyle.CONFIRMED)
    val LLAMADO = StatusOption(R.string.st_llamado, StatusStyle.IN_PROGRESS)
    val EN_PROCESO = StatusOption(R.string.st_en_proceso, StatusStyle.IN_PROGRESS)
    val COMPLETADO = StatusOption(R.string.st_completado, StatusStyle.CONFIRMED)
    val ACTIVA = StatusOption(R.string.st_activa, StatusStyle.CONFIRMED)
    val EN_SEGUIMIENTO = StatusOption(R.string.st_en_seguimiento, StatusStyle.IN_PROGRESS)
    val ESTABLE = StatusOption(R.string.st_estable, StatusStyle.CONFIRMED)
    val COMPLETADA = StatusOption(R.string.st_completada, StatusStyle.CONFIRMED)
    val MANANA = StatusOption(R.string.st_manana, StatusStyle.IN_PROGRESS)
    val TARDE = StatusOption(R.string.st_tarde, StatusStyle.IN_PROGRESS)
    val LIBRE = StatusOption(R.string.st_libre, StatusStyle.WAITING)
    val CANCELADA = StatusOption(R.string.st_cancelada, StatusStyle.TRIAGE)
    val ATENDIDA = StatusOption(R.string.st_atendida, StatusStyle.CONFIRMED)
    val ATENDIDO = StatusOption(R.string.st_atendido, StatusStyle.CONFIRMED)
    val EN_ATENCION = StatusOption(R.string.st_en_atencion, StatusStyle.IN_PROGRESS)
    val ALTA = StatusOption(R.string.st_alta, StatusStyle.CONFIRMED)
    val SUSPENDIDA = StatusOption(R.string.st_suspendida, StatusStyle.TRIAGE)
}

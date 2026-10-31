package sv.edu.catolica.hospital_universitario

import androidx.annotation.StringRes

/** Estado clínico/administrativo de un paciente. El texto visible vive en strings.xml. */
enum class PatientStatus(@StringRes val labelRes: Int) {
    ACTIVE(R.string.patient_status_active),
    HOSPITALIZED(R.string.patient_status_hospitalized),
    TRIAGE(R.string.patient_status_triage),
    FOLLOW_UP(R.string.patient_status_follow_up)
}

data class Patient(
    val id: Long = 0L,
    val fullName: String,
    /** Número de expediente (ej. EXP-001284). Si va vacío, el repositorio lo genera al crear. */
    val record: String = "",
    val status: PatientStatus,
    val age: Int,
    val phone: String
)

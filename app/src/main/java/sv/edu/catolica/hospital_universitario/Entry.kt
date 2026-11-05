package sv.edu.catolica.hospital_universitario

import androidx.annotation.StringRes

/** Colores de la etiqueta de estado (reutiliza los drawables bg_badge_* existentes). */
enum class StatusStyle(val badgeRes: Int) {
    CONFIRMED(R.drawable.bg_badge_confirmed),
    WAITING(R.drawable.bg_badge_waiting),
    TRIAGE(R.drawable.bg_badge_triage),
    IN_PROGRESS(R.drawable.bg_badge_inprogress)
}

data class StatusOption(@StringRes val labelRes: Int, val style: StatusStyle)

/**
 * Registro genérico de las pantallas de lista (citas, ingresos, turnos, laboratorio, recetas...).
 * [lead] es la hora o el código que va antes del título (ej. "08:00", "A-021"); vacío si no aplica.
 */
data class Entry(
    val id: Long = 0L,
    val icon: String = "✚",
    val lead: String = "",
    val title: String,
    val meta: String = "",
    val status: StatusOption
) {
    val displayTitle: String get() = if (lead.isBlank()) title else "$lead · $title"
}

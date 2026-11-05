package sv.edu.catolica.hospital_universitario

/** Datos de ejemplo FICTICIOS (tomados de la maqueta). Solo para demo. */
object Seeds {

    val appointments: List<Entry> = listOf(
        Entry(id = 1L, icon = "✚", lead = "08:00", title = "María López", meta = "Medicina interna · Dr. Ramírez", status = Statuses.CONFIRMADA),
        Entry(id = 2L, icon = "✚", lead = "09:30", title = "Carlos Mendoza", meta = "Cardiología · Dra. Castillo", status = Statuses.EN_ESPERA),
        Entry(id = 3L, icon = "✚", lead = "11:00", title = "Lucía García", meta = "Pediatría · Dra. Torres", status = Statuses.CONFIRMADA),
        Entry(id = 4L, icon = "✚", lead = "13:30", title = "Juan Pérez", meta = "Consulta general · Dr. Méndez", status = Statuses.EN_CURSO),
        Entry(id = 5L, icon = "✚", lead = "15:00", title = "Roberto Díaz", meta = "Medicina interna · Dr. Ramírez", status = Statuses.PENDIENTE)
    )

    val admissions: List<Entry> = listOf(
        Entry(id = 1L, icon = "✚", lead = "", title = "Carlos Mendoza", meta = "Urgencias · VIP-301", status = Statuses.INGRESADO),
        Entry(id = 2L, icon = "✚", lead = "", title = "María López", meta = "Observación · HAB-202 A", status = Statuses.OBSERVACION),
        Entry(id = 3L, icon = "✚", lead = "", title = "Juan Pérez", meta = "Urgencias · Sin asignar", status = Statuses.EN_TRIAGE),
        Entry(id = 4L, icon = "✚", lead = "", title = "Lucía García", meta = "Programado · HAB-204 B", status = Statuses.INGRESADA),
        Entry(id = 5L, icon = "✚", lead = "", title = "Roberto Díaz", meta = "Urgencias · HAB-201 A", status = Statuses.INGRESADO)
    )

    val turns: List<Entry> = listOf(
        Entry(id = 1L, icon = "✚", lead = "A-021", title = "María López", meta = "Cardiología · 09:30", status = Statuses.EN_ESPERA),
        Entry(id = 2L, icon = "✚", lead = "A-022", title = "Juan Pérez", meta = "Consulta general · 10:00", status = Statuses.LLAMADO),
        Entry(id = 3L, icon = "✚", lead = "A-023", title = "Ana Herrera", meta = "Medicina interna · 10:15", status = Statuses.EN_ESPERA)
    )

    val doctorAppointments: List<Entry> = listOf(
        Entry(id = 1L, icon = "▦", lead = "08:00", title = "María López", meta = "Medicina interna · Primera vez", status = Statuses.CONFIRMADA),
        Entry(id = 2L, icon = "▦", lead = "09:30", title = "Carlos Mendoza", meta = "Cardiología · Control", status = Statuses.EN_ESPERA),
        Entry(id = 3L, icon = "▦", lead = "11:00", title = "Lucía García", meta = "Pediatría · Seguimiento", status = Statuses.CONFIRMADA),
        Entry(id = 4L, icon = "▦", lead = "13:30", title = "Juan Pérez", meta = "Consulta general · Urgencia menor", status = Statuses.EN_CURSO),
        Entry(id = 5L, icon = "▦", lead = "15:00", title = "Roberto Díaz", meta = "Medicina interna · Control", status = Statuses.PENDIENTE)
    )

    val doctorLab: List<Entry> = listOf(
        Entry(id = 1L, icon = "✚", lead = "LAB-2048", title = "Carlos Mendoza", meta = "Biometría hemática · Urgente", status = Statuses.PENDIENTE),
        Entry(id = 2L, icon = "✚", lead = "LAB-2049", title = "María López", meta = "Química sanguínea", status = Statuses.EN_PROCESO),
        Entry(id = 3L, icon = "✚", lead = "LAB-2050", title = "Juan Pérez", meta = "Perfil lipídico", status = Statuses.COMPLETADO),
        Entry(id = 4L, icon = "✚", lead = "LAB-2051", title = "Lucía García", meta = "Uroanálisis", status = Statuses.PENDIENTE),
        Entry(id = 5L, icon = "✚", lead = "LAB-2052", title = "Roberto Díaz", meta = "Proteína C reactiva", status = Statuses.COMPLETADO)
    )

    val doctorPrescriptions: List<Entry> = listOf(
        Entry(id = 1L, icon = "✚", lead = "", title = "Carlos Mendoza", meta = "Losartán 50 mg · Vía oral", status = Statuses.ACTIVA),
        Entry(id = 2L, icon = "✚", lead = "", title = "María López", meta = "Paracetamol 500 mg · Vía oral", status = Statuses.ACTIVA),
        Entry(id = 3L, icon = "✚", lead = "", title = "Juan Pérez", meta = "Medicamento según evaluación", status = Statuses.PENDIENTE),
        Entry(id = 4L, icon = "✚", lead = "", title = "Lucía García", meta = "Control de tratamiento", status = Statuses.ACTIVA)
    )

    val nursingPatients: List<Entry> = listOf(
        Entry(id = 1L, icon = "✚", lead = "", title = "Carlos Mendoza", meta = "VIP-301 · Control de signos", status = Statuses.EN_SEGUIMIENTO),
        Entry(id = 2L, icon = "✚", lead = "", title = "María López", meta = "EXP-001285 · Hospitalizada", status = Statuses.EN_ESPERA),
        Entry(id = 3L, icon = "✚", lead = "", title = "Roberto Díaz", meta = "HAB-201 · Control de glucosa", status = Statuses.EN_SEGUIMIENTO),
        Entry(id = 4L, icon = "✚", lead = "", title = "Lucía García", meta = "HAB-204 · Evolución favorable", status = Statuses.ESTABLE),
        Entry(id = 5L, icon = "✚", lead = "", title = "Ana Herrera", meta = "HAB-205 · Medicación", status = Statuses.EN_ESPERA)
    )

    val nursingIndications: List<Entry> = listOf(
        Entry(id = 1L, icon = "✚", lead = "", title = "Carlos Mendoza", meta = "Control de presión · 10:00", status = Statuses.EN_ESPERA),
        Entry(id = 2L, icon = "✚", lead = "", title = "María López", meta = "Verificar signos · 10:30", status = Statuses.EN_ESPERA),
        Entry(id = 3L, icon = "✚", lead = "", title = "Roberto Díaz", meta = "Glucemia capilar · 11:00", status = Statuses.EN_CURSO),
        Entry(id = 4L, icon = "✚", lead = "", title = "Lucía García", meta = "Registrar signos · 12:00", status = Statuses.COMPLETADA),
        Entry(id = 5L, icon = "✚", lead = "", title = "Ana Herrera", meta = "Vigilancia clínica · 13:00", status = Statuses.EN_ESPERA)
    )

    val doctorSchedule: List<Entry> = listOf(
        Entry(id = 1L, icon = "", lead = "", title = "Lunes 19", meta = "07:00–15:00", status = Statuses.MANANA),
        Entry(id = 2L, icon = "", lead = "", title = "Martes 20", meta = "07:00–15:00", status = Statuses.MANANA),
        Entry(id = 3L, icon = "", lead = "", title = "Miércoles 21", meta = "07:00–15:00", status = Statuses.MANANA),
        Entry(id = 4L, icon = "", lead = "", title = "Jueves 22", meta = "Guardia 15:00–23:00", status = Statuses.TARDE),
        Entry(id = 5L, icon = "", lead = "", title = "Viernes 23", meta = "Descanso", status = Statuses.LIBRE)
    )

    val nursingTurns: List<Entry> = listOf(
        Entry(id = 1L, icon = "", lead = "", title = "Lunes 19", meta = "06:00–14:00", status = Statuses.MANANA),
        Entry(id = 2L, icon = "", lead = "", title = "Martes 20", meta = "06:00–14:00", status = Statuses.MANANA),
        Entry(id = 3L, icon = "", lead = "", title = "Miércoles 21", meta = "06:00–14:00", status = Statuses.MANANA),
        Entry(id = 4L, icon = "", lead = "", title = "Jueves 22", meta = "Descanso", status = Statuses.LIBRE),
        Entry(id = 5L, icon = "", lead = "", title = "Viernes 23", meta = "14:00–22:00", status = Statuses.TARDE)
    )
}

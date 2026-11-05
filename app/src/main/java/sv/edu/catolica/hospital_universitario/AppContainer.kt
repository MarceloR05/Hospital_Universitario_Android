package sv.edu.catolica.hospital_universitario

/**
 * ÚNICO lugar donde se crean los repositorios.
 * Para conectar la base de datos real: cambiar cada Fake...Repository(...) por la implementación real.
 */
object AppContainer {
    val patientRepository: PatientRepository by lazy { FakePatientRepository() }

    val appointmentRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.appointments) }
    val admissionRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.admissions) }
    val turnRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.turns) }
    val doctorAppointmentRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.doctorAppointments) }
    val labRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.doctorLab) }
    val prescriptionRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.doctorPrescriptions) }
    val nursingPatientRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.nursingPatients) }
    val nursingIndicationRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.nursingIndications) }
    val doctorScheduleRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.doctorSchedule) }
    val nursingTurnRepository: EntryRepository by lazy { FakeEntryRepository(Seeds.nursingTurns) }

    /** Paciente elegido para la consulta / preconsulta en curso (solo en memoria). */
    var selectedPatientName: String? = null
}

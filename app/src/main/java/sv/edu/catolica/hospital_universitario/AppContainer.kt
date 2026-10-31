package sv.edu.catolica.hospital_universitario

/**
 * ÚNICO lugar donde se crean los repositorios.
 * Para conectar la base de datos real: cambiar FakePatientRepository() por la implementación real.
 */
object AppContainer {
    val patientRepository: PatientRepository by lazy { FakePatientRepository() }
}

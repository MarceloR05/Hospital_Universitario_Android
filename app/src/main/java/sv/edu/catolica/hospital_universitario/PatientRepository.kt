package sv.edu.catolica.hospital_universitario

/**
 * Contrato de acceso a datos de pacientes. Las pantallas dependen SOLO de esta interfaz.
 * Cuando se conecte la base de datos, se crea otra implementación y se cambia en AppContainer.
 */
interface PatientRepository {
    fun getAll(): List<Patient>
    fun getById(id: Long): Patient?
    /** Busca por nombre o número de expediente, sin distinguir mayúsculas ni tildes. */
    fun search(query: String): List<Patient>
    fun add(patient: Patient): Patient
    fun update(patient: Patient): Boolean
    fun delete(id: Long): Boolean
}

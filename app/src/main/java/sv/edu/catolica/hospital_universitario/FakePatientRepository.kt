package sv.edu.catolica.hospital_universitario

import java.text.Normalizer
import java.util.Locale

/**
 * Implementación FALSA en memoria. Los datos se pierden al cerrar la app.
 * Todos los datos son ficticios (solo para demo).
 */
class FakePatientRepository : PatientRepository {

    private val patients = mutableListOf(
        Patient(1, "Carlos Mendoza", "EXP-001284", PatientStatus.ACTIVE, 45, "7000-1001"),
        Patient(2, "María López", "EXP-001285", PatientStatus.HOSPITALIZED, 67, "7000-1002"),
        Patient(3, "Juan Pérez", "EXP-001286", PatientStatus.TRIAGE, 33, "7000-1003"),
        Patient(4, "Lucía García", "EXP-001287", PatientStatus.FOLLOW_UP, 29, "7000-1004"),
        Patient(5, "Roberto Díaz", "EXP-001288", PatientStatus.HOSPITALIZED, 58, "7000-1005"),
        Patient(6, "Ana Torres", "EXP-001289", PatientStatus.ACTIVE, 41, "7000-1006"),
        Patient(7, "Pedro Ramírez", "EXP-001290", PatientStatus.FOLLOW_UP, 52, "7000-1007"),
        Patient(8, "Sofía Hernández", "EXP-001291", PatientStatus.TRIAGE, 24, "7000-1008")
    )

    private var nextId = 9L
    private var nextRecordNumber = 1292

    override fun getAll(): List<Patient> = patients.toList()

    override fun getById(id: Long): Patient? = patients.firstOrNull { it.id == id }

    override fun search(query: String): List<Patient> {
        val q = normalize(query)
        if (q.isEmpty()) return getAll()
        return patients.filter {
            normalize(it.fullName).contains(q) || normalize(it.record).contains(q)
        }
    }

    override fun add(patient: Patient): Patient {
        val record = patient.record.ifBlank {
            String.format(Locale.US, "EXP-%06d", nextRecordNumber++)
        }
        val created = patient.copy(id = nextId++, record = record)
        patients.add(created)
        return created
    }

    override fun update(patient: Patient): Boolean {
        val index = patients.indexOfFirst { it.id == patient.id }
        if (index < 0) return false
        patients[index] = patient
        return true
    }

    override fun delete(id: Long): Boolean = patients.removeAll { it.id == id }

    private fun normalize(text: String): String =
        Normalizer.normalize(text.trim().lowercase(Locale.ROOT), Normalizer.Form.NFD)
            .replace(Regex("\\p{M}+"), "")
}

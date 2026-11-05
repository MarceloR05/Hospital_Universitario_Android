package sv.edu.catolica.hospital_universitario

/** Signos vitales guardados en memoria por paciente. Se pierden al cerrar la app. */
object VitalsStore {
    private val data = mutableMapOf<String, MutableMap<String, String>>()

    fun get(patient: String, key: String): String? = data[patient]?.get(key)

    fun put(patient: String, key: String, value: String) {
        data.getOrPut(patient) { mutableMapOf() }[key] = value
    }
}

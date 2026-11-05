package sv.edu.catolica.hospital_universitario

/**
 * Contrato de acceso a datos de las listas genéricas. Las pantallas dependen SOLO de esta interfaz.
 * Cuando se conecte la base de datos, se crea otra implementación y se cambia en AppContainer.
 */
interface EntryRepository {
    fun getAll(): List<Entry>
    fun getById(id: Long): Entry?
    /** Busca en el título (con hora/código) y en la línea secundaria, sin importar mayúsculas ni tildes. */
    fun search(query: String): List<Entry>
    fun add(entry: Entry): Entry
    fun update(entry: Entry): Boolean
    fun delete(id: Long): Boolean
    /** Siguiente código con ese prefijo (ej. prefix "A-" -> "A-024"). */
    fun nextCode(prefix: String): String
}

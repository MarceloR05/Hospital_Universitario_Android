package sv.edu.catolica.hospital_universitario

import java.text.Normalizer
import java.util.Locale

/** Implementación FALSA en memoria. Los datos se pierden al cerrar la app. Datos ficticios. */
class FakeEntryRepository(seed: List<Entry>) : EntryRepository {

    private val entries = seed.toMutableList()
    private var nextId = (seed.maxOfOrNull { it.id } ?: 0L) + 1L

    override fun getAll(): List<Entry> = entries.toList()

    override fun getById(id: Long): Entry? = entries.firstOrNull { it.id == id }

    override fun search(query: String): List<Entry> {
        val q = normalize(query)
        if (q.isEmpty()) return getAll()
        return entries.filter {
            normalize(it.displayTitle).contains(q) || normalize(it.meta).contains(q)
        }
    }

    override fun add(entry: Entry): Entry {
        val created = entry.copy(id = nextId++)
        entries.add(created)
        return created
    }

    override fun update(entry: Entry): Boolean {
        val index = entries.indexOfFirst { it.id == entry.id }
        if (index < 0) return false
        entries[index] = entry
        return true
    }

    override fun delete(id: Long): Boolean = entries.removeAll { it.id == id }

    override fun nextCode(prefix: String): String {
        val regex = Regex("^" + Regex.escape(prefix) + "(\\d+)$")
        var max = 0
        var width = 3
        for (entry in entries) {
            val digits = regex.find(entry.lead)?.groupValues?.get(1) ?: continue
            max = maxOf(max, digits.toIntOrNull() ?: 0)
            width = digits.length
        }
        return prefix + String.format(Locale.US, "%0" + width + "d", max + 1)
    }

    private fun normalize(text: String): String =
        Normalizer.normalize(text.trim().lowercase(Locale.ROOT), Normalizer.Form.NFD)
            .replace(Regex("\\p{M}+"), "")
}

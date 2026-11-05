package sv.edu.catolica.hospital_universitario

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sv.edu.catolica.hospital_universitario.databinding.ItemEntryBinding
import sv.edu.catolica.hospital_universitario.databinding.ItemShiftBinding

internal object EntryDiff : DiffUtil.ItemCallback<Entry>() {
    override fun areItemsTheSame(oldItem: Entry, newItem: Entry) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Entry, newItem: Entry) = oldItem == newItem
}

/** Tarjeta con icono, título, línea gris y etiqueta de estado (citas, ingresos, laboratorio...). */
class EntryAdapter(
    private val onClick: (Entry) -> Unit
) : ListAdapter<Entry, EntryAdapter.EntryViewHolder>(EntryDiff) {

    class EntryViewHolder(val binding: ItemEntryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val binding = ItemEntryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EntryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = getItem(position)
        val context = holder.itemView.context
        with(holder.binding) {
            tvIcon.text = entry.icon
            flIcon.visibility = if (entry.icon.isBlank()) View.GONE else View.VISIBLE
            tvTitle.text = entry.displayTitle
            tvMeta.text = entry.meta
            tvMeta.visibility = if (entry.meta.isBlank()) View.GONE else View.VISIBLE
            tvBadge.text = context.getString(entry.status.labelRes)
            tvBadge.setBackgroundResource(entry.status.style.badgeRes)
            cardEntry.setOnClickListener { onClick(entry) }
        }
    }
}

/** Fila compacta con la etiqueta a la derecha (turnos y horarios). */
class ShiftAdapter(
    private val onClick: (Entry) -> Unit
) : ListAdapter<Entry, ShiftAdapter.ShiftViewHolder>(EntryDiff) {

    class ShiftViewHolder(val binding: ItemShiftBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShiftViewHolder {
        val binding = ItemShiftBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShiftViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShiftViewHolder, position: Int) {
        val entry = getItem(position)
        val context = holder.itemView.context
        with(holder.binding) {
            tvTitle.text = entry.displayTitle
            tvMeta.text = entry.meta
            tvBadge.text = context.getString(entry.status.labelRes)
            tvBadge.setBackgroundResource(entry.status.style.badgeRes)
            cardShiftRow.setOnClickListener { onClick(entry) }
        }
    }
}

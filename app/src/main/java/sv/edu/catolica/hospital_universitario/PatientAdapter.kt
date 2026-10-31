package sv.edu.catolica.hospital_universitario

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sv.edu.catolica.hospital_universitario.databinding.ItemPatientBinding

class PatientAdapter(
    private val onPatientClick: (Patient) -> Unit
) : ListAdapter<Patient, PatientAdapter.PatientViewHolder>(DiffCallback) {

    class PatientViewHolder(val binding: ItemPatientBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val binding = ItemPatientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PatientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val patient = getItem(position)
        val context = holder.itemView.context
        with(holder.binding) {
            tvName.text = patient.fullName
            tvMeta.text = context.getString(
                R.string.patient_meta_format,
                patient.record,
                context.getString(patient.status.labelRes)
            )
            cardPatient.setOnClickListener { onPatientClick(patient) }
            btnViewRecord.setOnClickListener { onPatientClick(patient) }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<Patient>() {
        override fun areItemsTheSame(oldItem: Patient, newItem: Patient) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Patient, newItem: Patient) = oldItem == newItem
    }
}

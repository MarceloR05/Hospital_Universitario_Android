package sv.edu.catolica.hospital_universitario

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/** Diálogo para elegir un paciente de la lista de pacientes. */
object PatientPicker {
    fun show(activity: AppCompatActivity, onSelected: (Patient) -> Unit) {
        val patients = AppContainer.patientRepository.getAll()
        val names = patients.map { it.fullName }.toTypedArray()
        MaterialAlertDialogBuilder(activity)
            .setTitle(R.string.picker_title)
            .setItems(names) { _, which -> onSelected(patients[which]) }
            .setNegativeButton(R.string.list_cancel, null)
            .show()
    }
}

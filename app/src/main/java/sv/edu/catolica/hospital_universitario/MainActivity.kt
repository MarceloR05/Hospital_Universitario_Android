package sv.edu.catolica.hospital_universitario

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import sv.edu.catolica.hospital_universitario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        // Toggle password visibility
        binding.ivPasswordToggle.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                binding.etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.ivPasswordToggle.setImageResource(android.R.drawable.ic_menu_close_clear_cancel)
            } else {
                binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.ivPasswordToggle.setImageResource(android.R.drawable.ic_menu_view)
            }
            // Move cursor to the end of text
            binding.etPassword.setSelection(binding.etPassword.text.length)
        }

        // Login button click
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.etEmail.error = getString(R.string.error_email_required)
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = getString(R.string.error_email_invalid)
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPassword.error = getString(R.string.error_password_required)
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            val user = SessionManager.login(email, password)
            if (user == null) {
                binding.etPassword.error = getString(R.string.error_invalid_credentials)
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            // El login se cierra para que Atrás no vuelva a esta pantalla.
            Navigator.goToHomeForRole(this, user.role, closeCurrent = true)
        }

        // Nursing Role button click (atajo de demo)
        binding.btnNursingRole.setOnClickListener {
            val user = SessionManager.loginAsDemo(SessionManager.Role.NURSING)
                ?: return@setOnClickListener
            Navigator.goToHomeForRole(this, user.role, closeCurrent = true)
        }

        // Doctor Role button click (atajo de demo)
        binding.btnDoctorRole.setOnClickListener {
            val user = SessionManager.loginAsDemo(SessionManager.Role.DOCTOR)
                ?: return@setOnClickListener
            Navigator.goToHomeForRole(this, user.role, closeCurrent = true)
        }

        // Forgot password click
        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(this, R.string.msg_forgot_password, Toast.LENGTH_SHORT).show()
        }
    }
}

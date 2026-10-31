package sv.edu.catolica.hospital_universitario

/**
 * Sesión en memoria.
 *
 * Guarda el rol y el nombre del usuario que inició sesión. Todavía no hay
 * autenticación real ni persistencia: al cerrar la app la sesión se pierde.
 */
object SessionManager {

    /** Roles de la aplicación. */
    enum class Role {
        RECEPTION,
        NURSING,
        DOCTOR
    }

    /** Usuario de prueba. */
    data class DemoUser(
        val role: Role,
        val displayName: String,
        val email: String,
        val password: String
    )

    private const val DEMO_PASSWORD = "demo123"

    // Usuarios de prueba: solo para demo, reemplazar por autenticación real.
    private val demoUsers = listOf(
        DemoUser(
            role = Role.RECEPTION,
            displayName = "Ana Martínez",
            email = "ana.martinez@hospital.edu",
            password = DEMO_PASSWORD
        ),
        DemoUser(
            role = Role.NURSING,
            displayName = "Laura Gómez",
            email = "laura.gomez@hospital.edu",
            password = DEMO_PASSWORD
        ),
        DemoUser(
            role = Role.DOCTOR,
            displayName = "Dr. Carlos Ramírez",
            email = "carlos.ramirez@hospital.edu",
            password = DEMO_PASSWORD
        )
    )

    /** Usuario con la sesión activa, o `null` si no hay sesión. */
    var currentUser: DemoUser? = null
        private set

    /** Rol de la sesión activa, o `null` si no hay sesión. */
    val currentRole: Role?
        get() = currentUser?.role

    /** Nombre del usuario con la sesión activa, o `null` si no hay sesión. */
    val currentUserName: String?
        get() = currentUser?.displayName

    /**
     * Valida las credenciales contra los usuarios de prueba.
     *
     * @return el usuario si coinciden correo y contraseña; `null` en caso contrario.
     */
    fun login(email: String, password: String): DemoUser? {
        val user = demoUsers.firstOrNull { demo ->
            demo.email.equals(email.trim(), ignoreCase = true) && demo.password == password
        }
        currentUser = user
        return user
    }

    /** Atajo de demo: inicia sesión con el usuario de prueba del [role] pedido. */
    fun loginAsDemo(role: Role): DemoUser? {
        val user = demoUsers.firstOrNull { it.role == role }
        currentUser = user
        return user
    }

    /** Limpia la sesión actual. */
    fun logout() {
        currentUser = null
    }
}

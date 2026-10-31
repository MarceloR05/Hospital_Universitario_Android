# Hospital Universitario Android - Reglas

Stack: Kotlin, XML + ViewBinding, una Activity por pantalla. SIN Compose.
Paquete: sv.edu.catolica.hospital_universitario. minSdk 26, compileSdk/targetSdk 37.
Objetivo actual: app funcional con datos falsos en memoria. SIN base de datos todavía.

## Prohibido
- Conectar base de datos o API (Room, SQLite, Firebase, Retrofit, Supabase).
- Cambiar versiones de AGP, Kotlin, compileSdk o minSdk.
- Agregar dependencias sin avisarme. Solo se permiten, previo aviso: androidx.recyclerview,
  androidx.activity:activity-ktx, androidx.lifecycle:lifecycle-viewmodel-ktx.
- Cambiar el diseño visual (colores, formas, tipografías). Reutiliza los drawables bg_* y colors.xml.
- Reescribir pantallas enteras o borrar layouts que funcionan.
- Usar findViewById (siempre ViewBinding).
- Inventar dosis, rangos clínicos o consejos médicos reales. Los datos de ejemplo son siempre ficticios.

## Obligatorio
- Todo texto visible va en español y en strings.xml (nada de texto fijo en el código).
- Cambios mínimos: toca solo los archivos necesarios para la tarea pedida.
- Antes de escribir código, lista los archivos que vas a modificar.
- Haz SOLO la tarea que te pido. No avances a la siguiente por tu cuenta.
- Si algo es ambiguo, NO inventes: deja un TODO y pregúntame.
- Si no puedes compilar, dilo claramente. Nunca afirmes que compila sin haberlo comprobado.
- Al terminar responde con: (1) qué cambiaste, (2) archivos tocados, (3) qué debo probar a mano.

## Arquitectura objetivo
- Las pantallas dependen de INTERFACES de repositorio (ej. PatientRepository), nunca de la
  implementación falsa. Las implementaciones falsas (FakeXRepository) viven en memoria y se crean
  en un solo lugar (AppContainer). Así la DB real se enchufa cambiando una sola línea.
- Navegación centralizada en Navigator.kt. Sesión en SessionManager (en memoria).

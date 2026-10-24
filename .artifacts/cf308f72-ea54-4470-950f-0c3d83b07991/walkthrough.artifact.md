# Walkthrough - Hospital Universitario App

## Pantallas Implementadas

### 1. Pantalla de Inicio de Sesión (Login)
- **Archivos**: [MainActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/MainActivity.kt), [activity_main.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_main.xml).
- **Características**: Encabezado vino `#770727`, tarjeta blanca con validación de correo y contraseña institucional, botón para mostrar/ocultar contraseña, y acceso directo al **Modo Enfermería**, **Modo Doctor** o al panel principal de recepción.

### 2. Panel de Recepción (Dashboard / Home)
- **Archivos**: [HomeActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/HomeActivity.kt), [activity_home.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_home.xml).
- **Características**: Saludo personalizado ("Buenos días, Ana"), tarjetas de resumen de hoy, barra de búsqueda y accesos rápidos.

### 3. Pantalla de Pacientes (Pacientes Registrados)
- **Archivos**: [PatientsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/PatientsActivity.kt), [activity_patients.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_patients.xml).
- **Características**: Listado de pacientes registrados, búsqueda, expedientes y botón de nuevo paciente.

### 4. Pantalla de Citas (Agenda de Consultas - Recepción)
- **Archivos**: [AppointmentsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/AppointmentsActivity.kt), [activity_appointments.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_appointments.xml).
- **Características**: Agenda diaria con horarios, médicos, especialidades y estados dinámicos.

### 5. Pantalla de Turnos (Cola de Atención y Turnos Activos)
- **Archivos**: [TurnsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/TurnsActivity.kt), [activity_turns.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_turns.xml).
- **Características**: Cola de atención y turnos activos en sala de espera.

### 6. Pantalla de Ingresos (Admisión y Seguimiento Hospitalario)
- **Archivos**: [AdmissionsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/AdmissionsActivity.kt), [activity_admissions.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_admissions.xml).
- **Características**: Ingresos recientes, ubicación de camas/habitaciones y estados hospitalarios.

### 7. Pantalla de Habitaciones (Capacidad Hospitalaria y Asignación - Recepción)
- **Archivos**: [RoomsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/RoomsActivity.kt), [activity_rooms.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_rooms.xml).
- **Características**: Capacidad hospitalaria de recepción, planta VIP y semiprivadas.

### 8. Inicio de Enfermería (Rol Enfermería - Laura)
- **Archivos**: [NursingHomeActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/NursingHomeActivity.kt), [activity_nursing_home.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_nursing_home.xml).
- **Características**: Saludo "Hola, Laura", resumen del turno y accesos rápidos de enfermería.

### 9. Pacientes Asignados (Rol Enfermería)
- **Archivos**: [NursingPatientsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/NursingPatientsActivity.kt), [activity_nursing_patients.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_nursing_patients.xml).
- **Características**: Listado de pacientes bajo responsabilidad, filtros y estados de enfermería.

### 10. Preconsulta (Signos Vitales y Evaluación Inicial - Enfermería)
- **Archivos**: [NursingPreconsultActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/NursingPreconsultActivity.kt), [activity_nursing_preconsult.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_nursing_preconsult.xml).
- **Características**: Paciente seleccionado y registro de 6 signos vitales.

### 11. Habitaciones de Enfermería (Vista de Ocupación)
- **Archivos**: [NursingRoomsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/NursingRoomsActivity.kt), [activity_nursing_rooms.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_nursing_rooms.xml).
- **Características**: Vista de ocupación (17 camas totales, 10 ocupadas) y habitaciones VIP (VIP-301 a VIP-305).

### 12. Turnos Laborales (Horario y Guardias Asignadas - Enfermería)
- **Archivos**: [NursingTurnsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/NursingTurnsActivity.kt), [activity_nursing_turns.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_nursing_turns.xml).
- **Características**: Mi próxima guardia y cronograma de la semana laboral.

### 13. Indicaciones Autorizadas (Seguimiento de Órdenes Médicas - Enfermería)
- **Archivos**: [NursingIndicationsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/NursingIndicationsActivity.kt), [activity_nursing_indications.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_nursing_indications.xml).
- **Características**: Seguimiento de órdenes médicas asignadas, filtros y estados.

### 14. Panel de Inicio del Doctor (Rol Doctor - Dr. Ramírez)
- **Archivos**: [DoctorHomeActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/DoctorHomeActivity.kt), [activity_doctor_home.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_doctor_home.xml).
- **Características**: Saludo "Buenos días, Dr. Ramírez", resumen médico y accesos rápidos.

### 15. Mis Citas Médicas (Agenda y Consultas - Rol Doctor)
- **Archivos**: [DoctorAppointmentsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/DoctorAppointmentsActivity.kt), [activity_doctor_appointments.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_doctor_appointments.xml).
- **Características**: Agenda del día con citas de pacientes y barra de navegación inferior con los iconos estándar del doctor.

### 16. Consulta Médica (Evaluación y Diagnóstico - Rol Doctor)
- **Archivos**: [DoctorConsultActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/DoctorConsultActivity.kt), [activity_doctor_consult.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_doctor_consult.xml).
- **Características**: Paciente en atención, apartados de *Motivo de consulta*, *Exploración y valoración*, *Diagnóstico y plan*, *Diagnóstico y notas médicas*, y botón *Finalizar consulta*.

### 17. Expediente Clínico (Historial y Registros - Rol Doctor)
- **Archivos**: [DoctorRecordsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/DoctorRecordsActivity.kt), [activity_doctor_records.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_doctor_records.xml).
- **Características**: Expediente clínico con tarjeta de paciente autorizado (*Carlos Mendoza*) y 5 tarjetas de resumen (*Diagnósticos*, *Alergias*, *Tratamiento activo*, *Antecedentes*, *Evolución reciente*).

### 18. Menú Más Opciones (Opciones del Sistema - Rol Doctor)
- **Archivos**: [DoctorMoreActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/DoctorMoreActivity.kt), [activity_doctor_more.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_doctor_more.xml).
- **Características**: Opciones de sistema (*Laboratorio*, *Recetas*, *Horarios*).

### 19. Laboratorio (Órdenes Clínicas y Resultados - Rol Doctor)
- **Archivos**: [DoctorLabActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/DoctorLabActivity.kt), [activity_doctor_lab.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_doctor_lab.xml).
- **Características**: Órdenes de laboratorio y resultados de pacientes.

### 20. Recetas (Prescripción y Seguimiento Farmacológico - Rol Doctor)
- **Archivos**: [DoctorPrescriptionsActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/DoctorPrescriptionsActivity.kt), [activity_doctor_prescriptions.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_doctor_prescriptions.xml).
- **Características**: Prescripciones recientes, banner de alergias y botón de nueva receta.

### 21. Mi Horario (Turnos Médicos y Disponibilidad - Rol Doctor) - NUEVO
- **Figma Design**: Frame `52:998` (`ANDROID · DOCTOR · 05 · Mi horario`).
- **Archivos Nuevos**:
  - [DoctorScheduleActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/DoctorScheduleActivity.kt): Actividad que controla la pantalla de horarios y turnos médicos del doctor.
  - [activity_doctor_schedule.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/layout/activity_doctor_schedule.xml): Diseño XML nativo con cabecera vino, barra de búsqueda (*"Buscar mi horario..."*), sección "Próxima jornada" (Miércoles 21 de octubre, Mañana 07:00–15:00, Confirmada), sección "Agenda semanal" con tarjetas para Lunes 19, Martes 20, Miércoles 21, Jueves 22 (Guardia 15:00–23:00) y Viernes 23 (Descanso) con sus insignias de turno a color (*Mañana*, *Tarde*, *Libre*), y barra de navegación inferior de doctor con la pestaña **Más** (☰) resaltada.
- **Modificaciones**:
  - [AndroidManifest.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/AndroidManifest.xml): Registro de `DoctorScheduleActivity`.
  - [strings.xml](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/res/values/strings.xml): Textos para el horario del doctor.
  - [DoctorMoreActivity.kt](file:///C:/Users/casil/AndroidStudioProjects/Hospital_Universitario/app/src/main/java/sv/edu/catolica/hospital_universitario/DoctorMoreActivity.kt): Integración completa para abrir `DoctorScheduleActivity` al presionar la tarjeta *"Horarios"* (`cardOpt3`).

## Verificación y Pruebas
- **Compilación**: El proyecto compila correctamente sin errores (`BUILD SUCCESSFUL`).
- **Cómo probar en el emulador**:
  1. Ejecuta la aplicación.
  2. En la pantalla de login, pulsa el botón **"Modo Doctor (Dr. Ramírez)"**.
  3. Desde el panel del doctor, toca la pestaña **"Más"** (☰) en la barra inferior y luego selecciona la opción **"Horarios"** (`cardOpt3`).
  4. Visualiza la pantalla de "Mi horario" con la próxima jornada (Miércoles 21 de octubre, 07:00–15:00) y la agenda semanal (Lunes a Viernes).
  5. Toca cualquier turno para comprobar las interacciones.

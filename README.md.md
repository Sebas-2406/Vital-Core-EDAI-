# Acta de Constitución del Proyecto

## Nombre del Proyecto
Gestión de Institución Médica “Vital-Core”

## Problemática
Los procesos de registros de pacientes, historial clínico y asignación de citas al manejarse de forma física y descentralizada, generan duplicidad e inconsistencia de datos, lentitud en el proceso de atención, riesgo a pérdida de información y dificultad en la gestión de los servicios.

## Objetivos
* Manejar el proceso de asistencia de pacientes y cumplimiento de citas mediante el desarrollo de un programa de escritorio que automatice el flujo administrativo y clínico, para realizar una normalización de datos que agilice la gestión de la información.
* Implementar un CRUD eficiente mediante el lenguaje de programación seleccionado.
* Reducir el tiempo de asignación y atención de citas significativamente.
* Garantizar la integridad de los datos mediante la implementación de credenciales para manejar el acceso y modificación a los mismos.

## Alcance
El proyecto consiste en un programa de escritorio en Java que implemente una interfaz gráfica (GUI) funcional con el objetivo de cubrir el registro de pacientes, la programación de citas y su respectiva visualización para su posterior atención por parte del médico, entre otros procesos de un hospital convencional. El sistema se centrará en los módulos principales de un hospital para manejar dichos aspectos de manera unificada.

### Funcionalidades a implementar:
**1. Sistema de Autenticación:**
* Panel de registro (si no se poseen credenciales) especificando el rol dentro de la entidad.
* Sistema de inicio de sesión con validación de credenciales.
* Control de acceso basado en roles (Médico, Paciente, Administrador, etc.).

**2. Módulo de Registro de Citas (Pacientes):**
* Interfaz para programar citas de acuerdo con los requerimientos del paciente.
* Manejo de cancelación de citas por parte del paciente.

**3. Módulo de Atención de Citas (Médicos):**
* Visualización de las citas pendientes del médico en específico.
* Atención de citas y generación de diagnóstico, observaciones y recetas médicas.
* Manejo de cancelación de citas por parte del médico.
* Actualización del historial clínico de los pacientes.

## Integrantes y Roles (RACI)
* **Estefano Chávez - Desarrollador de lógica (Backend) y Tester:** Encargado de mantener la correcta implementación de las estructuras de datos, así como de realizar pruebas del programa constantemente para verificar posibles errores.
* **Erick Páez - Desarrollador de GUI (Frontend) y Experto en documentación:** Responsable de diseñar la interfaz gráfica de usuario y la interacción con el mismo. Además, se encargará de documentar los cambios clave o planificaciones del proceso de desarrollo.

## Definición de Stakeholders
* **Administrador (Gestor de accesos):** Encargado de gestionar los accesos a los distintos módulos mediante claves y configuraciones del sistema, manteniendo la integridad de los datos.
* **Recepcionista (Socializador):** Usuario operativo encargado de introducir a los nuevos usuarios al sistema, realizando un registro inicial. No poseerá claves propias operativas, su función es crear las credenciales iniciales para los pacientes.
* **Médicos (Usuario clínico):** Responsable de visualizar citas pendientes, registrar diagnósticos, dar seguimiento médico y modificar el estado de la cita en el sistema.
* **Pacientes (Usuario operativo):** Usuarios directos que podrán acceder mediante sus credenciales para programar citas de acuerdo con sus requerimientos. Su información permanecerá gestionada de manera segura y confidencial.

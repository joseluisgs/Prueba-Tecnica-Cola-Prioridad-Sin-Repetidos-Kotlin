package models

/**
 * Clase POJO/POKO para el manejo de la informacion de los usuarios
 * Al ser Data Class tenemos:
 * - Constructor por defecto
 * - Constructor con parámetros
 * - Getters y Setters
 * - toString
 * - equals
 * - hashCode
 *
 * Si queremos que solo sean iguales, si tienen el mismo id, sobrescribimos el método equals
 * Si no podemos usar los métodos por defecto.
 * Si usamos un conjunto, el hashCode es el id si solo queremos que sean iguales si tienen el mismo id
 * Todo esto es por la implementación realizada en los repositorios o la propia cola en si: un Set
 */
data class Proceso(val id: Int, val nombre: String, var prioridad: Int = 1) {
    // Para filtrar la prioridad
    init {
        if (prioridad < 1) {
            prioridad = 1
        } else if (prioridad > 9) {
            prioridad = 9
        }
    }
}
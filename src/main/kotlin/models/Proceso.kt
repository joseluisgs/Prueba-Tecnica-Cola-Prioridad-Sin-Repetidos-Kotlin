package models

/**
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        other as Proceso?
        if (other == null) return false
        return id == other.id
    }

    override fun hashCode(): Int {
        return id
    }
}
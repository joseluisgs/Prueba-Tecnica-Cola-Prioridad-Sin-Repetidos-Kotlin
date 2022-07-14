package models

import com.benasher44.uuid.uuid4


data class Proceso(
    val id: String = uuid4().toString(),
    val nombre: String,
    var prioridad: Int = 1,
    var estado: Estado = Estado.PENDIENTE
) {

    init {
        when {
            prioridad < 1 -> prioridad = 1
            prioridad > 9 -> prioridad = 9
        }

    }

    enum class Estado {
        EN_EJECUCION,
        TERMINADO,
        BLOQUEADO,
        SUSPENDIDO,
        PENDIENTE
    }
}
package controllers

import errors.ProcesoException
import models.Proceso
import repositories.ColaProceso

/**
 * Esto no es obligatorio, solo lo uso para usar Mockito y puedeas ver una forma de testear
 * Lo ideal es solo hacer la cola
 * Aplico Inyección de Dependencias por constructor
 */
class ProcesosController(private val procesos: ColaProceso) {

    fun push(proceso: Proceso) {
        procesos.push(proceso)
    }

    fun get(id: Int): Proceso {
        return procesos.get(id) ?: throw ProcesoException("No existe el proceso con id $id")
    }

    fun pop(): Proceso {
        return procesos.pop() ?: throw ProcesoException("No existe el procesos o la cola esta vacía")
    }

    fun isEmpty(): Boolean {
        return procesos.isEmpty()
    }

    fun getAll(): List<Proceso> {
        return procesos.getAll()
    }

}
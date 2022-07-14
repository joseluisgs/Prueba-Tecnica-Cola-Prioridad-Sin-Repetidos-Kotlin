package controllers

import exceptions.ProcesoException
import models.Proceso
import repositories.ColaProcesosPrioritaria

/**
 * Aplico Inyección de Dependencias por constructor
 */
class ProcesosController(private val procesos: ColaProcesosPrioritaria) {

    fun push(proceso: Proceso) = procesos.push(proceso)

    fun getById(id: String) = procesos.getById(id) ?: throw ProcesoException("No existe el proceso con id $id")

    fun pop() = procesos.pop() ?: throw ProcesoException("No existe el procesos o la cola esta vacía")

    fun isEmpty() = procesos.isEmpty()

    fun getAll() = procesos.getAll()
}
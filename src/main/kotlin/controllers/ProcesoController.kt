package controllers

import errors.ProcesoException
import models.Proceso
import repositories.ColaImp

/**
 * Esto no es obligatorio, solo lo uso para usar Mockito
 */
class ProcesoController {
    private val procesos = ColaImp()

    fun push(proceso: Proceso) {
        procesos.push(proceso)
    }

    fun get(id: Int): Proceso {
        return procesos.get(id) ?: throw ProcesoException("No existe el proceso")
    }

    fun pop(): Proceso {
        return procesos.pop() ?: throw ProcesoException("No existe el procesos o la cola esta vacía")
    }

}
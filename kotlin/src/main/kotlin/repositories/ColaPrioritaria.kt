package repositories

import models.Proceso
import tda.Cola

/**
 * Aplico principio de Segregación de Interfaces
 * No le voy a añadir a Cola, operaciones que sí me harán falta para procesos.
 * Además ya contextualizo la propia cola para que sea de procesos.
 */
interface ColaPrioritaria : Cola<Proceso> {
    val size: Int
    fun getById(id: Int): Proceso?
    fun getAll(): List<Proceso>
}
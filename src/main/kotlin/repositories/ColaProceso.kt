package repositories

import models.Proceso

interface ColaProceso : Cola<Proceso> {
    val size: Int
    fun get(id: Int): Proceso?
    fun getAll(): List<Proceso>
}
package repositories

import models.Proceso

interface ColaProceso: Cola<Proceso> {
    fun get(id: Int): Proceso?
    fun size(): Int
    fun getAll(): List<Proceso>
}
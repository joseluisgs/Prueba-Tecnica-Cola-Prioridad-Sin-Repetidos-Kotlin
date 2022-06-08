package repositories

import models.Proceso

class ColaImp : Cola<Proceso> {
    // Al ser un set, pues no admite elementos repetidos
    private val cola = mutableSetOf<Proceso>()

    override fun push(item: Proceso) {
        val res = cola.add(item)
        // println("Se ha agregado el proceso ${item.id} a la cola: $res")
    }

    override fun pop(): Proceso? {
        // La prioridad solo nos afecta a la hora de sacar el proceso de la cola
        // Por lo tanto, no es necesario ordenar la colaImp
        val proceso = cola.maxByOrNull { it.prioridad }
        cola.remove(proceso)
        return proceso
    }

    override fun isEmpty(): Boolean {
        return cola.isEmpty()
    }

    fun size(): Int {
        return cola.size
    }

    fun get(id: Int): Proceso? {
        return cola.find { it.id == id }
    }

    // si queremos sacarla como prioridad, ordenamos en este momento
    override fun toString(): String {
        return cola.toList().sortedBy { it.prioridad }.reversed().joinToString(separator = "\n")
    }
}
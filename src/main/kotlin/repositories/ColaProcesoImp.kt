package repositories

import models.Proceso

/**
 * Propia cola de Procesos sin Repetidos y con Prioridad
 * Tenemos dos problemas:
 * 1. Que no se pueda insertar un proceso que ya esta en la cola. Para ello usamos
 * Un Set de Procesos, que con los métodos hasCode y equals nos asegura que no
 * se repita un proceso.
 * 2. Los procesos deben seguir una prioridad. Aquí surgen dos alternativas:
 * a) Tener siempre activo el orden, entonces, en vez de un HashSet podemos utilizar un TreeSet
 * b) Solo aplicar el orden en salidas de datos, en vez de todas las inserciones.
 * Aquí es importante que justifiquemos qué opción es mejor dependiendo de la situación y la frecuencia de lass operaciones
 * que se realizan.
 *
 * También podemos usar mapas o listas. Cualquier TDA es bueno si lo razonamos.
 * Aplica operaciones sobre colecciones ya sean funcionales para procesar datos
 */
class ColaProcesoImp : ColaProceso {
    // Al ser un set, pues no admite elementos repetidos
    private val cola = mutableSetOf<Proceso>()

    override fun push(item: Proceso) {
        val res = cola.add(item)
        // println("Se ha agregado el proceso ${item.id} a la cola: $res")
    }

    override fun pop(): Proceso? {
        // La prioridad solo nos afecta a la hora de sacar el proceso de la cola
        // Por lo tanto, no es necesario ordenar la colaImp
        // si no buscar el máximo de la cola, es una de las opciones
        val proceso = cola.maxByOrNull { it.prioridad }
        cola.remove(proceso)
        return proceso
    }

    override fun isEmpty(): Boolean {
        return cola.isEmpty()
    }

    override val size: Int
        get() = cola.size

    override fun get(id: Int): Proceso? {
        return cola.find { it.id == id }
    }


    // si queremos sacarla como prioridad, ordenamos en este momento
    override fun toString(): String {
        return this.getAll().joinToString(separator = "\n")
    }

    override fun getAll(): List<Proceso> {
        // De mayor a menor prioridad
        return cola.toList().sortedBy { it.prioridad }.reversed()
    }
}
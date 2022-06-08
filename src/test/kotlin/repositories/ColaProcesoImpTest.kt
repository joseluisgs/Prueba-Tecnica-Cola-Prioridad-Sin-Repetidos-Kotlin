package repositories

import models.Proceso
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class ColaProcesoImpTest {
    private lateinit var cola: ColaProceso

    @BeforeEach
    fun setUp() {
        cola = ColaProcesoImp()
    }

    @Test
    fun push() {
        val cola = ColaProcesoImp()
        cola.push(Proceso(1, "Proceso 1", 1))
        cola.push(Proceso(2, "Proceso 2", 2))

        val p1 = cola.get(1)
        val p2 = cola.get(2)
        assertAll(
            { assert(cola.size == 2) },
            { assert(p1?.id == 1) },
            { assert(p1?.nombre == "Proceso 1") },
            { assert(p1?.prioridad == 1) },
            { assert(p2?.id == 2) },
            { assert(p2?.nombre == "Proceso 2") },
            { assert(p2?.prioridad == 2) }
        )
    }

    @Test
    fun pop() {
        val cola = ColaProcesoImp()
        cola.push(Proceso(1, "Proceso 1", 1))
        cola.push(Proceso(2, "Proceso 2", 2))

        val p2 = cola.pop()
        val p1 = cola.pop()

        assertAll(
            { assert(cola.size == 0) },
            { assert(p2 != null) },
            { assert(p2?.id == 2) },
            { assert(p2?.nombre == "Proceso 2") },
            { assert(p2?.prioridad == 2) },
            { assert(p1 != null) },
            { assert(p1?.id == 1) },
            { assert(p1?.nombre == "Proceso 1") },
            { assert(p1?.prioridad == 1) }
        )
    }

    @Test
    fun popVacio() {
        val cola = ColaProcesoImp()

        val res = cola.pop()

        assert(res == null)
    }

    @Test
    fun isEmpty() {
        assert(cola.isEmpty())
        cola.push(Proceso(1, "Proceso 1", 1))
        assert(!cola.isEmpty())
    }

    @Test
    fun size() {
        assert(cola.size == 0)
        cola.push(Proceso(1, "Proceso 1", 1))
        assert(cola.size == 1)
    }

    @Test
    fun get() {
        cola.push(Proceso(1, "Proceso 1", 1))
        cola.push(Proceso(2, "Proceso 2", 2))

        val p1 = cola.get(1)
        val p2 = cola.get(2)

        assertAll(
            { assert(p1?.id == 1) },
            { assert(p1?.nombre == "Proceso 1") },
            { assert(p1?.prioridad == 1) },
            { assert(p2?.id == 2) },
            { assert(p2?.nombre == "Proceso 2") },
            { assert(p2?.prioridad == 2) }
        )
    }

    @Test
    fun getNoExiste() {
        cola.push(Proceso(1, "Proceso 1", 1))
        cola.push(Proceso(2, "Proceso 2", 2))

        var res = cola.get(3)

        assert(res == null)
    }

    @Test
    fun getAll() {
        cola.push(Proceso(1, "Proceso 1", 1))
        cola.push(Proceso(2, "Proceso 2", 2))

        val p2 = cola.getAll()[0]
        val p1 = cola.getAll()[1]

        assertAll(
            { assert(p1.id == 1) },
            { assert(p1.nombre == "Proceso 1") },
            { assert(p1.prioridad == 1) },
            { assert(p2.id == 2) },
            { assert(p2.nombre == "Proceso 2") },
            { assert(p2.prioridad == 2) }
        )
    }
}
package repositories

import models.Proceso
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class ColaImpTest {
    private lateinit var cola: ColaImp

    @BeforeEach
    fun setUp() {
        cola = ColaImp()
    }

    @Test
    fun push() {
        val cola = ColaImp()
        cola.push(Proceso(1, "Proceso 1", 1))
        cola.push(Proceso(2, "Proceso 2", 2))

        val p1 = cola.get(1)
        val p2 = cola.get(2)
        assertAll(
            { assert(cola.size() == 2) },
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
        val cola = ColaImp()
        cola.push(Proceso(1, "Proceso 1", 1))
        cola.push(Proceso(2, "Proceso 2", 2))

        val p2 = cola.pop()
        val p1 = cola.pop()

        assertAll(
            { assert(cola.size() == 0) },
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
    fun isEmpty() {
        assert(cola.isEmpty())
        cola.push(Proceso(1, "Proceso 1", 1))
        assert(!cola.isEmpty())
    }

    @Test
    fun size() {
        assert(cola.size() == 0)
        cola.push(Proceso(1, "Proceso 1", 1))
        assert(cola.size() == 1)
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
}
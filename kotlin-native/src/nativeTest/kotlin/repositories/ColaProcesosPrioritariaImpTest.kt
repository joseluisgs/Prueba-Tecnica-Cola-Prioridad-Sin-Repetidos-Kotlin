package repositories

import com.benasher44.uuid.uuid4
import models.Proceso
import kotlin.test.*

class ColaProcesosPrioritariaImpTest {
    private lateinit var cola: ColaProcesosPrioritaria

    @BeforeTest
    fun setUp() {
        cola = ColaProcesosPrioritariaImp()
    }

    @Test
    fun push() {
        val p1 = Proceso(uuid4().toString(), "proceso1", 1)
        val p2 = Proceso(uuid4().toString(), "proceso2", 2)

        val r1 = cola.push(p1)
        val r2 = cola.push(p2)

        assertTrue(r1)
        assertTrue(r2)
    }

    @Test
    fun pushRepetidos() {
        val p1 = Proceso(uuid4().toString(), "proceso1", 1)
        val p2 = Proceso(p1.id, "proceso2", 2)

        val r1 = cola.push(p1)
        val r2 = cola.push(p2)

        assertTrue(r1)
        assertFalse(r2)
    }

    @Test
    fun pop() {
        val p1 = Proceso(uuid4().toString(), "proceso1", 1)
        val p2 = Proceso(uuid4().toString(), "proceso2", 2)

        cola.push(p1)
        cola.push(p2)

        val r2 = cola.pop()!!// sale por proridad
        val r1 = cola.pop()!!

        assertEquals(r1, p1)
        assertEquals(r2, p2)
        assertTrue(r2.prioridad >= r1.prioridad)
    }

    @Test
    fun popVacio() {
        val res = cola.pop()

        assertEquals(res, null)
    }

    @Test
    fun isEmpty() {
        assertTrue(cola.isEmpty())
        val p1 = Proceso(uuid4().toString(), "proceso1", 1)
        cola.push(p1)
        assertFalse(cola.isEmpty())
    }

    @Test
    fun size() {
        assertEquals(cola.size, 0)
        val p1 = Proceso(uuid4().toString(), "proceso1", 1)
        cola.push(p1)
        assertNotEquals(cola.size, 0)
    }

    @Test
    fun getById() {
        val p1 = Proceso(uuid4().toString(), "proceso1", 1)
        cola.push(p1)

        val r1 = cola.getById(p1.id)

        assertEquals(r1, p1)

    }

    @Test
    fun getNoExiste() {
        val res = cola.getById("noexiste")

        assertEquals(res, null)
    }

    @Test
    fun getAll() {
        val p1 = Proceso(uuid4().toString(), "proceso1", 1)
        val p2 = Proceso(uuid4().toString(), "proceso2", 2)

        cola.push(p1)
        cola.push(p2)

        val r2 = cola.getAll()[0]
        val r1 = cola.getAll()[1]

        assertEquals(r1, p1)
        assertEquals(r2, p2)
        assertTrue(r2.prioridad >= r1.prioridad)
    }

    @Test
    fun getAllPrioridad() {
        val p1 = Proceso(uuid4().toString(), "proceso1", 1)
        val p2 = Proceso(uuid4().toString(), "proceso2", 2)

        cola.push(p1)
        cola.push(p2)

        val r2 = cola.getAll()[0]
        val r1 = cola.getAll()[1]

        assertEquals(r1, p1)
        assertEquals(r2, p2)
        assertTrue(r2.prioridad >= r1.prioridad)
    }
}
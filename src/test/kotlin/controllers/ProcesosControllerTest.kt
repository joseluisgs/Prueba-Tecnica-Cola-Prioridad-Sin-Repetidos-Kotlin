package controllers

import errors.ProcesoException
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import models.Proceso
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.extension.ExtendWith
import repositories.ColaProceso

// // https://mockk.io/
@ExtendWith(MockKExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // BeforeAll y AfterAll
internal class ProcesosControllerTest {
    @MockK
    lateinit var repository: ColaProceso

    @InjectMockKs
    lateinit var controller: ProcesosController

    @BeforeAll
    fun setUp() {
        MockKAnnotations.init(this)
    }

    /*
    init {
        MockKAnnotations.init(this)
    }
     */

    @AfterAll
    fun tearDown() {
        unmockkAll()
    }

    /*  @BeforeEach
      fun setUpTest() {
          //controller = ProcesosController(repository)
      }*/

    @Test
    fun getAll() {
        val p1 = Proceso(1, "Proceso 1", 6)
        val p2 = Proceso(2, "Proceso 2", 3)
        val list = listOf(p1, p2)

        // Equivale al when
        every { repository.getAll() } returns list

        val res = controller.getAll()

        assertAll(
            { assert(res.size == list.size) },
            { assert(res[0] == list[0]) },
            { assert(res[0].id == list[0].id) },
            { assert(res[0].prioridad == list[0].prioridad) },
            { assert(res[1] == list[1]) },
            { assert(res[1].id == list[1].id) },
            { assert(res[1].prioridad == list[1].prioridad) },
            { assert(res[0].prioridad >= res[1].prioridad) },
        )

        // El verify
        verify(exactly = 1) { repository.getAll() }
    }

    @Test
    fun push() {
        val p1 = Proceso(1, "Proceso 1", 6)

        every { repository.push(p1) } just Runs // equivale al doNothing()

        controller.push(p1)

        verify(exactly = 1) { repository.push(p1) }
    }


    @Test
    fun get() {
        val p1 = Proceso(1, "Proceso 1", 6)

        every { repository.get(p1.id) } returns p1

        val res = controller.get(p1.id)

        assertAll(
            { assert(res == p1) },
            { assert(res.id == p1.id) },
            { assert(res.nombre == p1.nombre) },
            { assert(res.prioridad == p1.prioridad) },
        )

        verify(atLeast = 1) { repository.get(p1.id) }
    }

    @Test
    fun pop() {
        val p1 = Proceso(1, "Proceso 1", 6)

        every { repository.pop() } returns p1

        val res = controller.pop()

        assertAll(
            { assert(res == p1) },
            { assert(res.id == p1.id) },
            { assert(res.nombre == p1.nombre) },
            { assert(res.prioridad == p1.prioridad) },
        )

        verify(exactly = 1) { repository.pop() }
    }

    @Test
    fun isEmpty() {
        every { repository.isEmpty() } returns true

        val res = controller.isEmpty()

        assertTrue(res)

        verify(exactly = 1) { repository.isEmpty() }
    }

    @Test
    fun getNoExiste() {
        val id = 1
        every { repository.get(id) } returns null

        val ex = assertThrows<ProcesoException> {
            val res = controller.get(id)
        }

        assert(ex.message == "No existe el proceso con id $id")

        verify(atLeast = 1) { repository.get(id) }
    }

    @Test
    fun popNoExiste() {
        every { repository.pop() } returns null

        val ex = assertThrows<ProcesoException> {
            controller.pop()
        }

        assert(ex.message == "No existe el procesos o la cola esta vacía")

        verify(atLeast = 1) { repository.pop() }
    }

}
import com.benasher44.uuid.uuid4
import controllers.ProcesosController
import models.Proceso
import repositories.ColaProcesosPrioritariaImp

fun main() {
    println("Hello, Kotlin/Native!")
    println("Cola con Prioridad")
    val proceso = Proceso(nombre = "Proceso Main")
    println(proceso)

    println("Hola Cola con Prioridad sin Repetidos")
    // Voy a meter valores
    val cola = ColaProcesosPrioritariaImp()
    // Compruebo la prioridad de 1 a 9
    (-2..12).forEach {
        cola.push(Proceso(nombre = "Proceso $it", prioridad = it))
    }


    // Vamos a imprimir
    println("Imprimiendo cola")
    println(cola.getAll())
    println("Tamaño cola: ${cola.size}")

    // Ahora sacamos todos los valores
    println("Sacando todos los valores")
    while (!cola.isEmpty()) {
        println(cola.pop())
    }

    // Jugamos con el controlador
    println("Jugando con el controlador")
    val controlador = ProcesosController(ColaProcesosPrioritariaImp())
    println("Metiendo procesos")
    val uuid1 = uuid4().toString()
    controlador.push(Proceso(uuid1, "Proceso 1", 8))
    controlador.push(Proceso(uuid4().toString(), "Proceso 2", 2))
    controlador.push(Proceso(uuid4().toString(), "Proceso 3", 3))

    println("Obteniendo Procesos")
    println("Proceso con id uuid: $uuid1 -> ${controlador.getById(uuid1)}")

    println("Obteniendo todos Procesos")
    controlador.getAll().forEach { println(it) }

    println("Sacando Procesos")
    while (controlador.isEmpty()) {
        println(controlador.pop())
    }

    println("Probado errores")
    try {
        println(controlador.pop())
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }

    try {
        println(controlador.getById("noexiste"))
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }

}
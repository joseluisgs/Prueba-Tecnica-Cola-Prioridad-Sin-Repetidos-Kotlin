import controllers.ProcesosController
import models.Proceso
import repositories.ColaPrioritariaImp

/**
 * Main de Ejemplo, no es necesario para el proyecto, pues con los test es suficiente
 */
fun main() {
    println("Hola Cola con Prioridad sin Repetidos")
    // Voy a meter valores
    val cola = ColaPrioritariaImp()
    cola.push(Proceso(1, "Proceso 1", 1))
    cola.push(Proceso(2, "Proceso 2", 2))
    cola.push(Proceso(3, "Proceso 3", 3))
    cola.push(Proceso(4, "Proceso 4", 4))
    cola.push(Proceso(5, "Proceso 5", 5))
    cola.push(Proceso(1, "Proceso 1", 6))
    cola.push(Proceso(2, "Proceso 2", 6))
    cola.push(Proceso(8, "Proceso 8", 8))
    cola.push(Proceso(9, "Proceso 9"))
    cola.push(Proceso(4, "Proceso 4", 4))
    cola.push(Proceso(5, "Proceso 5", 5))
    cola.push(Proceso(10, "Proceso 10", 10))
    cola.push(Proceso(11, "Proceso 11", -1))


    // Vamos a imprimir
    println("Imprimiendo cola")
    println(cola.toString())

    // Ahora sacamos todos los valores
    println("Sacando todos los valores")
    while (!cola.isEmpty()) {
        println(cola.pop())
    }

    // Jugamos con el controlador
    println("Jugando con el controlador")
    val controlador = ProcesosController(ColaPrioritariaImp())
    println("Metiendo procesos")
    controlador.push(Proceso(1, "Proceso 1", 8))
    controlador.push(Proceso(2, "Proceso 2", 2))
    controlador.push(Proceso(3, "Proceso 3", 3))

    println("Obteniendo Procesos")
    println("Proceso con id 1: ${controlador.getById(1)}")
    println("Proceso con id 3: ${controlador.getById(3)}")

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
        println(controlador.getById(1))
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }

}
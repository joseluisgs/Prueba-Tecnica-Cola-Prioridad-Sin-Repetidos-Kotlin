/* eslint-disable @typescript-eslint/restrict-template-expressions */
import Calc from './calc'
import ProcesosController from './controllers/ProcesosController'
import Proceso from './models/Proceso'
import ColaPrioritaria from './repositories/ColaPrioritaria'
import ColaPrioritariaImp from './repositories/ColaPrioritariaImp'

console.log('Hello World')
const calc = new Calc()
console.log(calc.add(1, 2))

console.log('Hola Cola con Prioridad sin Repetidos')
const cola: ColaPrioritaria = new ColaPrioritariaImp()

cola.push(new Proceso(1, 'Proceso 1', 1))
cola.push(new Proceso(2, 'Proceso 2', 2))
cola.push(new Proceso(3, 'Proceso 3', 3))
cola.push(new Proceso(4, 'Proceso 4', 4))
cola.push(new Proceso(5, 'Proceso 5', 5))
cola.push(new Proceso(1, 'Proceso 1', 6))
cola.push(new Proceso(2, 'Proceso 2', 6))
cola.push(new Proceso(8, 'Proceso 8', 8))
cola.push(new Proceso(9, 'Proceso 9'))
cola.push(new Proceso(4, 'Proceso 4', 4))
cola.push(new Proceso(5, 'Proceso 5', 5))
cola.push(new Proceso(10, 'Proceso 10', 10))
cola.push(new Proceso(11, 'Proceso 11', -1))

// Vamos a imprimir
console.log('Imprimiendo cola')
console.log(cola)

// Ahora sacamos todos los valores
console.log('Sacando todos los valores')
while (!cola.isEmpty()) {
  console.log(cola.pop())
}

// Jugamos con el controlador
console.log('Jugando con el controlador')
const controlador = new ProcesosController(new ColaPrioritariaImp())

console.log('Metiendo procesos')
controlador.push(new Proceso(1, 'Proceso 1', 8))
controlador.push(new Proceso(2, 'Proceso 2', 2))
controlador.push(new Proceso(3, 'Proceso 3', 3))

console.log('Obteniendo Procesos')
console.log('Obteniendo proceso con id 1:', controlador.getById(1))
console.log('Obteniendo proceso con id 3:', controlador.getById(3))

console.log('Obteniendo todos Procesos')
controlador.getAll().forEach(proceso => console.log(proceso))

console.log('Sacando Procesos')
while (controlador.isEmpty()) {
  console.log(controlador.pop())
}

console.log('Probado errores')
try {
  console.log(controlador.pop())
} catch (e) {
  console.log(`Error: ${e}`)
}

try {
  console.log(controlador.getById(1))
} catch (e) {
  console.log(`Error: ${e}`)
}

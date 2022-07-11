import { describe, test, assert, beforeEach } from 'vitest'
import { ColaPrioritariaImp } from '../../src/repositories/ColaPrioritariaImp'
import ColaPrioritaria from '../../src/repositories/ColaPrioritaria'
import Proceso from '../../src/models/Proceso'

// Describimos la suite
describe('Suite de test de Cola Prioritaria', () => {
  let cola: ColaPrioritaria

  // En cada test creamos la cola
  beforeEach(() => {
    cola = new ColaPrioritariaImp()
  })

  test('debería almacenar dos procesos', () => {
    const proceso1 = new Proceso(1, 'Proceso 1', 1)
    const proceso2 = new Proceso(2, 'Proceso 2', 2)

    cola.push(proceso1)
    cola.push(proceso2)

    const p1 = cola.getById(1) as Proceso
    const p2 = cola.getById(2) as Proceso

    assert.equal(p1, proceso1)
    assert.equal(p2, proceso2)
  })

  test('no debería insertar dos procesos repetidos', () => {
    const proceso1 = new Proceso(1, 'Proceso 1', 1)
    const proceso2 = new Proceso(1, 'Proceso 1', 6)

    cola.push(proceso1)
    cola.push(proceso2)

    const p1 = cola.getById(1) as Proceso
    const p2 = cola.getById(2) as Proceso

    assert.equal(p1, proceso1)
    assert.equal(p1.id, proceso1.id)
    assert.equal(p1.nombre, proceso1.nombre)
    assert.equal(p1.prioridad, proceso1.prioridad)
    assert.equal(p2, undefined)
  })

  test('debería obtener un proceso respetando prioridad', () => {
    const proceso1 = new Proceso(1, 'Proceso 1', 1)
    const proceso2 = new Proceso(2, 'Proceso 2', 2)

    cola.push(proceso1)
    cola.push(proceso2)

    const p1 = cola.pop()
    const p2 = cola.pop()

    // Por prioridad debería obtener el proceso con mayor prioridad
    assert.equal(p1, proceso2)
    assert.equal(p2, proceso1)
  })

  test('no debería obtener un proceso si está vacío', () => {
    const p1 = cola.pop()

    assert.equal(p1, undefined)
  })

  test('debería devolver vacío si es empty', () => {
    assert.equal(cola.isEmpty(), true)

    const proceso1 = new Proceso(1, 'Proceso 1', 1)
    cola.push(proceso1)

    assert.equal(cola.isEmpty(), false)
  })

  test('debería devolver el tamaño correcto', () => {
    assert.equal(cola.size(), 0)

    const proceso1 = new Proceso(1, 'Proceso 1', 1)
    cola.push(proceso1)

    assert.equal(cola.size(), 1)
  })

  test('debería obtener procesos por su id', () => {
    const proceso1 = new Proceso(1, 'Proceso 1', 1)
    const proceso2 = new Proceso(2, 'Proceso 2', 2)

    cola.push(proceso1)
    cola.push(proceso2)

    const p1 = cola.getById(1) as Proceso
    const p2 = cola.getById(2) as Proceso

    assert.equal(p1, proceso1)
    assert.equal(p2, proceso2)
  })

  test('no debería obtener un proceso que no existe', () => {
    const p1 = cola.getById(1) as Proceso

    assert.equal(p1, undefined)
  })

  test('debería obtenerlos todos', () => {
    const proceso1 = new Proceso(1, 'Proceso 1', 1)
    const proceso2 = new Proceso(2, 'Proceso 2', 2)

    cola.push(proceso1)
    cola.push(proceso2)

    const lista = cola.getAll()

    assert.equal(lista.length, 2)
    assert.isTrue(lista.includes(proceso1))
    assert.isTrue(lista.includes(proceso2))
  })

  test('debería obtenerlos respetando la prioridad', () => {
    const proceso1 = new Proceso(1, 'Proceso 1', 1)
    const proceso2 = new Proceso(2, 'Proceso 2', 2)

    cola.push(proceso1)
    cola.push(proceso2)

    const lista = cola.getAll()

    assert.equal(lista.length, 2)
    assert.isTrue(lista.includes(proceso1))
    assert.isTrue(lista.includes(proceso2))
    assert.equal(lista[0], proceso2)
    assert.equal(lista[1], proceso1)
    assert.isTrue(lista[0].prioridad >= lista[1].prioridad)
  })
})

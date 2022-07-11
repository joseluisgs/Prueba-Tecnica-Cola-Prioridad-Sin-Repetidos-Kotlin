import { describe, test, assert, beforeEach, afterEach, expect, vi } from 'vitest'
import Proceso from '../../src/models/Proceso'
import ProcesosController from '../../src/controllers/ProcesosController'
import ProcesosException from '../../src/errors/ProcesosException'
import { ColaPrioritariaImp } from '../../src/repositories/ColaPrioritariaImp'
import ColaPrioritaria from '../../src/repositories/ColaPrioritaria'

// Programamos el mock por defecto que queremos y la implementación de sus métodos
// para no tener que escribir código de prueba en todos, solo en los específicos
vi.mock('../../src/repositories/ColaPrioritariaImp', () => {
  const ColaPrioritariaImp = vi.fn(() => ({
    getAll: vi.fn(() => [new Proceso(2, 'proceso 2', 2), new Proceso(1, 'proceso 1', 1)]),
    size: vi.fn(() => 2),
    push: vi.fn(),
    pop: vi.fn(() => new Proceso(1, 'proceso 1', 1)),
    isEmpty: vi.fn(() => false),
    getById: vi.fn(() => new Proceso(1, 'proceso 1', 1)),
  }))
  return { ColaPrioritariaImp }
})

describe('Suite de test de Controlador de Procesos Mock Repositorio Cola Prioritaria', () => {
  let colaPrioritaria: ColaPrioritaria
  let procesosController: ProcesosController

  beforeEach(() => {
    colaPrioritaria = new ColaPrioritariaImp()
    procesosController = new ProcesosController(colaPrioritaria)
  })

  afterEach(() => {
    vi.clearAllMocks()
  })

  test('debería obtener todos los procesos respetando prioridad', () => {
    const res = procesosController.getAll()

    expect(colaPrioritaria.getAll).toBeCalledTimes(1)
    expect(res.length).toBe(2)
    assert.equal(res.length, 2)
    assert.isTrue(res[0].prioridad >= res[1].prioridad)
  })

  test('debería insertar un proceso', () => {
    const proceso1 = new Proceso(1, 'proceso 1', 1)

    procesosController.push(proceso1)
    const res = procesosController.getById(1)

    expect(colaPrioritaria.push).toBeCalledTimes(1)
    expect(res).toEqual(proceso1)
    assert.equal(res.id, proceso1.id)
  })

  test('debería obtener un proceso', () => {
    const res = procesosController.getById(1)

    expect(colaPrioritaria.getById).toBeCalledTimes(1)
    expect(colaPrioritaria.getById).toBeCalledWith(1)
    assert.equal(res.id, 1)
  })

  test('debería sacar un proceso', () => {
    const res = procesosController.pop()

    expect(colaPrioritaria.pop).toBeCalledTimes(1)
    assert.equal(res.id, 1)
  })

  test('debería saber si la cola está llena', () => {
    const res = procesosController.isEmpty()

    expect(colaPrioritaria.isEmpty).toBeCalledTimes(1)
    assert.isFalse(res)
  })

  test('debería saber si la cola está vacía', () => {
    // Cambio la función por defecto del mock, por la específica
    colaPrioritaria.isEmpty = vi.fn(() => true)

    const res = procesosController.isEmpty()

    expect(colaPrioritaria.isEmpty).toBeCalledTimes(1)
    assert.isTrue(res)
  })

  test('debería obtener una excepción si proceso no existe al consultar', () => {
    // Cambio la función por defecto del mock, por la específica
    colaPrioritaria.getById = vi.fn(() => undefined)

    const res = assert.throws(() => {
      procesosController.getById(1)
    }, ProcesosException) as unknown as ProcesosException

    expect(colaPrioritaria.getById).toBeCalledTimes(1)
    expect(colaPrioritaria.getById).toBeCalledWith(1)
    assert.equal(res.message, 'No existe el proceso con id 1')
  })

  test('debería obtener una excepción si proceso no existe al extraer', () => {
    // Cambio la función por defecto del mock
    colaPrioritaria.pop = vi.fn(() => undefined)

    const res = assert.throws(() => {
      procesosController.pop()
    }, ProcesosException) as unknown as ProcesosException

    expect(colaPrioritaria.pop).toBeCalledTimes(1)
    assert.equal(res.message, 'No existe el procesos o la cola esta vacía')
  })
})

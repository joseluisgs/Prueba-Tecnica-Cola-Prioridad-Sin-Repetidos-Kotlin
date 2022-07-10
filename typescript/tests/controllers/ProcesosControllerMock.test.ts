import { describe, test, assert, beforeEach, afterEach, expect, vi } from 'vitest'
import Proceso from '../../src/models/Proceso'
import ProcesosController from '../../src/controllers/ProcesosController'
import ColaPrioritaria from '../../src/repositories/ColaPrioritaria'
import ProcesosException from '../../src/errors/ProcesosException'
// import ColaPrioritariaImp from '../../src/repositories/ColaPrioritariaImp';

// import ProcesosException from '../../src/errors/ProcesosException';

// definimos mock
// vi.mock('../../src/repositories/ColaPrioritariaImp', () => {
//   const ColaPrioritariaImp = vi.fn(() => ({
//     getAll: vi.fn(() => [new Proceso(1, 'proceso 1', 1), new Proceso(2, 'proceso 2', 2)]),
//   }))
//   return { ColaPrioritariaImp }
// })

// Creamos nuestro objeto de mock completo de Cola Prioritaria
const ColaPrioritariaImp = vi.fn(() => ({
  getAll: vi.fn(() => [new Proceso(2, 'proceso 2', 2), new Proceso(1, 'proceso 1', 1)]),
  size: vi.fn(() => 2),
  push: vi.fn(),
  pop: vi.fn(() => new Proceso(1, 'proceso 1', 1)),
  isEmpty: vi.fn(() => false),
  getById: vi.fn(() => new Proceso(1, 'proceso 1', 1)),
}))

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
    assert.equal(res.id, 1)
  })

  test('debería sacar un proceso', () => {
    const res = procesosController.pop()

    expect(colaPrioritaria.pop).toBeCalledTimes(1)
    assert.equal(res.id, 1)
  })

  test('debería saber si la cola está vacía', () => {
    const res = procesosController.isEmpty()

    expect(colaPrioritaria.isEmpty).toBeCalledTimes(1)
    assert.isFalse(res)
  })
})

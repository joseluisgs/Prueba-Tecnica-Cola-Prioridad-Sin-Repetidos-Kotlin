import Proceso from '../models/Proceso'
import ColaProceso from '../repositories/ColaProceso'
import ProcesosException from '../errors/ProcesosException'

class ProcesosController {
  private readonly cola: ColaProceso

  constructor (cola: ColaProceso) {
    this.cola = cola
  }

  public push (proceso: Proceso): void {
    this.cola.push(proceso)
  }

  public get (id: number): Proceso {
    const proceso = this.cola.get(id)
    if (proceso != null) {
      return proceso
    }
    throw new ProcesosException(`No existe el proceso con id ${id}`)
  }

  public pop (): Proceso {
    const p = this.cola.pop()
    if (p != null) {
      return p
    }
    throw new ProcesosException('No existe el procesos o la cola esta vacía')
  }

  public isEmpty (): boolean {
    return this.cola.isEmpty()
  }

  public getAll (): Proceso[] {
    return this.cola.getAll()
  }
}

export default ProcesosController

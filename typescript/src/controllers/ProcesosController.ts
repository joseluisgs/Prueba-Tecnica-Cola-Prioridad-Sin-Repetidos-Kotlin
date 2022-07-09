import Proceso from '../models/Proceso'
import ColaProceso from '../repositories/ColaProceso'

class ProcesosController {
  private readonly cola: ColaProceso

  constructor (cola: ColaProceso) {
    this.cola = cola
  }

  public push (proceso: Proceso): void {
    this.cola.push(proceso)
  }

  public pop (): Proceso {
    const p = this.cola.pop()
    return p
  }

  public isEmpty (): boolean {
    return this.cola.isEmpty()
  }
}

export default ProcesosController

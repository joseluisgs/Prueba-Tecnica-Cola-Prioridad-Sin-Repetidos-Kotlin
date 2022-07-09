import ColaProceso from './ColaProceso'
import Proceso from '../models/Proceso'

class ColaProcesoImp implements ColaProceso {
  private readonly cola: Proceso[] = []

  push (item: Proceso): void {
    this.cola.push(item)
  }

  pop (): Proceso | undefined {
    return this.cola.shift()
  }

  isEmpty (): boolean {
    return this.cola.length === 0
  }
}

export default ColaProcesoImp

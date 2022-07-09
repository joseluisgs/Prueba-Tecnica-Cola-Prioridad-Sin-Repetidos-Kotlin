import ColaProceso from './ColaProceso'
import Proceso from '../models/Proceso'

class ColaProcesoImp implements ColaProceso {
  private readonly cola: Proceso[] = []

  push (item: Proceso): void {
    this.cola.push(item)
  }

  pop (): Proceso | undefined {
    if (this.cola.length > 0) {
      // Obtenemos los ids
      const prioridad = this.cola.map(proceso => {
        return proceso.prioridad
      })
      // Buscamos la maxima prioridad
      const maxPrioridad = Math.max(...prioridad)
      // Sacamos el primer proceso que lo cumple
      const proceso = this.cola.find(proceso => proceso.prioridad === maxPrioridad) as Proceso
      // Eliminamos el proceso de la cola
      this.cola.splice(this.cola.indexOf(proceso), 1)
      return proceso
    }
    return undefined
  }

  isEmpty (): boolean {
    return this.cola.length === 0
  }
}

export default ColaProcesoImp

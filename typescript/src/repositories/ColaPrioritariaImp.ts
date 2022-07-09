import ColaPrioritaria from './ColaPrioritaria'
import Proceso from '../models/Proceso'

class ColaPrioritariaImp implements ColaPrioritaria {
  private readonly cola: Proceso[] = []

  public push(item: Proceso): void {
    // Debemos comprobar que no existes para evitar repetidos por ids
    if (this.cola.find(proceso => proceso.id === item.id) === undefined) {
      this.cola.push(item)
    }
  }

  public pop(): Proceso | undefined {
    if (this.cola.length > 0) {
      // Obtenemos las prioridades
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

  public isEmpty(): boolean {
    return this.cola.length === 0
  }

  public size(): number {
    return this.cola.length
  }

  public getById(id: number): Proceso | undefined {
    return this.cola.find(proceso => proceso.id === id)
  }

  public getAll(): Proceso[] {
    return this.cola.sort((a, b) => b.prioridad - a.prioridad)
  }
}

export default ColaPrioritariaImp

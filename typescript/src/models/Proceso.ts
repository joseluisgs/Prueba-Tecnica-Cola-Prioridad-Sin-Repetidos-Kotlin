class Proceso {
  // Propiedades de solo lectura
  readonly id: number
  readonly nombre: string
  readonly prioridad: number

  // Normal signature with defaults
  constructor (id = 0, nombre = 'Proceso', prioridad = 0) {
    this.id = id
    this.nombre = nombre
    this.prioridad = prioridad
  }
}

export default Proceso

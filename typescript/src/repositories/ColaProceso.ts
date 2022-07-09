import Cola from './Cola'
import Proceso from '../models/Proceso'

interface ColaProceso extends Cola<Proceso> {
  get: (id: number) => Proceso | undefined
  getAll: () => Proceso[]
  size: () => number
}

export default ColaProceso

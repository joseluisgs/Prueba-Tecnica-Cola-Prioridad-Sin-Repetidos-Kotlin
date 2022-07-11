import Cola from '../tda/Cola'
import Proceso from '../models/Proceso'

interface ColaPrioritaria extends Cola<Proceso> {
  getById: (id: number) => Proceso | undefined
  getAll: () => Proceso[]
  size: () => number
}

export default ColaPrioritaria

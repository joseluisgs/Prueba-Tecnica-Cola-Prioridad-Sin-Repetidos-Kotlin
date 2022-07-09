import Cola from './Cola'
import Proceso from '../models/Proceso'

interface ColaProceso extends Cola<Proceso> {
  push: (item: Proceso) => void
  pop: () => Proceso | undefined
  isEmpty: () => boolean
}

export default ColaProceso

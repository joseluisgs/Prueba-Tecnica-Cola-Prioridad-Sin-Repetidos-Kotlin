
class ProcesosException extends Error {
  constructor (message: string) {
    super(message)
    this.name = 'ProcesosException'
  }
}

export default ProcesosException

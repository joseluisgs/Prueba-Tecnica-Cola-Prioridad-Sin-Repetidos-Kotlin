package errors

/**
 * Clase para tipar excepciones del tipo checked, por eso heredamos de Exception
 * Si no queremos que se propaguen, podemos usar el try-catch
 * Si queremos que sean sin checked, debemos usar RuntimeException para heredar.
 */
class ProcesoException(message: String) : Exception(message)

package repositories

/**
 * Comportamiento de una cola genérica,
 * FIFO (First In First Out)
 * Primero en entrar, primero en salir
 */
interface Cola<T> {
    fun push(item: T)
    fun pop(): T?
    fun isEmpty(): Boolean
}
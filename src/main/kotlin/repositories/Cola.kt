package repositories

interface Cola<T> {
    fun push(item: T)
    fun pop(): T?
    fun isEmpty(): Boolean
}
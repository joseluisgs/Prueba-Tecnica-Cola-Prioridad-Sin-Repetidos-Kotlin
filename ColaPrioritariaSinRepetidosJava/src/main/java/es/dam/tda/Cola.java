package es.dam.tda;

public interface Cola<T> {
    public void push(T item);
    public T pop();
    public T first();
    public boolean isEmpty();
    public int size();
}

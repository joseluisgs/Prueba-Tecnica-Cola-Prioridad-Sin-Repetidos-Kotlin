package es.dam.tda;

public interface Cola<T> {
    public void push(T item);
    public T pop();
    public boolean isEmpty();
    public int size();
}

package Interfaces;

public interface IMyQueue<T> {
    void Insert(T item) throws Exception;
    T Remove();
    boolean IsEmpty();
    void Free();
}

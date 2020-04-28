package Interfaces;

public interface IStack<T> {
    void Push(T value);
    T Pop();
    boolean IsEmpty();
    void Clear();
}

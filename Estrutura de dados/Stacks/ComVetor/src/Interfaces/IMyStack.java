package Interfaces;

public interface IMyStack<T> {
    void Push(T value);
    T Pop();
    boolean IsEmpty();
    void Clear();
}

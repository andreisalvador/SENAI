package Interfaces;

public interface ILinkedList<T> {
    void Add(T value);
    void Add(int index, T value);
    T Remove(int index);
    boolean RemoveFirst(T value);
    T Get(int index);
    void Clear();
    T Set(int index, T value);
    int Size();
    boolean IsEmpty();
    boolean Contains(T value);
    int IndexOf(T value);
    int LastIndexOf(T value);
    T[] ToArray();
}

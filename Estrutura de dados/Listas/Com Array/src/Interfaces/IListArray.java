package Interfaces;

public interface IListArray<T> {
    void Add(T value);
    void Add(T value, int index);
    T Remove(int index);
    boolean RemoveFirst(T value);
    T Get(int index);
    void Clear();
    T Set(T value, int index);
    int Size();
    boolean IsEmpty();
    boolean IsFull();
    boolean Contains(T value);
    int IndexOf(T value);
    int LastIndexOf(T value);
    T[] ToArray();
}

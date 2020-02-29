package Interfaces;

public interface IListArray<T> {
    void Add(T value) throws Exception;
    void Add(T value, int index) throws Exception;
    T Remove(int index) throws Exception;
    boolean RemoveFirst(T value) throws Exception;
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

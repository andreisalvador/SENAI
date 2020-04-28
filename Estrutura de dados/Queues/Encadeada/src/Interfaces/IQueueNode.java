package Interfaces;

public interface IQueueNode<T> {
    T getInfo();
    void setInfo(T value);
    IQueueNode<T> getNext();
    void setNext(IQueueNode<T> value);
}

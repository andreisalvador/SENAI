package Interfaces;

public interface IStackNode<T> {
    void setInfo(T value);
    T getInfo();
    void setNext(IStackNode<T> next);
    IStackNode<T> getNext();
}

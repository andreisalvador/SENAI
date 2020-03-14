package Interfaces;

public interface INodeList<T> {
    T getInfo();
    void setInfo(T value);
    INodeList<T> getNext();
    void setNext(INodeList<T> value);
}

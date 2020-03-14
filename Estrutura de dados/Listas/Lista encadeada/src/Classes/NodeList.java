package Classes;

import Interfaces.INodeList;

public class NodeList<T> implements INodeList<T> {
    private T info;
    private INodeList<T> next;

    public NodeList(){

    }

    public NodeList(T info, INodeList<T> next){
        this.info = info;
        this.next = next;
    }

    @Override
    public T getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(T value) {
        this.info = value;
    }

    @Override
    public INodeList<T> getNext() {
        return this.next;
    }

    @Override
    public void setNext(INodeList<T> value) {
        this.next = value;
    }
}

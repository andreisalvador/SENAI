import Interfaces.IQueueNode;

public class QueueNode<T> implements IQueueNode<T> {
    private T info = null;
    private IQueueNode<T> next = null;

    public QueueNode(T info, IQueueNode<T> next){
        this.info = info;
        this.next = next;
    }

    public QueueNode(T info){
        this.info = info;
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
    public IQueueNode<T> getNext() {
        return next;
    }

    @Override
    public void setNext(IQueueNode<T> value) {
        this.next = value;
    }
}

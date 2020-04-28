import Interfaces.IStackNode;

public class StackNode<T> implements IStackNode<T> {
    private T value;
    private IStackNode<T> next;

    public StackNode(T value, IStackNode<T> next) {
        this(value);
        this.next = next;
    }

    public StackNode(T value) {
        this.value = value;
    }

    @Override
    public void setInfo(T value) {
        this.value = value;
    }

    @Override
    public T getInfo() {
        return this.value;
    }

    @Override
    public void setNext(IStackNode<T> next) {
        this.next = next;
    }

    @Override
    public IStackNode<T> getNext() {
        return this.next;
    }
}

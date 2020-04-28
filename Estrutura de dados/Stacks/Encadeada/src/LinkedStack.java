import Interfaces.IStack;
import Interfaces.IStackNode;

public class LinkedStack<T> implements IStack<T> {
    private IStackNode<T> top;

    @Override
    public void Push(T value) {
        IStackNode<T> newNode = this.top == null ? new StackNode<>(value) : new StackNode<>(value, this.top);
        this.top = newNode;
    }

    @Override
    public T Pop() {
        T result = this.top.getInfo();
        this.top = this.top.getNext();
        return result;
    }

    @Override
    public boolean IsEmpty() {
        return this.top == null;
    }

    @Override
    public void Clear() {
        this.top = null;
    }
}

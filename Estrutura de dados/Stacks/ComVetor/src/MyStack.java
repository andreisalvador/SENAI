import Interfaces.IMyStack;

public class MyStack<T> implements IMyStack<T> {
    private int stackMaxLength;
    private T[] stack;
    private int recordCounter = 0;

    public MyStack(int stackSize) {
        this.stackMaxLength = stackSize;
        this.stack = (T[]) new Object[stackSize];
    }

    @Override
    public void Push(T value) {
        this.stack[recordCounter++] = value;
    }

    @Override
    public T Pop() {
        return this.stack[(recordCounter--) - 1];
    }

    @Override
    public boolean IsEmpty() {
        return recordCounter == 0;
    }

    @Override
    public void Clear() {
        this.stack = (T[]) new Object[stackMaxLength];
        this.recordCounter = 0;
    }
}

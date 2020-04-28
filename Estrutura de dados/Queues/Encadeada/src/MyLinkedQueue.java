import Interfaces.IMyQueue;
import Interfaces.IQueueNode;

public class MyLinkedQueue<T> implements IMyQueue<T> {
    private IQueueNode<T> first;
    private IQueueNode<T> last;

    @Override
    public void Insert(T item) throws Exception {
        IQueueNode<T> newNode = new QueueNode<T>(item);

        if (this.first == null && this.last == null) {
            this.first = newNode;
        } else {
            if (this.first.getNext() == null) {
                this.first.setNext(newNode);
            } else {
                IQueueNode<T> next = this.first.getNext();

                while (next.getNext() != null)
                    next = next.getNext();

                next.setNext(newNode);
            }
        }

        this.last = newNode;
    }

    @Override
    public T Remove() {
        IQueueNode<T> newFirst = this.first.getNext();
        T result = this.first.getInfo();
        this.first = newFirst;

        if(newFirst == null)
            this.last = null;

        return result;
    }

    @Override
    public boolean IsEmpty() {
        return this.first == null;
    }

    @Override
    public void Free() {
        this.first = null;
        this.last = null;
    }
}

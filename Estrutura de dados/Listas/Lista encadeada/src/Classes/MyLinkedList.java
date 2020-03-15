package Classes;

import Classes.NodeIntervals.NodeListInterval;
import Classes.NodeIntervals.NodeListIntervalResult;
import Interfaces.*;

public class MyLinkedList<T> implements ILinkedList<T> {
    private INodeList<T> first;
    private INodeList<T> last;
    private int counter;

    @Override
    public void Add(T value) {
        this.Add(this.counter, value);
    }

    @Override
    public void Add(int index, T value) {
        if (index > this.counter || index < 0)
            throw new IndexOutOfBoundsException("Index fora dos limites da lista.");

        INodeList<T> newNode = new NodeList<T>(value);

        if (this.first == null && this.last == null) {
            this.first = newNode;
            this.last = newNode;
        } else {
            NodeListIntervalResult<T> nodeInterval = new NodeListInterval<T>(this.first).GetIntervalFromTargetNodeIndex(index);

            if (nodeInterval.HasNextNode())
                newNode.setNext(nodeInterval.getTargetNode());

            if (nodeInterval.HasLastNode())
                nodeInterval.getLastNodeBeforeTargetNode().setNext(newNode);
            else
                this.first = newNode;
        }

        this.counter++;
    }

    @Override
    public T Remove(int index) {
        if (index > this.counter || index < 0)
            throw new IndexOutOfBoundsException("Index fora dos limites da lista.");

        NodeListIntervalResult<T> nodeInterval = new NodeListInterval<T>(this.first).GetIntervalFromTargetNodeIndex(index);

        nodeInterval.getLastNodeBeforeTargetNode().setNext(nodeInterval.getNextNodeAfterTargetNode());
        nodeInterval.getTargetNode().setNext(null);

        return nodeInterval.getTargetNode().getInfo();
    }

    @Override
    public boolean RemoveFirst(T value) {
        return Remove(IndexOf(value)) != null;
    }

    @Override
    public T Get(int index) {
        INodeList<T> node = this.first;
        for (int i = 0; i < counter; i++) {
            if (i == index)
                break;
            node = node.getNext();
        }
        return node.getInfo();
    }

    @Override
    public void Clear() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public T Set(int index, T value) {
        NodeListIntervalResult<T> nodeInterval = new NodeListInterval<T>(this.first).GetIntervalFromTargetNodeIndex(index);

        INodeList<T> newNode = new NodeList<>(value, nodeInterval.getNextNodeAfterTargetNode());
        nodeInterval.getLastNodeBeforeTargetNode().setNext(newNode);
        nodeInterval.getTargetNode().setNext(null);

        return nodeInterval.getTargetNode().getInfo();
    }

    @Override
    public int Size() {
        return this.counter;
    }

    @Override
    public boolean IsEmpty() {
        return this.first == null;
    }

    @Override
    public boolean Contains(T value) {
        return this.IndexOf(value) != -1;
    }

    @Override
    public int IndexOf(T value) {
        return InternalIndexOf(value, false);
    }

    @Override
    public int LastIndexOf(T value) {
        return InternalIndexOf(value, true);
    }

    @Override
    public T[] ToArray() {
        INodeList<T> node = this.first;
        T[] result = (T[]) new Object[counter];
        for (int i = 0; i < counter; i++) {
            if (node != null) {
                result[i] = node.getInfo();
                node = node.getNext();
            } else
                break;
        }
        return result;
    }

    private int InternalIndexOf(T value, boolean untilLast) {
        INodeList<T> node = this.first;
        int index = -1;

        for (int i = 0; i < counter; i++) {
            if (node.getInfo() == value) {
                index = i;
                if (!untilLast)
                    break;
            } else
                node = node.getNext();
        }
        return index;
    }
}

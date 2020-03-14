package Classes;

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
        BeforeAdd(index, value);

        INodeList<T> lastNodeBeforeAdd = null;
        INodeList<T> nextNodeBeforeAdd = null;
        INodeList<T> currentNode = this.first;

        for (int i = 0; i <= index; i++) {
            if (i + 1 == index){
                lastNodeBeforeAdd = currentNode;
                nextNodeBeforeAdd = currentNode.getNext();
            }
            if (currentNode != null)
                currentNode = currentNode.getNext();
        }

        INodeList<T> newNode = new NodeList<T>(value, nextNodeBeforeAdd);
        lastNodeBeforeAdd.setNext(newNode);

        AfterAdd(index, value);
    }

    @Override
    public T Remove(T value) {
        INodeList<T> node = this.first;
        INodeList<T> lastNode = null;
        T info = this.first.getInfo();

        while (info != value) {
            lastNode = node;
            node = node.getNext();
            info = node.getInfo();
        }

        lastNode.setNext(node.getNext());
        node.setNext(null);

        return node.getInfo();
    }

    @Override
    public boolean RemoveFirst(T value) {
        return Remove(value) != null;
    }

    @Override
    public T Get(int index) {
        return null;
    }

    @Override
    public void Clear() {
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    @Override
    public T Set(int index, T value) {
        return null;
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
        return 0;
    }

    @Override
    public int LastIndexOf(T value) {
        return 0;
    }

    @Override
    public T[] ToArray() {
        return null;
    }

    private void BeforeAdd(int index, T value) {
        if (this.counter == 0) {
            INodeList<T> node = new NodeList<T>(value, null);
            this.first = node;
            this.last = node;
        } else if (index == -1) {
            INodeList<T> node = new NodeList<T>(value, null);
            INodeList<T> oldLast = this.last;
            oldLast.setNext(node);
            this.last = node;
        }
    }

    private void AfterAdd(int index, T value) {
        this.counter++;
    }
}

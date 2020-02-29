import Interfaces.IListArray;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ListArray<T> implements IListArray<T> {
    private T[] internalArray;
    private boolean resizable;
    private int initialCapacity;
    private int size;
    private static int x = 7;

    public ListArray() {
        this(10);
    }

    public ListArray(int capacity) {
        this(capacity, true);
    }

    public ListArray(int capacity, boolean resizable) {
        this.resizable = resizable;
        this.initialCapacity = capacity;
        this.internalArray = (T[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public void Add(T value) throws Exception {
        this.Add(value, this.size);
    }

    @Override
    public void Add(T value, int index) throws Exception {
        BeforeAdd(value, index);
        this.internalArray[index] = value;
        AfterAdd(value, index);
    }

    @Override
    public T Remove(int index) throws Exception {
        T result = this.internalArray[index];

        BeforeRemove(index);
        this.internalArray[index] = null;
        AfterRemove(index);

        return result;
    }

    @Override
    public boolean RemoveFirst(T value) throws Exception {
        return Remove(this.IndexOf(value)) != null;
    }

    @Override
    public T Get(int index) {
        return internalArray[index];
    }

    @Override
    public void Clear() {
        this.internalArray = null;
        this.internalArray = (T[]) new Object[initialCapacity];
        this.size = 0;
    }

    @Override
    public T Set(T value, int index) {
        T result = this.Get(index);
        internalArray[index] = value;
        return result;
    }

    @Override
    public int Size() {
        return this.size;
    }

    @Override
    public boolean IsEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean IsFull() {
        return (this.size == initialCapacity && !resizable) || (this.size == this.internalArray.length);
    }

    @Override
    public boolean Contains(T value) {
        return IndexOf(value) != -1;
    }

    @Override
    public int IndexOf(T value) {

        for (int index = 0; index < this.internalArray.length; index++)
            if(this.internalArray[index] == value)
                return index;

        return -1;
    }

    @Override
    public int LastIndexOf(T value) {

        for (int index = this.size; index > 0 ; index--) {
            if(internalArray[index] == value)
                return index;
        }

        return -1;
    }

    @Override
    public T[] ToArray() {
        return (T[])Arrays.copyOfRange(this.internalArray, 0, size - 1);
    }

    private void ResizeListArray() {
        this.internalArray = Arrays.copyOf(this.internalArray, this.internalArray.length + this.x);
    }

    private void BeforeAdd(T value, int index) throws Exception {
        if(this.IsFull() && !resizable)
            throw new Exception("You can't add value to list because it's full and not resazible.");

        if (this.IsFull())
            ResizeListArray();

        if (index != this.size)
            for (int from = this.size; from >= index ; from--) {
                int to = from + 1;
                this.internalArray[to] = this.internalArray[from];
            }
    }

    private void AfterAdd(T value, int index) {
        this.size++;
    }

    private void BeforeRemove(int index) throws Exception {
        if(this.IsEmpty())
            throw new Exception("You can't remove value because list is empty.");

    }

    private void AfterRemove(int index) {
        for (int from = index + 1; from < this.size; from++) {
            int to = from - 1;
            this.internalArray[to] = this.internalArray[from];
        }
        this.internalArray[size - 1] = null;
        this.size--;
    }
}

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
    public void Add(T value) {
        this.Add(value, this.GetInternalIndex());
    }

    @Override
    public void Add(T value, int index) {
        AfterAdd();
        this.internalArray[index] = value;
        BeforeAdd();
    }

    @Override
    public T Remove(int index) {
        return null;
    }

    @Override
    public boolean RemoveFirst(int index) {
        return false;
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
        return (this.size == initialCapacity && !resizable) || (this.size == this.internalArray.length + this.x);
    }

    @Override
    public boolean Contains(T value) {
        return false;
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
        return Arrays.copyOfRange(this.internalArray, 0, size - 1);
    }

    private void ResizeListArray() {
        this.internalArray = Arrays.copyOf(this.internalArray, this.internalArray.length + this.x);
    }

    private void BeforeAdd(){
        if(this.IsFull())
            ResizeListArray();
    }

    private void AfterAdd(){
        this.size++;
    }

    private void BeforeRemove(){

    }
    private void AfterRemove(){
        this.size--;
    }

    private int GetInternalIndex() {
        return this.size > 0 ? this.size - 1 : 0;
    }
}

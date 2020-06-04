package Interfaces;

public interface ITree<T> {
    boolean Add(T item);
    boolean Add(T item, int fatherIndex, boolean override);
    boolean IsEmpty();
    boolean IsFull();
    boolean BelongsToTheTree(T item);
    int GetNodesQuantity();
    int GetCurrentHeight();
    void Free();
}

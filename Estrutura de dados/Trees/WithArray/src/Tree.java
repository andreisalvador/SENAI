import Interfaces.ITree;

import java.util.Arrays;

public class Tree<T> implements ITree<T> {
    private final int MAIN_NODE = 1;
    private int height = 0;
    private int maxHeight = 0;
    private int degree = 2;
    private T[] arrayTree;
    private int currentFather = 0;
    private int maxNodesAllowedInTree = 0;


    public Tree(int maxHeight, int degree){
        this(maxHeight);
        this.degree = degree;
        this.maxNodesAllowedInTree = GetMaxTreeNodesAllowedByHeight(maxHeight) + MAIN_NODE;
        this.arrayTree = (T[])new Object[maxNodesAllowedInTree];
    }

    public Tree(int maxHeight){
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean Add(T item) {

        int nodesQuantity = GetNodesQuantity();

        Add(item, currentFather, false);
        UpdateHeight();

        if(nodesQuantity > 0 && nodesQuantity % degree == 0)
            currentFather++;

        return true;
    }

    @Override
    public boolean Add(T item, int fatherIndex, boolean override) {
        if(fatherIndex == 0 && arrayTree[fatherIndex] == null){
            arrayTree[fatherIndex] = item;
        }else{
            SetTreeItem(item, fatherIndex, override);
        }
        return true;
    }

    @Override
    public boolean IsEmpty() {
        return arrayTree.length == 0;
    }

    @Override
    public boolean IsFull() {
        return arrayTree.length == GetMaxTreeNodesAllowedByHeight(maxHeight);
    }

    @Override
    public boolean BelongsToTheTree(T item) {
        return Arrays.stream(arrayTree).anyMatch(item::equals);
    }

    @Override
    public int GetNodesQuantity() {
        return (int)Arrays.stream(arrayTree).filter(item -> item != null).count();
    }

    @Override
    public int GetCurrentHeight() {
        return height;
    }

    @Override
    public void Free() {
        this.arrayTree = null;
        this.arrayTree = (T[]) new Object[maxNodesAllowedInTree];
    }

    private void UpdateHeight() {
        int quantityAllowedWithCurrentHeight = GetMaxTreeNodesAllowedByHeight(height) + MAIN_NODE;

        if(quantityAllowedWithCurrentHeight < GetNodesQuantity())
            height++;
        else if(quantityAllowedWithCurrentHeight > GetNodesQuantity())
            height--;
    }

    private int GetMaxTreeNodesAllowedByHeight(int maxHeight){
        int nodesAllowedQuantity = 0;

        for (int exponent = 1; exponent <= maxHeight ; exponent++)
            nodesAllowedQuantity += Math.pow(degree, exponent);

        return nodesAllowedQuantity;
    }

    private boolean HasChidren(int fatherIndex) {
        int index = degree * fatherIndex + 1;
        return index < maxNodesAllowedInTree &&  arrayTree[index] != null;
    }

    private void SetTreeItem(T item, int fatherIndex, boolean override) {
        for (int nodePosition = 1; nodePosition <= degree; nodePosition++){
            if(arrayTree[degree * fatherIndex + nodePosition] == null){
                arrayTree[degree * fatherIndex + nodePosition] = item;
                break;
            }else if(override){
                arrayTree[degree * fatherIndex + nodePosition] = item;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sbTree = new StringBuilder();

        if(!IsEmpty())
            DrawTree(sbTree, 0, 1);

        return sbTree.toString();
    }

    private void DrawTree(StringBuilder sbTree, int fatherIndex, int lastFatherIndex){
        for (int index = fatherIndex; index < lastFatherIndex; index++) {

            T currentNode = arrayTree[index];

            if(currentNode == null)
                break;

            sbTree.append("(").append(currentNode);

            if(HasChidren(index)){
                int firstChildIndex = degree * index + 1;
                int lastChildIndex = firstChildIndex + degree;

                 DrawTree(sbTree, firstChildIndex, lastChildIndex);
            }

            sbTree.append(")");
        }
    }
}

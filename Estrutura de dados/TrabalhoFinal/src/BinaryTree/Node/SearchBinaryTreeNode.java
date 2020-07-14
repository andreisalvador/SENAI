package BinaryTree.Node;

public class SearchBinaryTreeNode {
    private int value;
    SearchBinaryTreeNode leftNode;
    SearchBinaryTreeNode rightNode;

    public SearchBinaryTreeNode(int value) {
         this.value = value;
    }

    public SearchBinaryTreeNode(int value, SearchBinaryTreeNode leftNode, SearchBinaryTreeNode rightNode){
        this(value);
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public SearchBinaryTreeNode getLeftNode(){
        return leftNode;
    }

    public SearchBinaryTreeNode getRightNode(){
        return rightNode;
    }

    public void UpdateChildNodeReference(SearchBinaryTreeNode searchBinaryTreeNodeNewReference, SearchBinaryTreeNodeSide updateReferenceSide){
        if(updateReferenceSide == SearchBinaryTreeNodeSide.Left) leftNode = searchBinaryTreeNodeNewReference;
        else rightNode = searchBinaryTreeNodeNewReference;
    }
}

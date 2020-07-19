package BinaryTree;

import BinaryTree.Node.SearchBinaryTreeNode;
import BinaryTree.Node.SearchBinaryTreeNodeSide;
import Sorts.BubbleSort;
import Sorts.MergeSort;
import Sorts.QuickSort;
import Utils.Incrementer;

public class SearchBinaryTree {
    private SearchBinaryTreeNode rootNode;
    private int quantity = 0;

    public SearchBinaryTreeNode Search(int value) {
        return Search(rootNode, value);
    }

    public SearchBinaryTreeNode Search(SearchBinaryTreeNode searchBinaryTreeNode, int value) {
        if (searchBinaryTreeNode == null) return null;
        else {
            if (value < searchBinaryTreeNode.getValue())
                return Search(searchBinaryTreeNode.getLeftNode(), value);
            else if (value > searchBinaryTreeNode.getValue())
                return Search(searchBinaryTreeNode.getRightNode(), value);
            else
                return searchBinaryTreeNode;
        }
    }

    public void Insert(int value) {
        if (rootNode == null)
            rootNode = Insert(null, value);
        else
            Insert(rootNode, value);

        quantity++;
    }

    public SearchBinaryTreeNode Insert(SearchBinaryTreeNode searchBinaryTreeNode, int value) {
        if (searchBinaryTreeNode == null)
            searchBinaryTreeNode = new SearchBinaryTreeNode(value);
        else {
            if (value < searchBinaryTreeNode.getValue())
                searchBinaryTreeNode.UpdateChildNodeReference(Insert(searchBinaryTreeNode.getLeftNode(), value), SearchBinaryTreeNodeSide.Left);
            else
                searchBinaryTreeNode.UpdateChildNodeReference(Insert(searchBinaryTreeNode.getRightNode(), value), SearchBinaryTreeNodeSide.Right);
        }
        return searchBinaryTreeNode;
    }

    public void Remove(int value) {
        Remove(rootNode, value);
        quantity--;
    }

    public SearchBinaryTreeNode Remove(SearchBinaryTreeNode searchBinaryTreeNode, int value) {
        if (searchBinaryTreeNode == null) return null;
        else {
            if (value < searchBinaryTreeNode.getValue())
                searchBinaryTreeNode.UpdateChildNodeReference(Remove(searchBinaryTreeNode.getLeftNode(), value), SearchBinaryTreeNodeSide.Left);
            else {
                if (value > searchBinaryTreeNode.getValue())
                    searchBinaryTreeNode.UpdateChildNodeReference(Remove(searchBinaryTreeNode.getRightNode(), value), SearchBinaryTreeNodeSide.Right);
                else {
                    if (searchBinaryTreeNode.getLeftNode() == null && searchBinaryTreeNode.getRightNode() == null)
                        searchBinaryTreeNode = null;
                    else {
                        if (searchBinaryTreeNode.getLeftNode() == null)
                            searchBinaryTreeNode = searchBinaryTreeNode.getRightNode();
                        else {
                            if (searchBinaryTreeNode.getRightNode() == null)
                                searchBinaryTreeNode = searchBinaryTreeNode.getLeftNode();
                            else {
                                SearchBinaryTreeNode node = searchBinaryTreeNode.getLeftNode();

                                while (node.getRightNode() != null)
                                    node = node.getRightNode();

                                searchBinaryTreeNode.setValue(node.getValue());
                                node.setValue(value);
                                searchBinaryTreeNode.UpdateChildNodeReference(Remove(searchBinaryTreeNode.getLeftNode(), value), SearchBinaryTreeNodeSide.Left);
                            }
                        }
                    }
                }
            }
        }
        return searchBinaryTreeNode;
    }

    private void ByLevel(SearchBinaryTreeNode node, int[] array, Incrementer incrementer) {
        if (node != null) {
            array[incrementer.Value] = node.getValue();
            incrementer.Increment();

            SearchBinaryTreeNode leftNode = node.getLeftNode();
            SearchBinaryTreeNode rightNode = node.getRightNode();

            if (leftNode != null) ByLevel(leftNode, array, incrementer);
            if (rightNode != null) ByLevel(rightNode, array, incrementer);
        }
    }

    private void InOrder(SearchBinaryTreeNode node, int[] array, Incrementer incrementer) {
        if (node != null) {
            InOrder(node.getLeftNode(), array, incrementer);
            array[incrementer.Value] = node.getValue();
            incrementer.Increment();
            InOrder(node.getRightNode(), array, incrementer);
        }
    }

    private void PreOrder(SearchBinaryTreeNode node, int[] array, Incrementer incrementer) {
        if (node != null) {
            array[incrementer.Value] = node.getValue();
            incrementer.Increment();
            InOrder(node.getLeftNode(), array, incrementer);
            InOrder(node.getRightNode(), array, incrementer);
        }
    }

    private void PostOrder(SearchBinaryTreeNode node, int[] array, Incrementer incrementer) {
        if (node != null) {
            InOrder(node.getLeftNode(), array, incrementer);
            InOrder(node.getRightNode(), array, incrementer);
            array[incrementer.Value] = node.getValue();
            incrementer.Increment();
        }
    }

    public int[] ToArrayByLevel() {
        int[] arrayResult = new int[quantity];
        ByLevel(rootNode, arrayResult, new Incrementer());
        return arrayResult;
    }

    public int[] BubbleSortByLevel() {
        int[] array = ToArrayByLevel();
        BubbleSort.Sort(array);
        return array;
    }

    public int[] QuickSortByLevel() {
        int[] array = ToArrayByLevel();
        QuickSort.Sort(array);
        return array;
    }

    public int[] MergeSortByLevel() {
        int[] array = ToArrayByLevel();
        MergeSort.Sort(array);
        return array;
    }

    public int[] ToArrayInOrder() {
        int[] arrayResult = new int[quantity];
        InOrder(rootNode, arrayResult, new Incrementer());
        return arrayResult;
    }

    public int[] BubbleSortInOrder() {
        int[] array = ToArrayInOrder();
        BubbleSort.Sort(array);
        return array;
    }

    public int[] QuickSortInOrder() {
        int[] array = ToArrayInOrder();
        QuickSort.Sort(array);
        return array;
    }

    public int[] MergeSortInOrder() {
        int[] array = ToArrayInOrder();
        MergeSort.Sort(array);
        return array;
    }

    public int[] ToArrayPreOrder() {
        int[] arrayResult = new int[quantity];
        PreOrder(rootNode, arrayResult, new Incrementer());
        return arrayResult;
    }

    public int[] BubbleSortPreOrder() {
        int[] array = ToArrayPreOrder();
        BubbleSort.Sort(array);
        return array;
    }

    public int[] QuickSortPreOrder() {
        int[] array = ToArrayPreOrder();
        QuickSort.Sort(array);
        return array;
    }

    public int[] MergeSortPreOrder() {
        int[] array = ToArrayPreOrder();
        MergeSort.Sort(array);
        return array;
    }

    public int[] ToArrayPostOrder() {
        int[] arrayResult = new int[quantity];
        PostOrder(rootNode, arrayResult, new Incrementer());
        return arrayResult;
    }

    public int[] BubbleSortPostOrder() {
        int[] array = ToArrayPostOrder();
        BubbleSort.Sort(array);
        return array;
    }

    public int[] QuickSortPostOrder() {
        int[] array = ToArrayPostOrder();
        QuickSort.Sort(array);
        return array;
    }

    public int[] MergeSortPostOrder() {
        int[] array = ToArrayPostOrder();
        MergeSort.Sort(array);
        return array;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        PrintNode(rootNode, stringBuilder);
        return stringBuilder.toString();
    }

    private void PrintNode(SearchBinaryTreeNode node, StringBuilder stringBuilder) {
        stringBuilder.append(FormatNodeString(node));

        if (node == null)
            return;

        PrintNode(node.getLeftNode(), stringBuilder);

        PrintNode(node.getRightNode(), stringBuilder);

        stringBuilder.append(">");
    }

    private String FormatNodeString(SearchBinaryTreeNode node) {
        if (node == null)
            return "<>";

        return String.format("<%s", node.getValue());
    }
}

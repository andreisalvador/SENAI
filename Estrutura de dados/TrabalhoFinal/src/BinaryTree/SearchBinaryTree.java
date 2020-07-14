package BinaryTree;

import BinaryTree.Node.SearchBinaryTreeNode;
import BinaryTree.Node.SearchBinaryTreeNodeSide;
import Sorts.BubbleSort;
import Sorts.MergeSort;
import Sorts.QuickSort;
import Utils.Incrementer;

import java.util.function.Function;

public class SearchBinaryTree {
    private SearchBinaryTreeNode rootNode;
    private int quantity = 0;

    public SearchBinaryTreeNode Search(int value){
        return Search(rootNode, value);
    }

    public SearchBinaryTreeNode Search(SearchBinaryTreeNode searchBinaryTreeNode, int value){
        if(searchBinaryTreeNode == null) return null;
        else{
            if(value < searchBinaryTreeNode.getValue())
                return Search(searchBinaryTreeNode.getLeftNode(), value);
            else if(value > searchBinaryTreeNode.getValue())
                return  Search(searchBinaryTreeNode.getRightNode(), value);
            else
                return searchBinaryTreeNode;
        }
    }

    public void Insert(int value){
        if(rootNode == null)
            rootNode = Insert(null, value);
        else
            Insert(rootNode, value);

        quantity++;
    }

    public SearchBinaryTreeNode Insert(SearchBinaryTreeNode searchBinaryTreeNode, int value){
        if(searchBinaryTreeNode == null)
            searchBinaryTreeNode = new SearchBinaryTreeNode(value);
        else{
            if(value < searchBinaryTreeNode.getValue())
                searchBinaryTreeNode.UpdateChildNodeReference(Insert(searchBinaryTreeNode.getLeftNode(), value), SearchBinaryTreeNodeSide.Left);
            else
                searchBinaryTreeNode.UpdateChildNodeReference(Insert(searchBinaryTreeNode.getRightNode(), value), SearchBinaryTreeNodeSide.Right);
        }
        return searchBinaryTreeNode;
    }

    public void Remove(int value){
        Remove(rootNode, value);
    }

    public SearchBinaryTreeNode Remove(SearchBinaryTreeNode searchBinaryTreeNode, int value){
        if(searchBinaryTreeNode == null) return null;
        else{
            if(value < searchBinaryTreeNode.getValue())
                searchBinaryTreeNode.UpdateChildNodeReference(Remove(searchBinaryTreeNode.getLeftNode(), value), SearchBinaryTreeNodeSide.Left);
            else {
                if(value > searchBinaryTreeNode.getValue())
                    searchBinaryTreeNode.UpdateChildNodeReference(Remove(searchBinaryTreeNode.getRightNode(), value), SearchBinaryTreeNodeSide.Right);
                else{
                    if(searchBinaryTreeNode.getLeftNode() == null && searchBinaryTreeNode.getRightNode() == null)
                        searchBinaryTreeNode = null;
                    else{
                        if(searchBinaryTreeNode.getLeftNode() == null)
                            searchBinaryTreeNode = searchBinaryTreeNode.getRightNode();
                        else{
                            if(searchBinaryTreeNode.getRightNode() == null)
                                searchBinaryTreeNode = searchBinaryTreeNode.getLeftNode();
                            else{
                                SearchBinaryTreeNode node = searchBinaryTreeNode.getLeftNode();

                                while(node.getRightNode() != null)
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
        quantity--;
        return searchBinaryTreeNode;
    }

    private void ByLevel(SearchBinaryTreeNode node, int[] array, Incrementer incrementer){
        if(node != null){
            int index = incrementer.Value;
            array[index] = node.getValue();
            incrementer.Increment();

            SearchBinaryTreeNode leftNode = node.getLeftNode();
            SearchBinaryTreeNode rightNode = node.getRightNode();

            if(leftNode != null) ByLevel(leftNode, array, incrementer);
            if(rightNode != null) ByLevel(rightNode, array, incrementer);
        }
    }

    public int[] ToArrayByLevel(){
        int[] arrayResult = new int[quantity];
        ByLevel(rootNode, arrayResult, new Incrementer());
        return arrayResult;
    }

    public String ToArrayInOrder(){
        return  "";
    }

    public String ToArrayPostOrder(){
        return  "";
    }

    public String ToStringPreOrder(){
        return  "";
    }

    public int[] BubbleSort(){
        int[] result = null;
        BubbleSort.Sort(result);
        return  result;
    }

    public int[] BubbleSortByLevel(){
        int[] array = ToArrayByLevel();
        BubbleSort.Sort(array);
        return array;
    }

    public int[] QuickSortByLevel(){
        int[] array = ToArrayByLevel();
        QuickSort.Sort(array, 0, array.length - 1);
        return array;
    }

    public int[] MergeSortByLevel(){
        int[] array = ToArrayByLevel();
        MergeSort.Sort(array, 0, array.length - 1);
        return array;
    }

    public int[] QuickSort(){
        int[] result = null;
        QuickSort.Sort(null, 0, result.length - 1);
        return result;
    }

    public int[] MergeSort(){
        int[] result = null;
        MergeSort.Sort(result, 0, result.length);
        return result;
    }
}

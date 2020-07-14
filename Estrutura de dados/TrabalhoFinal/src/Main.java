import javax.swing.*;

import BinaryTree.SearchBinaryTree;
import Timer.TimeWatcher;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        SearchBinaryTree tree = new SearchBinaryTree();
        TimeWatcher<SearchBinaryTree> watcher = new TimeWatcher<SearchBinaryTree>(tree);
        tree.Insert(6);
        tree.Insert(2);
        tree.Insert(8);
        tree.Insert(1);
        tree.Insert(4);
        tree.Insert(3);

        watcher.Watch("BubbleSortByLevel", "QuickSortByLevel", "MergeSortByLevel");
        System.out.println(watcher.GetDiagnosticsReport());

    }
}

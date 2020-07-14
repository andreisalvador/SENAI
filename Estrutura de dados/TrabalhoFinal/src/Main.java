import javax.swing.*;

import BinaryTree.SearchBinaryTree;
import Timer.TimeWatcher;

import java.lang.reflect.InvocationTargetException;
import java.security.SignedObject;

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
        watcher.ApplyDefaultToStringFunctionToMethodsResult((Object array) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int value: (int[])array) sb.append(String.format(" %s ", value));
            sb.append("]");
            return sb.toString();
        });
//watcher.Watch("BubbleSortByLevel");
        watcher.Watch("BubbleSortByLevel", "QuickSortByLevel", "MergeSortByLevel");
        System.out.println(watcher.GetDiagnosticsReport());

    }
}

package App;

import BinaryTree.SearchBinaryTree;
import Timer.TimeWatcher;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Application {
    private SearchBinaryTree tree;
    private TimeWatcher<SearchBinaryTree> watcher;
    public Application(SearchBinaryTree tree){
        this.tree = tree;
        this.watcher = new TimeWatcher<>(tree);
    }

    public ArrayList<String> PrepareMethodsToWatch(){
        String[] orders = {"InOrder","ByLevel","PreOrder","PostOrder"};
        String[] sortTypes = {"MergeSort","QuickSort","BubbleSort"};
        ArrayList<String> methodsToWatch = new ArrayList<>(17);

        for (int i = 0; i < orders.length; i++) {
            methodsToWatch.add(String.format("ToArray%s", orders[i]));

            for (int j = 0; j < sortTypes.length; j++) {
                methodsToWatch.add(String.format("%s%s", sortTypes[j], orders[i]));
            }
        }

        return methodsToWatch;
    }

    public String GetResults() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        watcher.ApplyDefaultToStringFunctionToMethodsResult((Object array) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int value: (int[])array) sb.append(String.format(" %s ", value));
            sb.append("]");
            return sb.toString();
        });
        watcher.Watch(PrepareMethodsToWatch());
        return watcher.GetDiagnosticsReport();
    }
}

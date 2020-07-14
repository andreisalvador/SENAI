package Timer;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TimeWatcher<T> {
    private T objectToWatch;
    private ArrayList<TimeWatcherDiagnostic> diagnostics;
    private Function<Object, String> defaultToStringFunctionMethodResult;

    public TimeWatcher(T objectToWatch){
        this.objectToWatch = objectToWatch;
        this.diagnostics = new ArrayList<TimeWatcherDiagnostic>();
    }

    public void Watch(String methodName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Watch(methodName, null);
    }

    public <T> void Watch(String methodName, Function<T, String> methodResultToStringFunction) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        double startedAt = System.currentTimeMillis();

        Object methodResult = objectToWatch.getClass().getMethod(methodName, null).invoke(objectToWatch, null);

        double runningTime = System.currentTimeMillis() - startedAt;

        if(defaultToStringFunctionMethodResult != null && methodResultToStringFunction == null)
            methodResultToStringFunction = (Function<T, String>)defaultToStringFunctionMethodResult;

        diagnostics.add(new TimeWatcherDiagnostic<T>(methodName, runningTime, methodResult, methodResultToStringFunction));
    }

    public void Watch(String...methodNames) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (String methodName: methodNames) {
            Watch(methodName);
        }
    }

    public void ApplyDefaultToStringFunctionToMethodsResult(Function<Object, String> function) { defaultToStringFunctionMethodResult = function; }

    public ArrayList<TimeWatcherDiagnostic> GetDiagnostics(){
        return diagnostics;
    }

    public String GetDiagnosticsReport(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Class: %s \r\n", objectToWatch.getClass().getName()));
        for (TimeWatcherDiagnostic diagnostic: diagnostics) {
            sb.append("=====================================================\r\n");
            sb.append(String.format("Method: %s \r\n", diagnostic.getMethodName()));
            sb.append(String.format("Running time: %s milliseconds.\r\n", diagnostic.getRunningTime()));
            sb.append(String.format("Method result: %s \r\n", diagnostic.getMethodResult()));
        }

        return sb.toString();
    }
}

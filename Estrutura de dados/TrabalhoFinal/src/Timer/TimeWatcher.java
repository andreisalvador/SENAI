package Timer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class TimeWatcher<T> {
    private T objectToWatch;
    private ArrayList<TimeWatcherDiagnostic> diagnostics;
    private boolean hasDefaultToStringFunctionToMethodResult;
    private Function<Object, String> defaultToStringFunctionMethodResult;

    public TimeWatcher(T objectToWatch){
        this.objectToWatch = objectToWatch;
        this.hasDefaultToStringFunctionToMethodResult = false;
        this.diagnostics = new ArrayList<TimeWatcherDiagnostic>();
    }

    public void Watch(String methodName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Watch(methodName, null);
    }

    public <T> void Watch(String methodName, Function<T, String> methodResultToStringFunction) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = objectToWatch.getClass().getMethod(methodName, null);

        long startedAt = System.nanoTime();

        Object methodResult = method.invoke(objectToWatch, null);

        long endAt = System.nanoTime();

        if(hasDefaultToStringFunctionToMethodResult)
            methodResultToStringFunction = (Function<T, String>)defaultToStringFunctionMethodResult;

        diagnostics.add(new TimeWatcherDiagnostic<T>(methodName, (endAt - startedAt), methodResult, methodResultToStringFunction));
    }

    public void Watch(String...methodNames) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (String methodName: methodNames) {
            Watch(methodName);
        }
    }

    public void Watch(ArrayList<String> methodNames) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        for (String methodName: methodNames) {
            Watch(methodName);
        }
    }

    public void ApplyDefaultToStringFunctionToMethodsResult(Function<Object, String> function) {
        defaultToStringFunctionMethodResult = function;
        hasDefaultToStringFunctionToMethodResult = true;
    }

    public ArrayList<TimeWatcherDiagnostic> GetDiagnostics(){
        return diagnostics;
    }

    public String GetDiagnosticsReport(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Class: %s \r\n", objectToWatch.getClass().getName()));
        for (TimeWatcherDiagnostic diagnostic: diagnostics) {
            sb.append("=====================================================\r\n");
            sb.append(String.format("Method: %s \r\n", diagnostic.getMethodName()));
            sb.append(String.format("Running time: %s nanoseconds.\r\n", diagnostic.getRunningTime()));
            sb.append(String.format("Method result: %s \r\n", diagnostic.getMethodResult()));
        }

        return sb.toString();
    }
}

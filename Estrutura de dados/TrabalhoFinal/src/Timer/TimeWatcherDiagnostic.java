package Timer;

import java.util.function.Function;

public final class TimeWatcherDiagnostic<T> {
    private String methodName;
    private long runningTime;
    private Object methodResult;
    private Function<T, String> resultToString;

    public TimeWatcherDiagnostic(String methodName, long runningTime, Object methodResult, Function<T, String> methodResultToStringFunction){
        this.methodName = methodName;
        this.runningTime = runningTime;
        this.methodResult = methodResult;
        this.resultToString = methodResultToStringFunction;
    }
    public String getMethodName(){ return methodName; }

    public long getRunningTime(){
        return runningTime;
    }

    public Object getMethodResult(){
        if(resultToString != null)
            return resultToString.apply((T)methodResult);

        return methodResult;
    }
}

package Timer;

import java.util.function.Function;

public final class TimeWatcherDiagnostic<T> {
    private String methodName;
    private double runningTime;
    private Object methodResult;
    private Function<T, String> resultToString;

    public TimeWatcherDiagnostic(String methodName, double runningTime, Object methodResult, Function<T, String> methodResultToStringFunction){
        this.methodName = methodName;
        this.runningTime = runningTime;
        this.methodResult = methodResult;
        this.resultToString = methodResultToStringFunction;
    }
    public String getMethodName(){ return methodName; }

    public double getRunningTime(){
        return runningTime;
    }

    public Object getMethodResult(){
        if(resultToString != null)
            return resultToString.apply((T)methodResult);

        return methodResult;
    }
}

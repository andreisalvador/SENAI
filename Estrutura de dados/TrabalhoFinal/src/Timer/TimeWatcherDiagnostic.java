package Timer;

public final class TimeWatcherDiagnostic {
    private String methodName;
    private double runningTime;
    private Object methodResult;

    public TimeWatcherDiagnostic(String methodName, double runningTime, Object methodResult){
        this.methodName = methodName;
        this.runningTime = runningTime;
        this.methodResult = methodResult;
    }

    public String getMethodName(){ return methodName; }

    public double getRunningTime(){
        return runningTime;
    }

    public Object getMethodResult(){
        return methodResult;
    }
}

import Interfaces.IMyQueue;

public class MyQueue<T> implements IMyQueue<T> {
    private int recordsCount = 0;
    private int queueInit = 0;
    private final int queueLength;
    private T[] records;

    public MyQueue(int queueLength){
        this.queueLength = queueLength;
        this.records = (T[]) new Object[queueLength];
    }

    @Override
    public void Insert(T item) throws Exception {
        int queueEnd = GetQueueEnd();

        if(queueEnd > queueLength || (queueEnd == queueInit && queueEnd > 0))
            throw new Exception("Cannot insert item in queue because you reached the max length.");
        else {
            this.records[queueEnd] = item;
            recordsCount++;
        }
    }

    @Override
    public T Remove() {
        int queueInit = GetQueueInit();
        T result = this.records[queueInit];
        this.records[queueInit] = null;
        recordsCount--;
        return result;
    }


    @Override
    public boolean IsEmpty() {
        return this.records == null || this.records.length == 0;
    }

    @Override
    public void Free() {
        this.records = (T[])new Object[queueLength];
    }

    private int GetQueueEnd(){
        return  (queueInit + recordsCount) % queueLength;
    }

    private int GetQueueInit() {
        if(queueInit + 1 > (queueLength - 1))
            queueInit = 0;

        return queueInit++;
    }
}

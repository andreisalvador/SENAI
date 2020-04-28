import Interfaces.IMyQueue;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws Exception {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();

        PrintQueueEvents(queue, true, 10);

        PrintQueueEvents(queue, false, 10);

        PrintQueueEvents(queue, true, 20);

        PrintQueueEvents(queue, false, 10);

    }

    private static void PrintQueueEvents(IMyQueue<Integer> queue, boolean isQueuing, int elementQuantity) {
        Function<Integer, Integer> insertEvent = (Integer number) -> {
            try {
                queue.Insert(number);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return number;
        };

        for (int i = 0; i < elementQuantity; i++) {
            Integer value = isQueuing ? insertEvent.apply(i) : queue.Remove();
            System.out.printf("%s number %s \n", isQueuing ? "Queued" : "Dequeued", value);
        }

        System.out.printf("Is queue empty? -> %s \n", queue.IsEmpty());
        System.out.println("=================================================================================");
    }
}

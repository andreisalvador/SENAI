public class Main {

    public static void main(String[] args) throws Exception {
	 MyQueue<Integer> queue = new MyQueue<>(10);

        for (int i = 0; i < 10; i++) {
            queue.Insert(i);
        }

        Integer record = queue.Remove();
        Integer record2 = queue.Remove();
        for (int i = 10; i < 16; i++) {
            queue.Insert(i);
        }
    }
}

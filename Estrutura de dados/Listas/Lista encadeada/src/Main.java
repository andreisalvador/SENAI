import Classes.MyLinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.Add(5);
        list.Add(2);
        list.Add(5);
        list.Add(0, 4);
        Boolean x = list.RemoveFirst(5);


    }
}

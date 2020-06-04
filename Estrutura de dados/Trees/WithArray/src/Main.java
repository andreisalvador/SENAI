
public class Main {

    public static void main(String[] args) {
	Tree<Integer> myTree = new Tree<Integer>(2, 3);

        for (int i = 0; i < 10 ; i++) {
            myTree.Add(i);
        }

        System.out.println(myTree.toString());
    }
}

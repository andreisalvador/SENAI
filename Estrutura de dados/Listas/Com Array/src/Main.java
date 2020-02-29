public class Main {

    public static void main(String[] args) throws Exception {
	    ListArray<Integer> lista = new ListArray<Integer>(11);
        for (int i = 0; i < 11 ; i++) {
            lista.Add(i);
        }
        lista.Add(4);
        lista.Add(15);
        int x = lista.LastIndexOf(4);
    }
}

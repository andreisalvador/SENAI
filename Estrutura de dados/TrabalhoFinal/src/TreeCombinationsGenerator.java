import java.util.*;
import java.util.function.Function;

public class TreeCombinationsGenerator {
    private ArrayList<Integer> inputs;
    private int mainNodeRootValue, leftNodeValue, rightNodeValue;
    private Map<Integer, Function<Integer, Boolean>> rules;
    private ArrayList<String> combinations;
    private int combinationLength;
    private int[] chidrenRoot;

    public TreeCombinationsGenerator(int mainNodeRootValue, int leftNodeValue, int rightNodeValue, ArrayList<Integer> inputs) {
        this.inputs = inputs;
        this.mainNodeRootValue = mainNodeRootValue;
        this.leftNodeValue = leftNodeValue;
        this.rightNodeValue = rightNodeValue;
        this.inputs.removeAll(Arrays.asList(mainNodeRootValue, leftNodeValue, rightNodeValue));
        this.rules = new HashMap<>();
        this.combinations = new ArrayList<>();
        this.combinationLength = inputs.size() + 3; //root and children.
        this.chidrenRoot = new int[]{
                leftNodeValue, rightNodeValue
        };
    }

    public TreeCombinationsGenerator AddRules(int nodeValue, Function<Integer, Boolean>... newRules) {
        for (Function<Integer, Boolean> rule : newRules) {
            this.rules.put(nodeValue, rule);
        }
        return this;
    }

    public ArrayList<String> Generate() {
        StringBuilder sb = new StringBuilder(this.combinationLength);

        while (sb.length() != this.combinationLength) {

            for (int nodeValue : chidrenRoot)
                for (int input : inputs) {

                }
        }
        this.combinations.add(sb.toString());
        sb.setLength(0); //clear Sb
        sb.setLength(this.combinationLength);
        return this.combinations;
    }
}

import Interfaces.IMyStack;

import javax.swing.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        IMyStack<Integer> stack = new MyStack<>(10);

        PrintStackEvents(stack, true, 10);
        PrintStackEvents(stack, false, 10);
    }

    private static void PrintStackEvents(IMyStack<Integer> stack, boolean isInserting, int elementQuantity) {
        String action = isInserting ? "Pushing" : "Poping";

        Function<Integer, Integer> getValue = (Integer number) -> {
            stack.Push(number);
            return number;
        };

        for (int i = 0; i < elementQuantity; i++) {
            Integer value = isInserting ? getValue.apply(i) : stack.Pop();
            System.out.printf("%s the value %s \n", action, value);
        }

        System.out.printf("Is stack empty? -> %s \n", stack.IsEmpty());
        System.out.println("=================================================================================");
    }

}

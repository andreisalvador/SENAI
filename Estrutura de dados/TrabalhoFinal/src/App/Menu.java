package App;

import BinaryTree.SearchBinaryTree;

import java.io.BufferedReader;
import java.io.IOException;

public class Menu {
    public static void PrintMenu(){
        System.out.println("===============================");
        System.out.println("Que operação deseja realizar?");
        System.out.println("1 - Inserção");
        System.out.println("2 - Remoção");
        System.out.println("3 - Busca");
        System.out.println("A - Alterar operação");
        System.out.println("X - Sair");
        System.out.println("===============================");
    }

    public static void ValidateOption(BufferedReader buffer, String option) throws IOException {
        while(option.length() > 1){
            System.err.println("Opção inválida.");
            Menu.PrintMenu();
            option = buffer.readLine();
        }
    }

    public static void ExecuteOption(SearchBinaryTree tree, byte optionNumber, int value){
        switch (optionNumber){
            case 1:
                tree.Insert(value);
                break;
            case 2:
                tree.Remove(value);
        }
    }

    public static boolean IsValidValue(String value){
        char[] valueInArray = value.toCharArray();

        for (int i = 0; i < valueInArray.length; i++) {
            if(!Character.isDigit(valueInArray[i])) return false;
        }
        return true;
    }
}

import App.Application;
import App.Menu;
import BinaryTree.SearchBinaryTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        SearchBinaryTree tree = new SearchBinaryTree();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        Menu.PrintMenu();

        String option = buffer.readLine();

        Menu.ValidateOption(buffer, option);

        while(!option.equalsIgnoreCase("X")){

            System.out.println("Informe o valor: ");
            String value = buffer.readLine();

            if(Menu.IsValidValue(value)){
                Menu.ExecuteOption(tree, Byte.parseByte(option), Integer.parseInt(value));
            }else{
                option = buffer.readLine();
                Menu.ValidateOption(buffer, option);

                if(option.equalsIgnoreCase("A")){
                    Menu.PrintMenu();
                    option = buffer.readLine();
                    Menu.ValidateOption(buffer, option);
                }
            }
        }

        System.out.println(new Application(tree).GetResults());
    }
}

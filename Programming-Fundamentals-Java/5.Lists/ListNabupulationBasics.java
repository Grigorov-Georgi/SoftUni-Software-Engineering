import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListNabupulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> numbers = parseLineOfString(input);

        String command = scanner.nextLine();

        while (!command.equals("end")){
            String[] commandSplited = command.split(" ");
            switch (commandSplited[0]){
                case "Add":
                    numbers.add(Integer.parseInt(commandSplited[1]));
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(commandSplited[1]);
                    numbers.remove((Integer) numberToRemove);
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(commandSplited[1]);
                    numbers.remove(index);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(commandSplited[1]);
                    int index1 = Integer.parseInt(commandSplited[2]);
                    numbers.add(index1, (Integer) numberToInsert);
                    break;
            }

            command = scanner.nextLine();
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
    public static List<Integer> parseLineOfString(String input){
        String[] array = input.split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String s : array) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }

        return numbers;
    }
}

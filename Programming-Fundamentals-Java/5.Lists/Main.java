import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] array = line.split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String s : array) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }


    }
}

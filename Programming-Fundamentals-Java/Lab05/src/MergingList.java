import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = parseLineOfNumbers(scanner);
        List<Integer> secondList = parseLineOfNumbers(scanner);
        List<Integer> finalList = new ArrayList<>();
        int i = 0;
        while (i <= firstList.size() - 1 || i <= secondList.size() - 1){
            if (i <= firstList.size() - 1 ){
                finalList.add(firstList.get(i));
            }
            if (i <= secondList.size() - 1){
                finalList.add(secondList.get(i));
            }
            i++;
        }
        for (int n :finalList) {
            System.out.print(n + " ");
        }

    }
    public static List<Integer> parseLineOfNumbers (Scanner scanner){
        String line = scanner.nextLine();
        String[] array = line.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String s : array) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }

        return numbers;
    }


}



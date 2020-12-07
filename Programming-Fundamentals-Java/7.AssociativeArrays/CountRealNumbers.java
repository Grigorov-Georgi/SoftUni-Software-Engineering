import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbersOccurances = new TreeMap<>();
        String[] array = scanner.nextLine().split(" ");
        for (int i = 0; i < array.length ; i++) {
            double number = Double.parseDouble(array[i]);
            Integer currentNum = numbersOccurances.get(number);
            if (currentNum == null){
                currentNum = 0;
            }
            numbersOccurances.put(number, currentNum + 1);
        }


        for (Map.Entry<Double, Integer> entry : numbersOccurances.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }
}

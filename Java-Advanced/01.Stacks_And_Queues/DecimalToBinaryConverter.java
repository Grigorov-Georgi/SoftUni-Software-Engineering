import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> binaryCombination = new ArrayDeque<>();

        int number = Integer.parseInt(scanner.nextLine());
        if (number == 0){
            System.out.println(0);
            return;
        }
        while (number != 0){
            int currentDecimal = number % 2;
            if (currentDecimal == 1){
                binaryCombination.push(1);
            }else{
                binaryCombination.push(0);
            }
            number /= 2;
        }

        while(!binaryCombination.isEmpty()){
            System.out.print(binaryCombination.pop());
        }
    }
}

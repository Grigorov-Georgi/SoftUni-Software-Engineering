import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        String[] firstArr = firstLine.split(" ");
        String[] secondArr = secondLine.split(" ");
        int[] numbersOne = new int[firstArr.length];
        int[] numbersTwo = new int[secondArr.length];
        boolean notEqual = false;
        int sum = 0;
        for (int i = 0; i <firstArr.length ; i++) {
            numbersOne[i] = Integer.parseInt(firstArr[i]);
        }
        for (int i = 0; i <secondArr.length ; i++) {
            numbersTwo[i] = Integer.parseInt(secondArr[i]);
        }
        for (int i = 0; i < numbersOne.length ; i++) {
            if (numbersOne[i] == numbersTwo[i]){
                sum += numbersOne[i];
            }else{
                System.out.println("Arrays are not identical. Found difference at " + (i) + " index.");
                notEqual = true;
                break;
            }
        }
        if (!notEqual){
            System.out.println("Arrays are identical. Sum: " + sum);
        }
    }
}

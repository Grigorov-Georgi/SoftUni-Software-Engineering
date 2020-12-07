import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineOne = scanner.nextLine();
        String lineTwo = scanner.nextLine();
        String[] arr1 = lineOne.split(" ");
        String[] arr2 = lineTwo.split(" ");

        for (int i = 0; i <arr1.length ; i++) {
            for (int j = 0; j <arr2.length ; j++) {
                if (arr1[i].equals(arr2[j])){
                    System.out.print(arr1[i] + " ");
                }
            }
        }


    }
}

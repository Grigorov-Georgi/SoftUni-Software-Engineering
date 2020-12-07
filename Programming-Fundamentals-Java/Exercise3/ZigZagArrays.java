import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            String line = scanner.nextLine();
            String[] arr3 = line.split(" ");
            int[] arr4 = new int[arr3.length];
            for (int j = 0; j < arr3.length; j++) {
                arr4[j] = Integer.parseInt(arr3[j]);
            }
            if (i % 2 == 0) {
                arr1[i] = arr4[0];
                arr2[i] = arr4[1];
            }else{
                arr1[i] = arr4[1];
                arr2[i] = arr4[0];
            }
        }
        String word1 = "";
        String word2 = "";
        for (int i = 0; i <arr1.length ; i++) {
            word1 += arr1[i] + " ";
            word2 += arr2[i] + " ";
        }
        System.out.println(word1);
        System.out.println(word2);
    }
}

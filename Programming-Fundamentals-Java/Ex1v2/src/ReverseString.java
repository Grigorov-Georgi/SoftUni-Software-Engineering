import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        String reverseWord = "";
        for (int i = word.length() - 1 ; i >= 0 ; i--) {
            reverseWord+=word.charAt(i);
        }
        System.out.println(reverseWord);
    }
}

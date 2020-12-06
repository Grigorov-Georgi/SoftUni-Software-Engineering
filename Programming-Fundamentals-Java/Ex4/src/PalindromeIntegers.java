import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();


        while(!word.equals("END")){
            System.out.println(palindrome(word));
            word = scanner.nextLine();
        }
    }
    static boolean palindrome (String number){
        String[] array = number.split("");
        String[] reverseArray = new String[array.length];
        for (int i = 0; i <array.length ; i++) {
            reverseArray[i] = array[array.length - 1 - i];
        }

        for (int i = 0; i < array.length ; i++) {
            if (!reverseArray[i].equals(array[i])){
                return false;
            }
        }
        return true;
    }

}

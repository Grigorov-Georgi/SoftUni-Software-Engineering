import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        countVowels(scanner.nextLine());
    }
    public static void countVowels(String name){
        int counter = 0;
        name = name.toLowerCase();
        for (int i = 0; i <name.length() ; i++) {
            if (name.charAt(i) == 'a' || name.charAt(i) == 'o' || name.charAt(i) == 'u' || name.charAt(i) == 'e' || name.charAt(i) == 'i'){
                counter++;
            }
        }
        System.out.println(counter);
    }
}

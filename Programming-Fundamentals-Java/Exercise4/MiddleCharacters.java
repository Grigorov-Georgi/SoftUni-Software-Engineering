import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        middleCharactrs(scanner.nextLine());
    }
    static void middleCharactrs (String word){
        if (word.length() % 2 == 0){
            System.out.print(word.charAt((word.length() / 2) - 1));
            System.out.println(word.charAt((word.length() / 2)));
        }else{
            System.out.println(word.charAt((word.length() / 2)));
        }
    }
}

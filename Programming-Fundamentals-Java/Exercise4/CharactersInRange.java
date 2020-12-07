import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        charactersInbetween(scanner.nextLine().charAt(0), scanner.nextLine().charAt(0));
    }
    public static void charactersInbetween(char first, char second){
        if ((int)first < (int)second) {
            for (int i = first + 1; i < second; i++) {
                System.out.print((char) i + " ");
            }
        }else{
            for (int i = second + 1; i < first; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
}

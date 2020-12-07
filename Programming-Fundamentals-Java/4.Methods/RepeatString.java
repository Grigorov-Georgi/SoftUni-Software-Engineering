import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        repeatString(scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
    }
    static void repeatString(String line, int times){
        for (int i = 0; i < times ; i++) {
            System.out.print(line + "");
        }
    }
}

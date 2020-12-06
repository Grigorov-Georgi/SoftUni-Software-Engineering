import java.util.Scanner;

public class Replace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        char lastChar = ' ';
        for (int i = 0; i < input.length() ; i++) {
            if (input.charAt(i) != lastChar){
                sb.append(input.charAt(i));
            }
            lastChar = input.charAt(i);
        }
        System.out.println(sb.toString());
    }
}

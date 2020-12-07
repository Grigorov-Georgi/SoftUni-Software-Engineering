import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int min = Math.min(input[0].length(), input[1].length());
        int max = Math.max(input[0].length(), input[1].length());
        int result = 0;
        for (int i = 0; i < max ; i++) {
            if (i < min){
                result += input[0].charAt(i) * input[1].charAt(i);
            }else if (min == input[1].length()){
                result += input[0].charAt(i);
            }else{
                result += input[1].charAt(i);
            }
        }
        System.out.println(result);
    }
}

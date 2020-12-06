import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] formated = Arrays.stream(scanner.nextLine().split(" "))
                .filter(w -> w.length() % 2 == 0).toArray(String[]::new);
        for (int i = 0; i <formated.length ; i++) {
            System.out.println(formated[i]);
        }
    }
}

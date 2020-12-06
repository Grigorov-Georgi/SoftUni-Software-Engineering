import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorials {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger number = new BigInteger("1");
        int n = scanner.nextInt();
        for (int i = 2; i <= n ; i++) {
            number = number.multiply(BigInteger.valueOf(i));
        }
        System.out.println(number);
    }
}

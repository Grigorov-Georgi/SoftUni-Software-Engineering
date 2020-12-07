import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(new DecimalFormat("0.####").format(mathPower(Double.parseDouble(scanner.nextLine()), Integer.parseInt(scanner.nextLine()))));

    }
    static double mathPower (double number, int stepen){
        double result = 1;
        for (int i = 1; i <= stepen ; i++) {
            result *= number;
        }
        return result;
    }
}

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bigNumber = scanner.nextLine();
        int multiplyer = Integer.parseInt(scanner.nextLine());
        if (multiplyer == 0){
            System.out.println("0");
            return;
        }
        while (bigNumber.charAt(0) == '0'){
            bigNumber = bigNumber.substring(1);
        }
        int currentResult = 0;
        StringBuilder sb = new StringBuilder();
        int helpingNumber = 0;
        for (int i = 0; i < bigNumber.length() ; i++) {
            int newNumber = bigNumber.charAt(bigNumber.length() - 1 - i) - 48;
            currentResult = newNumber * multiplyer + helpingNumber;
            helpingNumber = 0;
            if (sb.length() == bigNumber.length() - 1){
                sb.insert(0, currentResult);
            }else if (currentResult >= 10) {
                helpingNumber = currentResult / 10;
                sb.insert(0, currentResult % 10);
            }else{
                sb.insert(0, currentResult);
            }

        }
        System.out.println(sb.toString());
    }
}

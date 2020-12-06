import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double cost = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());

        double sum = 0;
        double bonus = 0;
        for (int i = 1; i <= months  ; i++) {
            if (i != 1 && i % 2 != 0){
                sum *= 0.84;
            }

            if (i % 4 == 0){
                bonus = sum * 0.25;
            }
            sum += bonus;

            double savedMoney = cost * 0.25;

            sum += savedMoney;
        }

        if (sum >= cost){
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", Math.abs(sum - cost));
        }else{
            System.out.printf("Sorry. You need %.2flv. more.", Math.abs(sum - cost));
        }
    }
}

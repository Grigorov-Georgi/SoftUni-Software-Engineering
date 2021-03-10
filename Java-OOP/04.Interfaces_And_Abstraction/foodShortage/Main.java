package foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Buyer> buyerList = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Buyer buyer = null;

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String idOrGroup = tokens[2];
            if (tokens.length == 4){
                String birthdate = tokens[3];
                buyer = new Citizen(name, age, idOrGroup, birthdate);
            }else if (tokens.length == 3){
                buyer = new Rebel(name, age, idOrGroup);
            }
            buyerList.add(buyer);
        }

        String command = scanner.nextLine();
        while (!command.equals("End")){
            for (Buyer person : buyerList) {
                if (person.getName().equals(command)){
                    person.buyFood();
                }
            }
            command = scanner.nextLine();
        }

        int totalFood = 0;

        for (Buyer buyer : buyerList) {
            totalFood += buyer.getFood();
        }

        System.out.println(totalFood);
    }


}

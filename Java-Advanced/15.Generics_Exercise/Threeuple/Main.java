package Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s", tokens[0], tokens[1]);
        Threeuple<String, String, String> tulpe = new Threeuple<>(name, tokens[2], tokens[3]);
        System.out.println(tulpe);

        tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        int liters = Integer.parseInt(tokens[1]);
        String isDrunk = tokens[2];
        boolean isDrunkBoolean = true;
        if (isDrunk.equals("not")){
            isDrunkBoolean = false;
        }
        Threeuple<String, Integer, Boolean> tulpe1 = new Threeuple<>(name, liters, isDrunkBoolean);
        System.out.println(tulpe1);

        tokens = scanner.nextLine().split("\\s+");
        name = tokens[0];
        double secondNumber = Double.parseDouble(tokens[1]);
        String bankName = tokens[2];
        Threeuple<String, Double, String> tulpe2 = new Threeuple<>(name, secondNumber, bankName);
        System.out.println(tulpe2);

    }
}

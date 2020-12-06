import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kegs = Integer.parseInt(scanner.nextLine());
        String biggestKeg = "";
        double biggestVolume = 0;
        for (int i = 0; i < kegs ; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            if ((height * Math.pow(radius, 2) * Math.PI) >= biggestVolume){
                biggestVolume = height * Math.pow(radius, 2) * Math.PI;
                biggestKeg = model;
            }
        }
        System.out.println(biggestKeg);
    }
}

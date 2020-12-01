import java.util.Scanner;

public class Vacantion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = Integer.parseInt(scanner.nextLine());
        String type = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        switch (type){
            case "Students":
                switch (day){
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (day){
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                break;
            case "Regular":
                switch (day){
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.5;
                        break;
                }
                break;
        }
        double total = price * persons;
        if (type.equals("Students") && persons >= 30){
            total *= 0.85;
        }
        if (type.equals("Business") && persons >= 100){
            total = price * (persons - 10);
        }
        if (type.equals("Regular") && persons >= 10 && persons < 20){
            total *= 0.95;
        }
        System.out.printf("Total price: %.2f", total);
    }
}

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int empOne = Integer.parseInt(scanner.nextLine());
        int empTwo = Integer.parseInt(scanner.nextLine());
        int empThree = Integer.parseInt(scanner.nextLine());

        int clients = Integer.parseInt(scanner.nextLine());

        int clientsPerHour = empOne + empTwo + empThree;
        int hours = 0;
        while(clients > 0){
            hours++;
            if (hours % 4 == 0){
                hours++;
            }
            clients -= clientsPerHour;
        }

        System.out.println("Time needed: " + hours + "h.");
    }
}

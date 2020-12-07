import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        int counter = 0;
        while(!input.equals("End of battle")){
            int distance = Integer.parseInt(input);


            if (initialEnergy - distance >= 0){
                initialEnergy -= distance;
                counter++;
                if (counter % 3 == 0){
                    initialEnergy += counter;
                }
            }else {
                int energy = initialEnergy;
                System.out.println("Not enough energy! Game ends with " + counter + " won battles and " + energy + " energy");
                return;
            }


            input = scanner.nextLine();
        }
        System.out.println("Won battles: " + counter +". Energy left: " + initialEnergy);
    }
}

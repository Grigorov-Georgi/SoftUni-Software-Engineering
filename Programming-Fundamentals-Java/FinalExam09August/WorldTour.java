import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder allStops = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Travel")){
            String[] tokens = command.split(":");
            switch (tokens[0]){
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String givenString = tokens[2];
                    if (isValid(allStops, index)) {
                        allStops.insert(index, givenString);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (isValid(allStops, startIndex) && isValid(allStops, endIndex + 1)) {
                        allStops.replace(startIndex, endIndex + 1, "");
                    }
                    break;
                case "Switch":
                    String old = tokens[1];
                    String newS = tokens[2];
                    allStops = new StringBuilder(allStops.toString().replace(old, newS));
                    break;
            }
            System.out.println(allStops);
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + allStops);
    }

    static boolean isValid (StringBuilder s, int index){
        if (index >= 0 && s.length() >= index){
            return true;
        }
        return false;
    }
}

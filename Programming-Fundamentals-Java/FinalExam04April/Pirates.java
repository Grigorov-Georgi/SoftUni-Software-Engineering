import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {

    public static class Town {
        String name;
        int population;
        int gold;

        public Town(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getPopulation() {
            return population;
        }

        public int getGold() {
            return gold;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Town> townByName = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");
            Town town = new Town(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));

            if (townByName.containsKey(tokens[0])) {
                int newGold = townByName.get(tokens[0]).getGold() + Integer.parseInt(tokens[2]);
                townByName.get(tokens[0]).setGold(newGold);

                int newPopulation = townByName.get(tokens[0]).getPopulation() + Integer.parseInt(tokens[1]);
                townByName.get(tokens[0]).setPopulation(newPopulation);
            } else {
                townByName.put(tokens[0], town);
            }

            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        while (!secondInput.equals("End")) {
            String[] tokens = secondInput.split("=>");
            String command = tokens[0];
            String neededTown = tokens[1];
            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2]);
                    int gold = Integer.parseInt(tokens[3]);
                    int currentPeople = townByName.get(neededTown).getPopulation();
                    int currentGold = townByName.get(neededTown).getGold();
                    townByName.get(neededTown).setPopulation(currentPeople - people);
                    townByName.get(neededTown).setGold(currentGold - gold);
                    System.out.println(neededTown + " plundered! " + gold + " gold stolen, " + people + " citizens killed.");
                    if (townByName.get(neededTown).getGold() == 0 || townByName.get(neededTown).getPopulation() == 0) {
                        System.out.println(neededTown + " has been wiped off the map!");
                        townByName.remove(neededTown);
                    }
                    break;
                case "Prosper":
                    int prosperGold = Integer.parseInt(tokens[2]);
                    if (prosperGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int newTransaction = townByName.get(neededTown).getGold() + prosperGold;
                        townByName.get(neededTown).setGold(newTransaction);
                        System.out.println(prosperGold + " gold added to the city treasury. " + neededTown +
                                " now has " + townByName.get(neededTown).getGold() + " gold.");
                    }
                    break;
            }

            secondInput = scanner.nextLine();
        }
        System.out.println("Ahoy, Captain! There are " + townByName.size() + " wealthy settlements to go to:");
        if (townByName.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            townByName
                    .values()
                    .stream()
                    .sorted((a, b) -> {
                        int aGold = a.getGold();
                        int bGold = b.getGold();
                        if (aGold != bGold) {
                            return Integer.compare(bGold, aGold);
                        } else {
                            return a.getName().compareTo(b.getName());
                        }
                    })
                    .forEach(t -> System.out.println(t.getName() + " -> Population: " + t.getPopulation() + " citizens, Gold: " + t.getGold() + " kg"));
        }
    }
}

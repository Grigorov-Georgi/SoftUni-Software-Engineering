package definingClassesExercises.pokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        List<Trainer> trainerList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainersName = tokens[0];

            Trainer trainer = null;

            if (trainerMap.containsKey(trainersName)) {
                trainer = trainerMap.get(trainersName);
            } else {
                trainer = new Trainer(trainersName);
            }

            String pokemonsName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonsName, element, health);
            trainer.addPokemon(pokemon);

            trainerMap.put(trainersName, trainer);

            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();

        while (!secondInput.equals("End")) {

            for (Trainer trainer : trainerMap.values()) {
                trainer.checkElement(secondInput);
            }

            secondInput = scanner.nextLine();
        }

        trainerMap.entrySet()
                .stream()
                .sorted((b1, b2) -> {
                    int badges1 = b1.getValue().getNumberOfBadges();
                    int badges2 = b2.getValue().getNumberOfBadges();

                        return Integer.compare(badges2, badges1);


                })
                .forEach(t -> System.out.println(t.getValue().toString()));
    }
}

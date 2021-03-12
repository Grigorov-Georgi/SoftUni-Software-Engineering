package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Animal> animalList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String animalType = tokens[0];
            String animalName = tokens[1];
            double animalWeight = Double.parseDouble(tokens[2]);
            String animalLivingRegion = tokens[3];

            Animal animal = null;

            switch (animalType) {
                case "Cat":
                    String breed = tokens[4];
                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
                    break;
                case "Mouse":
                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                    break;
            }

            System.out.println(animal.makeSound());

            String[] foodTokens = scanner.nextLine().split("\\s+");
            Food food = null;
            int foodQuantity = Integer.parseInt(foodTokens[1]);
            if (foodTokens[0].equals("Vegetable")){
                food = new Vegetable(foodQuantity);
            }else{
                food = new Meat(foodQuantity);
            }
            try {
                animal.eat(food);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            animalList.add(animal);
            input = scanner.nextLine();
        }

        animalList.forEach(System.out::println);
    }
}

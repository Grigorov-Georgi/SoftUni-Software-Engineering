package Cooking;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //queue
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        //stack

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(ingredients::push);

        Map<Integer, String> cookingTable = new HashMap<>();
        cookingTable.put(25, "Bread");
        cookingTable.put(50, "Cake");
        cookingTable.put(75, "Pastry");
        cookingTable.put(100, "Fruit Pie");

        Map<String, Integer> productsCooked = new TreeMap<>();
        productsCooked.put("Bread", 0);
        productsCooked.put("Cake", 0);
        productsCooked.put("Pastry", 0);
        productsCooked.put("Fruit Pie", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();
            int sum = currentLiquid + currentIngredient;
            if (ableToCookDish(sum)) {
                String dish = cookingTable.get(sum);
                productsCooked.put(dish, productsCooked.get(dish) + 1);
            } else {
                ingredients.push(currentIngredient + 3);
            }
        }

        if (cookedEachMeal(productsCooked)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.println("Liquids left: " + getElementsInfo(liquids));


        System.out.println("Ingredients left: " + getElementsInfo(ingredients));


        productsCooked.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

    }

    private static String getElementsInfo(ArrayDeque<Integer> deque){
        return deque.isEmpty()
                ? "none"
                : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    private static boolean cookedEachMeal(Map<String, Integer> productsCooked) {
        int sum = 0;
        for (int e : productsCooked.values()) {
            if (e >= 1){
                sum++;
            }
        }
        return sum == 4;
    }

    private static boolean ableToCookDish(int sum) {
        return sum == 25 || sum == 50 || sum == 75 || sum == 100;
    }
}

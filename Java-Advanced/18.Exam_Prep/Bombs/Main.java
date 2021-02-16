package Bombs;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //queue
        ArrayDeque<Integer> bombEffect = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        //stack
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(bombCasing::push);

        Map<String, Integer> bombsMap = new LinkedHashMap<>();
        bombsMap.putIfAbsent("Datura", 0);
        bombsMap.putIfAbsent("Cherry", 0);
        bombsMap.putIfAbsent("Smoke Decoy", 0);

        while (!bombEffect.isEmpty() && !bombCasing.isEmpty() && !isThePouchFull(bombsMap)) {
            int currentBombEffect = bombEffect.poll();
            int currentBombCasing = bombCasing.pop();


            boolean flag = true;
            while (flag) {
                int sum = currentBombCasing + currentBombEffect;
                flag = true;
                switch (sum) {
                    case 40:
                        bombsMap.put("Datura", bombsMap.get("Datura") + 1);
                        flag = false;
                        break;
                    case 60:
                        bombsMap.put("Cherry", bombsMap.get("Cherry") + 1);
                        flag = false;
                        break;
                    case 120:
                        bombsMap.put("Smoke Decoy", bombsMap.get("Smoke Decoy") + 1);
                        flag = false;
                        break;
                    default:
                        currentBombCasing -= 5;
                        break;
                }
            }
        }

        if (isThePouchFull(bombsMap)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }


        System.out.print("Bomb Effects: ");
        System.out.println(info(bombEffect));

        System.out.print("Bomb Casings: ");
        System.out.println(info(bombCasing));

        System.out.println("Cherry Bombs: " + bombsMap.get("Cherry"));
        System.out.println("Datura Bombs: " + bombsMap.get("Datura"));
        System.out.println("Smoke Decoy Bombs: " + bombsMap.get("Smoke Decoy"));
    }

    private static boolean isThePouchFull(Map<String, Integer> bombsMap) {
        if (bombsMap.containsKey("Datura") && bombsMap.containsKey("Cherry") && bombsMap.containsKey("Smoke Decoy")){
            if (bombsMap.get("Datura") >= 3 && bombsMap.get("Cherry") >= 3 && bombsMap.get("Smoke Decoy") >= 3){
                return true;
            }
        }
        return false;
    }

    public static String info(ArrayDeque<Integer> deque) {
        return deque.isEmpty()
                ? "empty"
                : deque.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}

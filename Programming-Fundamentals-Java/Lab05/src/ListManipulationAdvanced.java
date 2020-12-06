import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] array = line.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String s : array) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] arrayCommands = input.split(" ");
            String command = arrayCommands[0];
            switch (command){
                case "Contains":
                    boolean doesItContains = false;
                    int neededNumber = Integer.parseInt(arrayCommands[1]);
                    for (int i = 0; i < numbers.size() ; i++) {
                        if (neededNumber == numbers.get(i)){
                            doesItContains = true;
                        }
                    }
                    if (doesItContains){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No such number");
                    }

                    break;
                case "Print":
                    if (arrayCommands[1].equals("even")){
                        for (int i = 0; i < numbers.size() ; i++) {
                            if (numbers.get(i) % 2 == 0){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }

                    }else{
                        for (int i = 0; i < numbers.size() ; i++) {
                            if (numbers.get(i) % 2 != 0){
                                System.out.print(numbers.get(i) + " ");
                            }
                        }

                    }
                    System.out.println();
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numbers.size() ; i++) {
                        sum += numbers.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String operation = arrayCommands[1];
                    int givenNumber = Integer.parseInt(arrayCommands[2]);
                    switch (operation){
                        case "<":
                            for (int i = 0; i < numbers.size() ; i++) {
                                if (numbers.get(i) < givenNumber){
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int i = 0; i < numbers.size() ; i++) {
                                if (numbers.get(i) <= givenNumber){
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (int i = 0; i < numbers.size() ; i++) {
                                if (numbers.get(i) > givenNumber){
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int i = 0; i < numbers.size() ; i++) {
                                if (numbers.get(i) >= givenNumber){
                                    System.out.print(numbers.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}

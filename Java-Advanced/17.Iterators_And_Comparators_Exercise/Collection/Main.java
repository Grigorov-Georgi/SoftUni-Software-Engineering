package Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);


        String line = scanner.nextLine();

        while (!"End".equals(line)) {
            switch (line) {
                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    }catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    try {
                        listyIterator.printAll();
                    }catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }


            line = scanner.nextLine();
        }

    }
}

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalCompounds = new TreeSet<>();


        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");

            for (int j = 0; j < tokens.length ; j++) {
                chemicalCompounds.add(tokens[j]);
            }

        }

        Iterator<String> itr = chemicalCompounds.iterator();

        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }

    }
}

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setsLength = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> nSet = new LinkedHashSet<>();
        Set<Integer> mSet = new LinkedHashSet<>();

        for (int i = 0; i < setsLength[0] ; i++) {
            nSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < setsLength[1] ; i++) {
            mSet.add(Integer.parseInt(scanner.nextLine()));
        }
        nSet.retainAll(mSet);

        Iterator<Integer> itr = nSet.iterator();

        while (itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
    }
}

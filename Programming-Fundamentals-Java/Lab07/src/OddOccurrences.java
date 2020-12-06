import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> wordTimes = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {
            String word = input[i].toLowerCase();
            Integer times = wordTimes.get(word);
            if (times == null){
                times = 0;
            }
            wordTimes.put(word, times + 1);
        }
        List<String> list1 = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordTimes.entrySet()) {
            if (entry.getValue() % 2 != 0){
                list1.add(entry.getKey().toLowerCase());
            }
        }
        System.out.println(String.join(", ", list1));
    }
}

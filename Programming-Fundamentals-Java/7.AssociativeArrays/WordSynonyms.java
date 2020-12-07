import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> wordWithSynonym = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n ; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            List<String> list = wordWithSynonym.get(word);
            if (list == null){
                list = new ArrayList<>();
                wordWithSynonym.put(word, list);
            }
            list.add(synonym);
        }
        for (Map.Entry<String, List<String>> entry : wordWithSynonym.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    private static String WORDS_INPUT_PATH = "src\\resources\\words.txt";
    private static String TEXT_INPUT_PATH = "src\\resources\\text.txt";
    private static String OUTPUT_PATH = "src\\resources\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader wordsReader = new BufferedReader(new FileReader(WORDS_INPUT_PATH));
             BufferedReader textReader = new BufferedReader(new FileReader(TEXT_INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)){

            String[] words = wordsReader.readLine().split(" ");
            Map<String, Integer> wordOccurrences = new HashMap<>();

            for (String word : words) {
                wordOccurrences.put(word, 0);
            }

            String[] text = textReader.readLine().split(" ");

            for (String s : text) {
                if (wordOccurrences.containsKey(s)){
                    wordOccurrences.put(s, wordOccurrences.get(s) + 1);
                }
            }

            wordOccurrences
                    .entrySet()
                    .stream()
                    .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                    .forEach(w -> writer.println(String.format("%s - %d", w.getKey(), w.getValue())));

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

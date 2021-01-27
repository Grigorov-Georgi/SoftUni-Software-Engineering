import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class CountCharacterType {
    private static final String PATH = "src\\resources\\input.txt";
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))){
            Set<Character> vowels = Set.of('a', 'e', 'o', 'u', 'i');
            Set<Character> punctuationMarks = Set.of('!', '.', ',', '?');

            int vowelsCounter = 0;
            int consonantCounter = 0;
            int punctuationMarksCounter = 0;

            String line = reader.readLine();
            while (line != null){
                for (int i = 0; i < line.length() ; i++) {
                    char symbol = line.charAt(i);

                    if (vowels.contains(symbol)){
                        vowelsCounter++;
                    }else if (punctuationMarks.contains(symbol)){
                        punctuationMarksCounter++;
                    }else if (symbol != ' '){
                        consonantCounter++;
                    }
                }
                line = reader.readLine();
            }
            System.out.printf("Vowels: %d%n" , vowelsCounter);
            System.out.printf("Consonants: %d%n" , consonantCounter);
            System.out.printf("Punctuation: %d%n" , punctuationMarksCounter);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

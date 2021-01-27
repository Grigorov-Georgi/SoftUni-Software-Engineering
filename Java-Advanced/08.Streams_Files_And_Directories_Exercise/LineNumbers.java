import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LineNumbers {
    private static String INPUT_PATH = "src\\resources\\inputLineNumbers.txt";
    private static String OUTPUT_PATH = "src\\resources\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             FileWriter writer = new FileWriter(OUTPUT_PATH)){
            int lineNumber = 1;

            String line = reader.readLine();
            while (line != null) {
                writer.write(String.format("%d. %s%n", lineNumber, line));
                lineNumber++;
                line = reader.readLine();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

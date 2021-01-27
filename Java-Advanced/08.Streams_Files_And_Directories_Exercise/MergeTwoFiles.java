import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles {

    private static String ONE_INPUT_PATH = "src\\resources\\inputOne.txt";
    private static String TWO_INPUT_PATH = "src\\resources\\inputTwo.txt";
    private static String OUTPUT_PATH = "src\\resources\\output.txt";

    public static void main(String[] args) {
        try (BufferedReader oneReader = new BufferedReader(new FileReader(ONE_INPUT_PATH));
        BufferedReader twoReader = new BufferedReader(new FileReader(TWO_INPUT_PATH));
        PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            String line = oneReader.readLine();
            while (line != null){
                writer.println(line);
                line = oneReader.readLine();
            }
            line = twoReader.readLine();
            while (line != null){
                writer.println(line);
                line = twoReader.readLine();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

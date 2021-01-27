import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SumLines {

    private static final String PATH = "C:\\Users\\Georgi\\OneDrive - Technical University of Sofia, FDIBA\\Desktop\\Java2\\Java-Advanced\\08.Streams_Files_And_Directories_Exercise\\src\\resources\\input.txt";
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))){
            String line = reader.readLine();

            while (line != null){
                int sum = 0;

                for (int i = 0; i < line.length() ; i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

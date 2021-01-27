import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumBytes {

    private static final String PATH =  "C:\\Users\\Georgi\\OneDrive - Technical University of Sofia, FDIBA\\Desktop\\Java2\\Java-Advanced\\08.Streams_Files_And_Directories_Exercise\\src\\resources\\input.txt";
    public static void main(String[] args) {
         try (BufferedReader reader = new BufferedReader(new FileReader(PATH))){
             String line = reader.readLine();
             int sum = 0;
             while (line != null){
                 for (int i = 0; i < line.length() ; i++) {
                     sum += line.charAt(i);
                 }
                 line = reader.readLine();
             }
             System.out.println(sum);
         }catch (IOException ioe){
             ioe.printStackTrace();
         }
    }
}

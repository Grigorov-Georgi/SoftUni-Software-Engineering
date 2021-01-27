import java.io.*;

public class GetFolderSize {
    private static String DIR_PATH = "C:\\Users\\Georgi\\OneDrive - Technical University of Sofia, FDIBA\\Desktop\\Java2\\Java-Advanced\\08.Streams_Files_And_Directories_Exercise\\src\\resources\\Exercises Resources";
    private static String OUTPUT_PATH = "src\\resources\\output.txt";

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)){

            File folder = new File(DIR_PATH);

            File[] files = folder.listFiles();

            int size = 0;

            for (File file : files) {
                size += file.length();
            }
            writer.println(String.format("Folder size: %d", size));

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

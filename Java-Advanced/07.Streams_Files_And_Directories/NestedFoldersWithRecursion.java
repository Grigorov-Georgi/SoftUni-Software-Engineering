import java.io.File;
import java.io.IOException;

public class NestedFoldersWithRecursion {

    public static int foldersCount = 0;

    public static void main(String[] args) throws IOException {


        String path = "C:\\Users\\Georgi\\OneDrive - Technical University of Sofia, FDIBA\\Desktop" +
                "\\Java2\\Java-Advanced\\07.Streams_Files_And_Directories" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);

        dfs(file);
        System.out.println(foldersCount + " folders");
    }

    public static void dfs(File file){

        foldersCount++;
        for (File f : file.listFiles()) {
            if (f.isDirectory()){
                dfs(f);
            }
        }
        System.out.println(file.getName());
    }
}
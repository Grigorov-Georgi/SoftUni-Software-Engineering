import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    private static final String PICTURE_PATH = "C:\\Users\\Georgi\\OneDrive - Technical University of Sofia, FDIBA\\Desktop\\Java2\\Java-Advanced\\08.Streams_Files_And_Directories_Exercise\\src\\resources\\Exercises Resources\\download.png";
    private static final String PICTURE_COPY_PATH = "C:\\Users\\Georgi\\OneDrive - Technical University of Sofia, FDIBA\\Desktop\\Java2\\Java-Advanced\\08.Streams_Files_And_Directories_Exercise\\src\\resources\\Exercises Resources\\download_copy.png";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(PICTURE_PATH);
        FileOutputStream fos = new FileOutputStream(PICTURE_COPY_PATH)){
            int singleByte = fis.read();
            while (singleByte != -1){
                fos.write(singleByte);
                singleByte = fis.read();
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}

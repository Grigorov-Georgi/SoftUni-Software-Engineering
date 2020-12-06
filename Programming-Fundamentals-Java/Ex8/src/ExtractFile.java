import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String adress = scanner.nextLine();

        int indexOfDot = adress.indexOf(".");
        String fileExtension = adress.substring(indexOfDot + 1);
        int indexOfLastSlash = adress.lastIndexOf("\\");
        String fileName = adress.substring(indexOfLastSlash + 1, indexOfDot);
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);

    }
}

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        String expression = "@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+";
        String exp = "\\d+";
        Pattern barcode = Pattern.compile(expression);

        Pattern code = Pattern.compile(exp);

        for (int i = 0; i < n ; i++) {
            String text = scanner.nextLine();
            Matcher matcherBarcode = barcode.matcher(text);
            if (matcherBarcode.find()){
                Matcher matcherCode = code.matcher(matcherBarcode.group());
                String fullNumber = "";
                while (matcherCode.find()){
                    fullNumber += matcherCode.group();
                }
                if (!fullNumber.equals("")){
                    System.out.println("Product group: " + fullNumber);
                }else{
                    System.out.println("Product group: 00");
                }
            }else {
                System.out.println("Invalid barcode");
            }
        }
    }
}

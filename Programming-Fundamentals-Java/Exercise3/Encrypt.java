import java.util.Scanner;

public class Encrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String name[] = new String[n];
        int[] points = new int[n];
        for (int i = 0; i < name.length; i++) {
            name[i] = scanner.nextLine();
            for (int j = 0; j < name[i].length(); j++) {
                String nam = name[i].toLowerCase();
                if ((nam.charAt(j)) == 'a' || (nam.charAt(j)) == 'e' || (nam.charAt(j)) == 'o' || (nam.charAt(j)) == 'u' || (nam.charAt(j)) == 'i'){
                    points[i] += (nam.charAt(j)) * name[i].length();
                }else {
                    points[i] += (nam.charAt(j)) / name[i].length();
                }
            }

        }
        for (int i = 0; i < n ; i++) {
            System.out.println(name[i] + " = " + points[i]);
        }
    }
}

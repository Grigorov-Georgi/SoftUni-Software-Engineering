import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nubmerOne = Integer.parseInt(scanner.nextLine());
        int nubmerTwo = Integer.parseInt(scanner.nextLine());
        int nubmerThree = Integer.parseInt(scanner.nextLine());

        if (nubmerOne > nubmerTwo && nubmerOne > nubmerThree){
            System.out.println(nubmerOne);
            if (nubmerTwo > nubmerThree){
                System.out.println(nubmerTwo);
                System.out.println(nubmerThree);
            }else{
                System.out.println(nubmerThree);
                System.out.println(nubmerTwo);
            }
        }else if (nubmerTwo > nubmerOne && nubmerTwo > nubmerThree){
            System.out.println(nubmerTwo);
            if (nubmerOne > nubmerThree){
                System.out.println(nubmerOne);
                System.out.println(nubmerThree);
            }else{
                System.out.println(nubmerThree);
                System.out.println(nubmerOne);
            }
        }else{
            System.out.println(nubmerThree);
            if (nubmerOne > nubmerTwo){
                System.out.println(nubmerOne);
                System.out.println(nubmerTwo);
            }else{
                System.out.println(nubmerTwo);
                System.out.println(nubmerOne);
            }
        }
    }
}

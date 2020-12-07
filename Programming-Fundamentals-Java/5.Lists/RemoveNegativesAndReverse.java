import java.util.*;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] array = line.split(" ");

        List<Integer> numbers = new ArrayList<>();
        for (String s : array) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }

        for (int i = 0; i < numbers.size(); ) {
            if (numbers.get(i) < 0){
                numbers.remove(i);
            }else{
                i++;
            }

        }
        Collections.reverse(numbers);
        for (int n :numbers) {
            System.out.print(n + " ");
        }
        if (numbers.isEmpty()){
            System.out.println("empty");
        }
    }
}

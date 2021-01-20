import javax.swing.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = scanner.nextLine();
        while (!"PARTY".equals(input)) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();
        while (!"END".equals(secondInput)) {
            if (Character.isDigit(secondInput.charAt(0))) {
                vip.remove(secondInput);
            } else {
                regular.remove(secondInput);
            }
            secondInput = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());

        if (!vip.isEmpty()) {
          //  System.out.println(vip.stream().collect(Collectors.joining(System.lineSeparator())));
            vip.forEach(System.out::println);
        }

        if (!regular.isEmpty()) {
         //   System.out.println(regular.stream().collect(Collectors.joining(System.lineSeparator())));
            regular.forEach(System.out::println);
        }

    }
}

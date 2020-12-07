import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> race = new LinkedHashMap<>();

        String letterReg = "[A-Za-z]";
        String digitReg = "\\d";
        Pattern letterPattern = Pattern.compile(letterReg);
        Pattern digitPattern = Pattern.compile(digitReg);

        String input = scanner.nextLine();

        while (!input.equals("end of race")){
            StringBuilder sb = new StringBuilder();
            Matcher letterMatcher = letterPattern.matcher(input);
            while (letterMatcher.find()){
                sb.append(letterMatcher.group());
            }

            if (names.contains(sb.toString())){
                race.putIfAbsent(sb.toString(), 0);
                int km = race.get(sb.toString());

                Matcher digitMatcher = digitPattern.matcher(input);
                while (digitMatcher.find()){
                    km += Integer.parseInt(digitMatcher.group());
                }
                race.put(sb.toString(), km);

            }


            input = scanner.nextLine();
        }
        List<String> list = new ArrayList<>();
        list.add("1st place: ");
        list.add("2nd place: ");
        list.add("3rd place: ");
        race
                .entrySet()
                .stream()
                .sorted((r1, r2) -> r2.getValue().compareTo(r1.getValue()))
                .limit(3)
                .forEach(r -> System.out.println(list.remove(0) + r.getKey()));
    }
}

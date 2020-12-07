import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, int[]> heroMap = new LinkedHashMap<>();

        for (int i = 0; i < n ; i++) {
            String[] line = scanner.nextLine().split(" ");
            String name = line[0];
            int hp = Integer.parseInt(line[1]);
            int mana = Integer.parseInt(line[2]);
            int[] points = new int[]{hp, mana};
            heroMap.put(name, points);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command){
                case "CastSpell":
                    int neededMana = Integer.parseInt(tokens[2]);
                    String castName = tokens[3];

                    if (heroMap.get(heroName)[1] - neededMana >= 0){
                        heroMap.get(heroName)[1] -= neededMana;
                        System.out.println(heroName + " has successfully cast " + castName + " and now has " + heroMap.get(heroName)[1] + " MP!");
                    }else{
                        System.out.println(heroName + " does not have enough MP to cast " + castName + "!");
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    heroMap.get(heroName)[0] -= damage;
                    if (heroMap.get(heroName)[0] <= 0){
                        System.out.println(heroName + " has been killed by " + attacker + "!");
                        heroMap.remove(heroName);
                    }else{
                        System.out.println(heroName + " was hit for " + damage  + " HP by " + attacker + " and now has " + heroMap.get(heroName)[0] + " HP left!");
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    int recharge = 0;
                    if (amount + heroMap.get(heroName)[1] > 200){
                        recharge = 200 - heroMap.get(heroName)[1];
                    }else {
                        recharge = amount;
                    }
                    heroMap.get(heroName)[1] += recharge;
                    System.out.println(heroName + " recharged for " + recharge + " MP!");
                    break;
                case "Heal":
                    int hpAmount = Integer.parseInt(tokens[2]);
                    int hpRecharge = 0;
                    if (hpAmount + heroMap.get(heroName)[0] > 100){
                        hpRecharge = 100 - heroMap.get(heroName)[0];
                    }else {
                        hpRecharge = hpAmount;
                    }
                    heroMap.get(heroName)[0] += hpRecharge;
                    System.out.println(heroName + " healed for " + hpRecharge +" HP!");
                    break;
            }
            input = scanner.nextLine();
        }
        heroMap.entrySet()
                .stream()
                .sorted((a, b) ->{
                    int aHP = a.getValue()[0];
                    int bHP = b.getValue()[0];
                    if (aHP != bHP){
                        return Integer.compare(bHP, aHP);
                    }else{
                        return a.getKey().compareTo(b.getKey());
                    }
                }).forEach(h -> System.out.println(String.format("%s%n  HP: %d%n  MP: %d", h.getKey(), h.getValue()[0], h.getValue()[1])));
    }
}

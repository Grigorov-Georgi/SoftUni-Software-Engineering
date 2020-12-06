import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static class Hero {
        String name;
        int hp;
        int mana;

        public Hero(String name, int hp, int mana) {
            this.name = name;
            if (hp > 100) {
                this.hp = 100;
            } else {
                this.hp = hp;
            }
            if (mana > 200) {
                this.mana = 200;
            } else {
                this.mana = mana;
            }
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public void setMana(int mana) {
            this.mana = mana;
        }

        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public int getMana() {
            return mana;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Hero> heroMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int hp = Integer.parseInt(input[1]);
            int mana = Integer.parseInt(input[2]);

            Hero hero = new Hero(name, hp, mana);
            heroMap.put(name, hero);
        }

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "CastSpell":
                    int neededMana = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if (heroMap.get(heroName).getMana() >= neededMana) {
                        heroMap.get(heroName).setMana(heroMap.get(heroName).getMana() - neededMana);
                        System.out.println(heroName + " has successfully cast " + spellName +
                                " and now has " + heroMap.get(heroName).getMana() + " MP!");
                    } else {
                        System.out.println(heroName + " does not have enough MP to cast "
                                + spellName + "!");
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    heroMap.get(heroName).setHp(heroMap.get(heroName).getHp() - damage);
                    if (heroMap.get(heroName).getHp() <= 0) {
                        System.out.println(heroName + " has been killed by " + attacker + "!");
                        heroMap.remove(heroName);
                    } else {
                        System.out.println(heroName + " was hit for " + damage +
                                " HP by " + attacker + " and now has "
                                + heroMap.get(heroName).getHp() + " HP left!");
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    int currentMana = heroMap.get(heroName).getMana();
                    int usedMana = 0;
                    if (currentMana + amount > 200) {
                        usedMana = 200 - currentMana;
                        heroMap.get(heroName).setMana(200);
                    } else {
                        usedMana = amount;
                        heroMap.get(heroName).setMana(currentMana + amount);
                    }
                    System.out.println(heroName + " recharged for " + usedMana + " MP!");
                    break;
                case "Heal":
                    int amountHp = Integer.parseInt(tokens[2]);
                    int currentHp = heroMap.get(heroName).getHp();
                    int usedHP = 0;
                    if (currentHp + amountHp > 100) {
                        usedHP = 100 - currentHp;
                        heroMap.get(heroName).setHp(100);
                    } else {
                        usedHP = amountHp;
                        heroMap.get(heroName).setHp(currentHp + amountHp);
                    }
                    System.out.println(heroName + " healed for " + usedHP + " HP!");
                    break;
            }

            line = scanner.nextLine();
        }
        heroMap.values()
                .stream()
                .sorted((a, b) -> {
                    int aHP = a.getHp();
                    int bHP = b.getHp();
                    if (aHP != bHP) {
                        return Integer.compare(bHP, aHP);
                    } else {
                        return a.getName().compareTo(b.getName());
                    }
                }).forEach(h -> System.out.println(String.format("%s%n  HP: %d%n  MP: %d", h.getName(), h.getHp(), h.getMana())));
    }
}

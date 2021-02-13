package StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int resultat = p1.getName().length() - p2.getName().length();
        if (resultat == 0){
            char p1FirstLetter = p1.getName().toLowerCase().charAt(0);
            char p2FirstLetter = p2.getName().toLowerCase().charAt(0);
            resultat = p1FirstLetter - p2FirstLetter;
        }
        return resultat;
    }
}

package definingClassesExercises.pokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemonList;


    public Trainer(String name){
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon){
        pokemonList.add(pokemon);
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public String getName() {
        return name;
    }

    public void checkElement(String givenElement){
        boolean haveOne = false;

        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(givenElement)){
                haveOne = true;
                break;
            }
        }

        if (haveOne){
            this.numberOfBadges += 1;
        }else {
            for (Pokemon pokemon : pokemonList) {
                pokemon.setHealth(pokemon.getHealth() - 10);
            }

            pokemonList.removeIf(pokemon -> pokemon.getHealth() <= 0);
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemonList.size());
    }
}

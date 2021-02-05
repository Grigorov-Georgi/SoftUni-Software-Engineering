package definingClassesExercises.google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private Car car;

    public Person(String name, Company company, Car car) {
        this.name = name;
        this.company = company;
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.car = car;
    }

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.car = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addParent(Parents parents) {
        this.parentsList.add(parents);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addChild(Children children) {
        this.childrenList.add(children);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (company != null) {
            sb.append(company.toString()).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (car != null) {
            sb.append(car.toString()).append(System.lineSeparator());
        }

        sb.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemonList) {
            sb.append(pokemon.toString()).append(System.lineSeparator());
        }


        sb.append("Parents:").append(System.lineSeparator());
        for (Parents parents : parentsList) {
            sb.append(parents.toString()).append(System.lineSeparator());
        }


        sb.append("Children:").append(System.lineSeparator());
        for (Children children : childrenList) {
            sb.append(children.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}

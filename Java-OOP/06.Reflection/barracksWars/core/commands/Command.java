package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] date;
    private Repository repository;
    private UnitFactory unitFactory;

    public Command(String[] date, Repository repository, UnitFactory unitFactory) {
        this.date = date;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getDate() {
        return date;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}

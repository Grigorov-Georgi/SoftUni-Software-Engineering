package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Retire extends Command{
    public Retire(String[] date, Repository repository, UnitFactory unitFactory) {
        super(date, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getDate()[1];
        getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}

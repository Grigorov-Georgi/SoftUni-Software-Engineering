package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Report extends Command {
    public Report(String[] date, Repository repository, UnitFactory unitFactory) {
        super(date, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = getRepository().getStatistics();
        return output;
    }
}

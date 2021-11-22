package exercise07_reflectionAndAnnotations.barracksWars.core.commands;

import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Repository;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException {
        this.getRepository().removeUnit(getData()[1]);
        return getData()[1] +" retired!";
    }
}

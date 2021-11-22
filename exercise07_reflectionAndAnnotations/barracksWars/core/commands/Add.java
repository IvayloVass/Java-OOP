package exercise07_reflectionAndAnnotations.barracksWars.core.commands;

import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Repository;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Unit;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.UnitFactory;

public class Add extends Command {
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }

}

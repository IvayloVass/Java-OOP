package exercise07_reflectionAndAnnotations.barracksWars.core.commands;

import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Executable;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Repository;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected Repository getRepository() {
        return repository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}

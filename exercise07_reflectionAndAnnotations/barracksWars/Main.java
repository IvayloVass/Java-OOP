package exercise07_reflectionAndAnnotations.barracksWars;

import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Repository;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Runnable;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.UnitFactory;
import exercise07_reflectionAndAnnotations.barracksWars.core.Engine;
import exercise07_reflectionAndAnnotations.barracksWars.core.factories.UnitFactoryImpl;
import exercise07_reflectionAndAnnotations.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}

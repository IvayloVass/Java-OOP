package exercise07_reflectionAndAnnotations.barracksWars.core.factories;

import exercise07_reflectionAndAnnotations.barracksWars.interfaces.Unit;
import exercise07_reflectionAndAnnotations.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "exercise07_reflectionAndAnnotations.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType)  {
        try {
            Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<Unit> ctr = unitClass.getConstructor();
            return ctr.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.getCause();
        }

//        switch (unitType) {
//            case "Archer":
//                return new Archer();
//            case "Pikeman":
//                return new Pikeman();
//            case "Swordsman":
//                return new Swordsman();
//            case "Horseman":
//                return new Horseman();
//            case "Gunner":
//                return new Gunner();
//        }
        return null;
    }
}

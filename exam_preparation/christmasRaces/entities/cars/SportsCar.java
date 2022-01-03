package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.*;

public class SportsCar extends BaseCar {

    private static double CUBIC_CENTIMETRES = 3000;

    public SportsCar(String model, int horsepower) {
        super(model, horsepower, CUBIC_CENTIMETRES);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < 250 || horsePower > 450) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);
    }
}

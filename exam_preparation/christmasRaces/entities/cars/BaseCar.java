package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.*;

public abstract class BaseCar implements Car {

    private String model;
    private int horsePower;
    private double cubicCentimetres;

    public BaseCar(String model, int horsepower, double cubicCentimetres) {
        setModel(model);
        setHorsePower(horsepower);
        this.cubicCentimetres = cubicCentimetres;

    }

    private void setModel(String model) {
        if (model == null || model.trim().isEmpty() || model.length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        this.model = model;
    }

    protected void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return this.cubicCentimetres;
    }

    @Override
    public double calculateRacePoints(int laps) {
        return this.cubicCentimetres / this.horsePower * laps;
    }
}

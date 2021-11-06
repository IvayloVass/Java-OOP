package exercise03_inheritance.needForSpeed;

public class RaceMotorcycle extends Motorcycle {

    static double DEFAULT_FUEL_CONSUMPTION = 8.0;

    public RaceMotorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }

}

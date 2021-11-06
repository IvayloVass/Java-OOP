package exercise03_inheritance.needForSpeed;

public class SportCar extends Car{

    static double DEFAULT_FUEL_CONSUMPTION = 10.0;

    public SportCar(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}

package exercise03_inheritance.needForSpeed;

public class Car extends Vehicle {

    static double DEFAULT_FUEL_CONSUMPTION = 3.0;

    public Car(double fuel, int horsePower) {
        super(fuel, horsePower);
        this.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}

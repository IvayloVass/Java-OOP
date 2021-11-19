package exercise05_polymorphism.vehicles;

public class Car extends Vehicles {

    private static final double INCREASE_SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASE_SUMMER_CONSUMPTION);
    }


}

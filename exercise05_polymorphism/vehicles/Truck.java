package exercise05_polymorphism.vehicles;

public class Truck extends Vehicles {

    private static final double INCREASE_SUMMER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + INCREASE_SUMMER_CONSUMPTION);
    }

    @Override
    protected void refueling(double litres) {
        this.fuelQuantity += 0.95 * litres;
    }

}

package exercise05_polymorphism.vehicles;

import java.text.DecimalFormat;

public class Vehicles {
    protected double fuelQuantity;
    protected double fuelConsumption;

    public Vehicles(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void driving(double kilometresToDrive) {
        double possibleKilometresToDrive = this.fuelQuantity / this.fuelConsumption;
        DecimalFormat formatter = new DecimalFormat("##.##");
        if (possibleKilometresToDrive >= kilometresToDrive) {
            System.out.printf("%s travelled %s km\n", this.getClass().getSimpleName(), formatter.format(kilometresToDrive));
            this.fuelQuantity -= kilometresToDrive * this.fuelConsumption;
        } else {
            System.out.printf("%s needs refueling\n", this.getClass().getSimpleName());
        }
    }

    protected void refueling(double litres) {
        this.fuelQuantity += litres;
    }


    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}

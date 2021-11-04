package lab01_abstraction.P04_HotelReservation;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    Season season;
    DiscountType discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, DiscountType discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discount = discount;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }
}

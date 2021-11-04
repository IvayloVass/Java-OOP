package lab01_abstraction.P04_HotelReservation;

import java.util.Scanner;

import static lab01_abstraction.P04_HotelReservation.DiscountType.formatDiscountInput;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int numberOfDays = Integer.parseInt(input[1]);
        String entrySeason = input[2].toUpperCase();
        DiscountType discount = formatDiscountInput(input[3]);

        Season season = Season.valueOf(entrySeason);
        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays, season, discount);
        int days = calculator.getNumberOfDays();
        double price = calculator.getPricePerDay();
        double totalPrice = (days * price * season.getPriceMultiplier()) * ((100 - discount.getDiscountInPercent())) / 100;
        System.out.printf("%.2f", totalPrice);

    }
}

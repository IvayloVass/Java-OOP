package lab01_abstraction.P04_HotelReservation;

public enum DiscountType {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    private final int discountInPercent;

    DiscountType(int discountInPercent) {
        this.discountInPercent = discountInPercent;
    }

    public int getDiscountInPercent() {
        return discountInPercent;
    }

    public static DiscountType formatDiscountInput(String discount) {
        switch (discount) {
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            case "VIP":
                return VIP;

        }
        throw new IllegalArgumentException("Unknown discountType " + discount);
    }

}

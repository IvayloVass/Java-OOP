package exercise01_abstraction.p03_cardsWithPower;

public enum RankPowers {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int rank;

    RankPowers(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}

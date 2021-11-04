package exercise01_abstraction.p03_cardsWithPower;

public class Cards {
    private RankPowers rankPowers;
    private SuitPowers suitPowers;

    public int calculatePower(RankPowers rankPowers, SuitPowers suitPowers) {
        return rankPowers.getRank() + suitPowers.getSuit();

    }


}

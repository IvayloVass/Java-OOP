package exercise01_abstraction.p03_cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cardName = sc.nextLine();
        String suitName = sc.nextLine();
        RankPowers rankPowers = RankPowers.valueOf(cardName);
        SuitPowers suitPowers = SuitPowers.valueOf(suitName);
        Cards cards = new Cards();
        int power = cards.calculatePower(rankPowers, suitPowers);
        System.out.printf("Card name: %s of %s; Card power: %d", cardName, suitName, power);
    }
}

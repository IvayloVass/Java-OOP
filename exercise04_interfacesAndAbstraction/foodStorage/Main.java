package exercise04_interfacesAndAbstraction.foodStorage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(sc.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        while (numberOfPeople-- > 0) {

            String[] tokens = sc.nextLine().split("\\s+");
            if (tokens.length == 4) {
                String citizenName = tokens[0];
                int citizenAge = Integer.parseInt(tokens[1]);
                String citizenId = tokens[2];
                String birthDate = tokens[3];
                Buyer buyer = new Citizen(citizenName, citizenAge, citizenId, birthDate);
                buyers.put(citizenName, buyer);

            } else if (tokens.length == 3) {
                String rebelName = tokens[0];
                int rebelAge = Integer.parseInt(tokens[1]);
                String group = tokens[2];
                Buyer buyer = new Rebel(rebelName, rebelAge, group);
                buyers.put(rebelName, buyer);
            }

        }
        String name = sc.nextLine();

        while (!name.equals("End")) {

            if (buyers.containsKey(name)) {
                Buyer buyer = buyers.get(name);
                buyer.buyFood();
            }
            name = sc.nextLine();
        }
        int food = 0;
        for (Buyer buyer : buyers.values()) {
            food += buyer.getFood();

        }
        System.out.println(food);

    }
}

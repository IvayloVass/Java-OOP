package lab02_encapsulation.p04_teams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Team team = new Team("Black Eagles");

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split("\\s+");
            String firstName = input[0];
            String lastName = input[0];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);
            Person player = new Person(firstName, lastName, age, salary);
            team.addPlayer(player);
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("First team have " + team.getReserveTeam().size() + " players");

    }
}

package exercise02_encapulation.p05_footballTeam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Map<String, Team> teams = new LinkedHashMap<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];

            try {
                switch (command) {
                    case "exercise02_encapulation.p05_footballTeam.Team":
                        Team team = new Team(teamName);
                        teams.putIfAbsent(teamName, team);
                        break;
                    case "Add":
                        String playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        if (teams.containsKey(teamName)) {
                            teams.get(teamName).addPlayer(player);
                        } else {
                            System.out.printf("exercise02_encapulation.p05_footballTeam.Team %s does not exist.\n", teamName);
                        }
                        break;
                    case "Remove":
                        playerName = tokens[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            System.out.printf("exercise02_encapulation.p05_footballTeam.Team %s does not exist.\n", teamName);
                        }
                        double rating = teams.get(teamName).getRating();
                        System.out.printf("%s - %.0f\n", teamName, rating);
                        break;
                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());

            }

            input = sc.nextLine();
        }
    }
}

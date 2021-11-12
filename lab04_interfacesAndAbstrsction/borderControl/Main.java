package lab04_interfacesAndAbstrsction.borderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<Identifiable> identifiable = new ArrayList<>();

        while (!input.equals("End")) {
            String[] intruders = input.split("\\s+");

            if (intruders.length == 3) {
                String citizenName = intruders[0];
                int age = Integer.parseInt(intruders[1]);
                String citizenId = intruders[2];
                Identifiable citizen = new Citizen(citizenName, age, citizenId);
                identifiable.add(citizen);
            } else if (intruders.length == 2) {
                String robotModel = intruders[0];
                String robotId = intruders[1];
                Identifiable robot = new Robot(robotId, robotModel);
                identifiable.add(robot);
            }

            input = sc.nextLine();
        }

        String fakeId = sc.nextLine();

        System.out.println(identifiable.stream().map(Identifiable::getId)
                .filter((robot -> robot.endsWith(fakeId))).collect(Collectors.joining(System.lineSeparator())));
    }
}

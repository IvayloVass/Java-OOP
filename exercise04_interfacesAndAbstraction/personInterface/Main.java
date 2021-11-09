package exercise04_interfacesAndAbstraction.personInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        List<Birthable> birthDates = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String member = tokens[0];
            switch (member) {
                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    birthDates.add(citizen);
                    break;
                case "Pet":
                    String petName = tokens[1];
                    String petBirthData = tokens[2];
                    Pet pet = new Pet(petName, petBirthData);
                    birthDates.add(pet);
                    break;
                case "Robot":
                    String model = tokens[1];
                    String robotId = tokens[2];
                    Robot robot = new Robot(robotId, model);
                    break;
            }

            input = sc.nextLine();
        }
        String specificYear = sc.nextLine();

        System.out.println(birthDates.stream().map(Birthable::getBirthDate)
                .filter(b -> b.endsWith(specificYear)).collect(Collectors.joining(System.lineSeparator())));
    }
}

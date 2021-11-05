package exercise02_encapulation.p02_animalParm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        try {
            Chicken chicken = new Chicken(name, age);

            System.out.println(chicken.toString());

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

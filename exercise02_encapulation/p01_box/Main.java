package exercise02_encapulation.p01_box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double length = Double.parseDouble(sc.nextLine());
        double wight = Double.parseDouble(sc.nextLine());
        double height = Double.parseDouble(sc.nextLine());

        try {
            Box box = new Box(length, wight, height);
            double surfaceArea = box.calculateSurfaceArea();
            double lateralArea = box.calculateLateralSurfaceArea();
            double volume = box.calculateVolume();
            System.out.printf("Surface Area - %.2f\n", surfaceArea);
            System.out.printf("Lateral Surface Area - %.2f\n", lateralArea);
            System.out.printf("Volume - %.2f\n", volume);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

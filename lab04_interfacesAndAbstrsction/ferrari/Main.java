package lab04_interfacesAndAbstrsction.ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String driverName = sc.nextLine();
        Car ferrari = new Ferrari(driverName);

        System.out.println(ferrari);
    }
}

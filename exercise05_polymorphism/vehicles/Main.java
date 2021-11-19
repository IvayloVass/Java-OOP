package exercise05_polymorphism.vehicles;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] carData = sc.nextLine().split("\\s+");
        double fuelQty = Double.parseDouble(carData[1]);
        double fuelConsumption = Double.parseDouble(carData[2]);

        Map<String, Vehicles> vehicles = new HashMap<>();

        vehicles.put("Car", new Car(fuelQty, fuelConsumption));

        String[] truckData = sc.nextLine().split("\\s+");

        fuelQty = Double.parseDouble(truckData[1]);
        fuelConsumption = Double.parseDouble(truckData[2]);

        vehicles.put("Truck", new Truck(fuelQty, fuelConsumption));

        int commandsNum = Integer.parseInt(sc.nextLine());

        while (commandsNum-- > 0) {
            String[] commands = sc.nextLine().split("\\s+");
            String action = commands[0];
            String vehicle = commands[1];

            if (action.equals("Drive")) {
                double kilometres = Double.parseDouble(commands[2]);
                vehicles.get(vehicle).driving(kilometres);

            } else if (action.equals("Refuel")) {
                double litres = Double.parseDouble(commands[2]);
                vehicles.get(vehicle).refueling(litres);
            }
        }

        for (Vehicles vehicle : vehicles.values()) {
            System.out.println(vehicle.toString());
        }

    }
}

package exercise01_abstraction.p04_trafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] signals = sc.nextLine().split("\\s+");
        int changesCounter = Integer.parseInt(sc.nextLine());
        List<Lights> lights = new ArrayList<>();
        for (String signal : signals) {
            Signals colour = Signals.valueOf(signal);
            Lights light = new Lights(colour);
            lights.add(light);
        }
        for (int i = 0; i < changesCounter; i++) {
            for (Lights light : lights) {
                light.changeSignal();
                System.out.print(light.getSignal() + " ");
            }
            System.out.println();
        }
    }
}

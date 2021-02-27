package TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] initialTrafficLightsStates = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String initialTrafficLightsState : initialTrafficLightsStates) {
            TrafficLight trafficLight = new TrafficLight(TrafficLightState.valueOf(initialTrafficLightsState));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < n ; i++) {
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight.toString());
            }
            System.out.println();
        }
    }
}

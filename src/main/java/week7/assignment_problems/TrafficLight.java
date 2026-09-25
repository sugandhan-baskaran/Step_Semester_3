package week7.assignment_problems;

import java.util.Scanner;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        color = "RED";
    }

    public void next() {
        switch (color) {
            case "RED" -> color = "GREEN";
            case "GREEN" -> color = "YELLOW";
            default -> color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter traffic light ID: ");
            TrafficLight trafficLight = new TrafficLight(scanner.nextLine());
            System.out.print("Enter number of changes: ");
            int numberOfChanges = scanner.nextInt();
            System.out.println("Color: " + trafficLight.getColor());
            for (int i = 0; i < numberOfChanges; i++) {
                trafficLight.next();
                System.out.println("Color: " + trafficLight.getColor());
            }
        }
    }
}

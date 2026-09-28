package week8.practice_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HostelElectricityBill {
    private interface Room {
        double bill();
        String type();
    }

    private record Single(int units) implements Room {
        @Override
        public double bill() { return units * 8.0; }
        @Override
        public String type() { return "SINGLE"; }
    }

    private record Shared(int units, int occupants) implements Room {
        @Override
        public double bill() { return units * 6.0 / occupants; }
        @Override
        public String type() { return "SHARED"; }
    }

    private record Ac(int units) implements Room {
        @Override
        public double bill() { return units * 10.0 + 200; }
        @Override
        public String type() { return "AC"; }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Room> rooms = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                int units = scanner.nextInt();
                rooms.add(type.equals("SINGLE") ? new Single(units)
                        : type.equals("SHARED") ? new Shared(units, scanner.nextInt()) : new Ac(units));
            }
            double total = 0;
            for (Room room : rooms) {
                total += room.bill();
                System.out.printf("%s: %.2f%n", room.type(), room.bill());
            }
            System.out.printf("Total: %.2f%n", total);
        }
    }
}
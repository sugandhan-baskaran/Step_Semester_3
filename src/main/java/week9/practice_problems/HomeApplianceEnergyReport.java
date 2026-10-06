package week9.practice_problems;

import java.util.Scanner;

public class HomeApplianceEnergyReport {
    interface SaverMode {
        double saverUnits(double units);
    }

    static abstract class Appliance {
        private static final double COST_PER_UNIT = 8;
        private final double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double power();

        double units() {
            return power() * hours / 1000;
        }

        double cost(boolean saver) {
            double usedUnits = units();
            if (saver) {
                usedUnits = ((SaverMode) this).saverUnits(usedUnits);
            }
            return usedUnits * COST_PER_UNIT;
        }

        double hours() {
            return hours;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }

        @Override
        double power() {
            return 150;
        }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        AirConditioner(double hours) {
            super(hours);
        }

        @Override
        double power() {
            return 1500;
        }

        @Override
        public double saverUnits(double units) {
            return units * 0.75;
        }
    }

    static class Tv extends Appliance {
        Tv(double hours) {
            super(hours);
        }

        @Override
        double power() {
            return 100;
        }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) {
            super(hours);
        }

        @Override
        double power() {
            return 500;
        }

        @Override
        public double saverUnits(double units) {
            return units * 0.75;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of appliances: ");
        int count = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter appliance and hours, optionally followed by SAVER: ");
            String type = scanner.next();
            double hours = scanner.nextDouble();
            boolean saver = scanner.hasNext("SAVER");
            if (saver) {
                scanner.next();
            }
            Appliance appliance;
            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AirConditioner(hours);
            } else if (type.equals("TV")) {
                appliance = new Tv(hours);
            } else {
                appliance = new Washer(hours);
            }
            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = appliance.units();
            if (saver) {
                units = ((SaverMode) appliance).saverUnits(units);
            }
            double cost = appliance.cost(saver);
            total += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }
}

package week9.assignment_problems;

import java.util.Scanner;

public class ElectricityConnectionBilling {
    static abstract class Connection {
        private final double units;

        Connection(double units) {
            this.units = units;
        }

        abstract double bill();

        double units() {
            return units;
        }
    }

    static class Home extends Connection {
        Home(double units) {
            super(units);
        }

        @Override
        double bill() {
            return units() <= 100 ? units() * 5 : 500 + (units() - 100) * 7;
        }
    }

    static class Shop extends Connection {
        Shop(double units) {
            super(units);
        }

        @Override
        double bill() {
            return units() * 8 + 100;
        }
    }

    static class Factory extends Connection {
        Factory(double units) {
            super(units);
        }

        @Override
        double bill() {
            return Math.max(units() * 6, 1000);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of connections: ");
        int count = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter connection type and units: ");
            String type = scanner.next();
            double units = scanner.nextDouble();
            Connection connection;
            if (type.equals("HOME")) {
                connection = new Home(units);
            } else if (type.equals("SHOP")) {
                connection = new Shop(units);
            } else {
                connection = new Factory(units);
            }
            double bill = connection.bill();
            total += bill;
            System.out.printf("%s: %.2f%n", type, bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}

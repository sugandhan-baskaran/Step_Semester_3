package week9.practice_problems;

import java.util.Scanner;

public class ParcelShippingDesk {
    interface Insurable {
        double insurance();
    }

    static abstract class Parcel {
        private final double weight;
        private final double declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double charge();

        double insurance() {
            return 0;
        }

        double total() {
            return charge() + insurance();
        }

        double weight() {
            return weight;
        }

        double declaredValue() {
            return declaredValue;
        }
    }

    static class Standard extends Parcel {
        Standard(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        double charge() {
            return 40 + weight() * 10;
        }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        double charge() {
            return 80 + weight() * 15;
        }

        @Override
        public double insurance() {
            return declaredValue() * 0.02;
        }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        @Override
        double charge() {
            return 40 + weight() * 10 + 50;
        }

        @Override
        public double insurance() {
            return declaredValue() * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of parcels: ");
        int count = scanner.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter parcel type, weight in kg, and declared value: ");
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();
            Parcel parcel;
            if (type.equals("STANDARD")) {
                parcel = new Standard(weight, declaredValue);
            } else if (type.equals("EXPRESS")) {
                parcel = new Express(weight, declaredValue);
            } else {
                parcel = new Fragile(weight, declaredValue);
            }
            double charge = parcel.charge();
            double insurance = parcel.insurance();
            double total = parcel.total();
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}

package week8.practice_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingPlanRenewal {
    private interface Subscription {
        String name();
        LocalDate renewalDate();
    }

    private abstract static class Plan implements Subscription {
        private final String name;
        private final LocalDate startDate;
        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }
        @Override
        public String name() { return name; }
        @Override
        public LocalDate renewalDate() { return startDate.plusDays(validityDays()); }
        protected abstract int validityDays();
    }

    private static class Basic extends Plan {
        Basic(String name, LocalDate startDate) { super(name, startDate); }
        @Override
        protected int validityDays() { return 30; }
    }

    private static class Standard extends Plan {
        Standard(String name, LocalDate startDate) { super(name, startDate); }
        @Override
        protected int validityDays() { return 90; }
    }

    private static class Premium extends Plan {
        Premium(String name, LocalDate startDate) { super(name, startDate); }
        @Override
        protected int validityDays() { return 365; }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            List<Subscription> subscriptions = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                String type = scanner.next();
                String name = scanner.next();
                LocalDate startDate = LocalDate.parse(scanner.next());
                subscriptions.add(type.equals("BASIC") ? new Basic(name, startDate)
                        : type.equals("STANDARD") ? new Standard(name, startDate) : new Premium(name, startDate));
            }
            for (Subscription subscription : subscriptions) {
                System.out.println(subscription.name() + ": " + subscription.renewalDate());
            }
        }
    }
}
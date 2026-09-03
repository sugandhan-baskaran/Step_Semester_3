package LEVEL_2;
import java.util.Scanner;
public class MenuCalculator {
    public void calculate(double a, double b, char operator) {
        switch (operator) {
            case '+' -> System.out.println("Result: " + (a + b));
            case '-' -> System.out.println("Result: " + (a - b));
            case '*' -> System.out.println("Result: " + (a * b));
            case '/' -> {
                if (b == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.println("Result: " + (a / b));
                }
            }
            default -> System.out.println("Invalid operator");
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            double a = sc.nextDouble();
            System.out.print("Enter second number: ");
            double b = sc.nextDouble();
            System.out.print("Enter operator: ");
            char operator = sc.next().charAt(0);

            MenuCalculator calculator = new MenuCalculator();
            calculator.calculate(a, b, operator);
        }
    }
}
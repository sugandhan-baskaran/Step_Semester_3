package main.java.week1.practice_problems;

public class BmiCalculator {
    public static void main(String[] args) {
        double[] heights = {1.75, 1.60};
        double[] weights = {70.0, 90.0};

        System.out.printf("%-10s | %-10s | %-11s | %-8s | %-12s%n", "Person", "Height(m)", "Weight(kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = bmi < 18.5 ? "Underweight" : (bmi < 25.0 ? "Normal" : (bmi < 30.0 ? "Overweight" : "Obese"));
            System.out.printf("%-10s | %-10.2f | %-11.2f | %-8.2f | %-12s%n", "Person " + (i + 1), heights[i], weights[i], bmi, status);
        }
    }
}
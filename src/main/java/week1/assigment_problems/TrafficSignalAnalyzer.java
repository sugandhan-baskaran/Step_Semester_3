import java.util.Scanner;
public class TrafficSignalAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Invalid input.");
            return;
        }
        char maxChar = signalLog.charAt(0);
        int maxLength = 1;
        char currentChar = signalLog.charAt(0);
        int currentLength = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxChar = currentChar;
                }
                currentChar = signalLog.charAt(i);
                currentLength = 1;
            }
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxChar = currentChar;
        }
        System.out.printf("Longest Streak: '%c' repeated %d times\n", maxChar, maxLength);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the signal log: ");
        String signalLog = scanner.nextLine();
        findLongestStreak(signalLog);
        scanner.close();
    }
}
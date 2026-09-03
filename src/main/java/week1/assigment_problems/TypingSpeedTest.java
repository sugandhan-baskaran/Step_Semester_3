import java.util.Scanner;
public class TypingSpeedTest {
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Error: The strings must be of equal length.");
            return;
        }
        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchIndex = -1; 
        for (int i = 0; i < totalCharacters; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else {
                if (firstMismatchIndex == -1) {
                    firstMismatchIndex = i;
                }
            }
        }
        double accuracy = ((double) matchedCharacters / totalCharacters) * 100;

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ", 
                          matchedCharacters, totalCharacters, accuracy);
        if (firstMismatchIndex == -1) {
            System.out.println("No Mismatches");
        } else {
            System.out.printf("First Mismatch at position %d ('%c' vs '%c')\n",
                    (firstMismatchIndex + 1),
                    original.charAt(firstMismatchIndex),
                    typed.charAt(firstMismatchIndex));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the original passage: ");
        String original = scanner.nextLine();
        System.out.print("Enter the typed passage: ");
        String typed = scanner.nextLine();
        System.out.println();
        checkTypingAccuracy(original, typed);
        scanner.close();
    }
}
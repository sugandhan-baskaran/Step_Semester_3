import java.util.Scanner;
public class ExamHallDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyProcessed = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    alreadyProcessed = true;
                    break;
                }
            }
            
            if (alreadyProcessed) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of seats: ");
        int n = scanner.nextInt();
        int[] seatNumbers = new int[n];
        System.out.println("Enter the seat numbers:");
        for (int i = 0; i < n; i++) {
            seatNumbers[i] = scanner.nextInt();
        }
        checkDuplicateSeats(seatNumbers);
        scanner.close();
    }
}
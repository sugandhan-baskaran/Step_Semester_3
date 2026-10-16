package week10.assignment_problems;

public class AttendanceTracker {
    public record Summary(int presentDays, int longestStreak) {}

    public static Summary attendanceSummary(int[] days) {
        int presentDays = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentDays++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }
        return new Summary(presentDays, longestStreak);
    }
}
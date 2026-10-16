package week10.assignment_problems;

public class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score == highest) {
                continue;
            }
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score > second) {
                second = score;
            }
        }
        return second;
    }
}
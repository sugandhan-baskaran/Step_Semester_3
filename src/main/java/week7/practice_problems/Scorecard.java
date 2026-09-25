package week7.practice_problems;

import java.util.Scanner;

public class Scorecard {
    private final boolean[] results;
    private int answerCount;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
    }

    public void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter total questions: ");
            Scorecard scorecard = new Scorecard(scanner.nextInt());
            for (int i = 0; i < scorecard.results.length; i++) {
                System.out.print("Was answer " + (i + 1) + " correct? ");
                scorecard.recordAnswer(scanner.nextBoolean());
            }
        System.out.println("Score: " + scorecard.getScore());
        }
    }
}

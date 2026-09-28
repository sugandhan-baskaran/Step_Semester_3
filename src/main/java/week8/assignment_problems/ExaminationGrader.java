package week8.assignment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationGrader {
    private interface Question {
        double score();
        String type();
    }

    private record ExactQuestion(String questionType, String correctAnswer, String studentAnswer, double points)
            implements Question {
        @Override
            public double score() {
                if (correctAnswer.equals(studentAnswer)) {
                    return points;
                }
                return 0;
            }

        @Override
            public String type() {
                return questionType;
            }
    }

    private record EssayQuestion(String correctAnswer, String studentAnswer, double points) implements Question {
        @Override
        public double score() {
            int matches = 0;

            for (String keyword : correctAnswer.split(",")) {
                    if (studentAnswer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                        matches++;
                    }
                }
                if (matches >= 2) {
                    return points * 0.75;
                }
                if (matches == 1) {
                    return points * 0.5;
            }
                return 0;
        }

        @Override
            public String type() {
                return "ESSAY";
            }
    }
    private static List<String> fields(String line) {
        List<String> result = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\\"([^\\\"]*)\\\"|(\\S+)").matcher(line);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                result.add(matcher.group(1));
            } else {
                result.add(matcher.group(2));
            }
        }

        return result;
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = Integer.parseInt(scanner.nextLine());
            List<Question> questions = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                List<String> values = fields(scanner.nextLine());
                String type = values.get(0);

                if (type.equals("ESSAY")) {
                    questions.add(new EssayQuestion(values.get(2), values.get(3), Double.parseDouble(values.get(4))));
                } else {
                    questions.add(new ExactQuestion(type, values.get(2), values.get(3), Double.parseDouble(values.get(4))));
                }
            }

            double total = 0;

            for (Question question : questions) {
                total += question.score();
                System.out.printf("%s: %.2f%n", question.type(), question.score());
            }
            System.out.printf("Total Score: %.2f%n", total);
        }
    }
}
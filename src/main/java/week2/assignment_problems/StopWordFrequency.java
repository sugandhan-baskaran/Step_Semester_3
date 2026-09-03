package main.java.week2.assignment_problems;

import java.util.*;

public class StopWordFrequency{
    static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        Set<String> stopSet = new HashSet<>(Arrays.asList(stopWords));
        feedback = feedback.toLowerCase().replace(".", "")
                .replace(",", "");
        String[] words = feedback.split("\\s+");
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (!stopSet.contains(word)) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter feedback:");
        String feedback = sc.nextLine();
        printFilteredWordFrequency(feedback);
        sc.close();
    }
}
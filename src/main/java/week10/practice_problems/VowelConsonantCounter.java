package week10.practice_problems;

import java.util.Scanner;

public class VowelConsonantCounter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String word = scanner.next();
            int vowels = 0;
            for (char character : word.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(character) >= 0) {
                    vowels++;
                }
            }
            System.out.println("Vowels: " + vowels);
            System.out.println("Consonants: " + (word.length() - vowels));
        }
    }
}
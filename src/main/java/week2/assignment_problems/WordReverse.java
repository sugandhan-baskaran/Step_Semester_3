package main.java.week2.assignment_problems;

import java.util.Scanner;

public class WordReverse {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]);
            reversedWord.reverse(); 
            result.append(reversedWord);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();
        String output = reverseEachWord(input);
        System.out.println(output);
        sc.close();
    }
}
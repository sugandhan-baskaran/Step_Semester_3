package main.java.week1.practice_problems;

import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }
        
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        
        return text.equals(new String(reversed));
    }

    public static void printResults(String text) {
        String iterResult = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String recResult = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String arrResult = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";
        
        System.out.println("Iterative: " + iterResult + " | Recursive: " + recResult + " | Array Reversal: " + arrResult);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check for palindrome: ");
        String input = scanner.nextLine();
        printResults(input);
        scanner.close();
        
    }
}

package main.java.week1.practice_problems;

import java.util.Scanner;
public class ReverseCustomerName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        char[] chars = name.toCharArray();
        StringBuilder reversed = new StringBuilder();
        
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed.append(chars[i]);
        }
        
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed.toString());
    }
}

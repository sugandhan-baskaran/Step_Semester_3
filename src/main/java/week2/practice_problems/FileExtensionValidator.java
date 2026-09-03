package main.java.week2.practice_problems;

import java.util.Scanner;

public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        
        if (dotIndex > 0 && dotIndex < filename.length() - 1) {
            String extension = filename.substring(dotIndex + 1);
            if (extension.equalsIgnoreCase("pdf") || 
                extension.equalsIgnoreCase("docx") || 
                extension.equalsIgnoreCase("zip")) {
                return "Accepted";
            }
        }
        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String input = sc.nextLine();
        System.out.println(validateFileExtension(input));
        sc.close();
    }
}

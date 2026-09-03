package main.java.week2.practice_problems;

import java.util.Scanner;

public class CsvRecordParser {
    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length == 3) {
            String name = fields[0].trim();
            String roll = fields[1].trim();
            String dept = fields[2].trim();
            System.out.println("Name: " + name + " | Roll No: " + roll + " | Dept: " + dept);
        } else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter CSV line (Name,RollNumber,Department): ");
        String input = sc.nextLine();
        parseStudentRecord(input);
        sc.close();
    }
}

package main.java.week2.assignment_problems;

import java.util.Scanner;

public class InventoryParser {
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length == 3) {
            System.out.println("Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
        } else {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an inventory record (Product,SKU,Qty):");
        String userInput = sc.nextLine();
        parseInventoryRecord(userInput);
        sc.close();
    }
}
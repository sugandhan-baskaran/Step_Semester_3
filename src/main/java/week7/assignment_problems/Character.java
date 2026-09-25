package week7.assignment_problems;

import java.util.Scanner;

public class Character {
    private final int maximumHealth;
    private int health;

    public Character(int maximumHealth) {
        this.maximumHealth = maximumHealth;
        health = maximumHealth;
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        health = Math.min(maximumHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter maximum health: ");
            Character character = new Character(scanner.nextInt());
            System.out.print("Enter damage: ");
            character.takeDamage(scanner.nextInt());
            System.out.println("Health: " + character.getHealth());
            System.out.print("Enter healing: ");
            character.heal(scanner.nextInt());
            System.out.println("Health: " + character.getHealth());
            System.out.print("Enter damage: ");
            character.takeDamage(scanner.nextInt());
            System.out.println("Health: " + character.getHealth());
        }
    }
}

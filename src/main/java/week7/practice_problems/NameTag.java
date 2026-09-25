package week7.practice_problems;

import java.util.Scanner;

public class NameTag {
    private final String firstName;
    private final char lastNameInitial;

    public NameTag(String fullName) {
        String[] nameParts = fullName.split(" ");
        firstName = nameParts[0];
        lastNameInitial = nameParts[1].charAt(0);
    }

    public String getNickname() {
        return firstName + " " + lastNameInitial + ".";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter full name: ");
            NameTag nameTag = new NameTag(scanner.nextLine());
            System.out.println("Nickname: " + nameTag.getNickname());
        }
    }
}

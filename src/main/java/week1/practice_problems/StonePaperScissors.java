package main.java.week1.practice_problems;

import java.util.Random;
import java.util.Scanner;

public class StonePaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "paper", "scissor"};

        int win = 0;
        int loss = 0;
        int draw = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("0-Rock");
            System.out.println("1-paper");
            System.out.println("2-scissors");
            System.out.print("Enter your choice: ");

            int user = sc.nextInt();
            int computer = random.nextInt(3);

            System.out.println("player: " + moves[user]);
            System.out.println("computer: " + moves[computer]);

            if (user == computer) {
                System.out.println("Draw!");
                draw++;
            } else if ((user == 0 && computer == 2) || 
                       (user == 1 && computer == 0) || 
                       (user == 2 && computer == 1)) {
                System.out.println("Player wins!");
                win++;
            } else {
                System.out.println("computer wins");
                loss++;
            }
            System.out.println("\n");
        }

        System.out.println("wins:" + win);
        System.out.println("losses:" + loss);
        System.out.println("draw:" + draw);

        double percentage = (win * 100.0) / 5;
        System.out.printf("win percentage: %.1f%%\n", percentage);

        sc.close();
    }
}
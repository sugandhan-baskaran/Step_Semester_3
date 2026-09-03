package main.java.week1.practice_problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String text = "swiss";
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c : text.toCharArray()) {
            if (map.get(c) == 1) {
                System.out.println("First Non-Repeating Character: '" + c + "'");
                return;
            }
        }
        System.out.println("No Non-Repeating Character Found");
    }
}
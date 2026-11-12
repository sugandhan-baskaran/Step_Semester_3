package week11.assignment_problems;

public class FirstBreak {
    public static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstBreak(new int[]{3, 5, 5, 8, 6, 9}));
        System.out.println(firstBreak(new int[]{1, 2, 2, 7}));
        System.out.println(firstBreak(new int[]{1, 3, 2}));
        System.out.println(firstBreak(new int[]{}));
    }
}

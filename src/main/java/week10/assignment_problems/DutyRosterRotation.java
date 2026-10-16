package week10.assignment_problems;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, long k) {
        int length = names.length;
        int shift = (int) (k % length);
        String[] rotated = new String[length];

        for (int index = 0; index < length; index++) {
            rotated[(index + shift) % length] = names[index];
        }
        return rotated;
    }
}
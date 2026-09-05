package main.java.week5.practice_problems;

import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;
    double compositeScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
        this.compositeScore = (cgpa * 10.0) + (codingScore / 2.0); 
    }

    @Override
    public int compareTo(Candidate other) {
        // Sort descending
        return Double.compare(other.compositeScore, this.compositeScore); 
    }
}

public class PlacementEngine {

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0; 
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return isEligible(cgpa) || (cgpa >= 6.5 && codingScore >= 60);
    }

    static String shortlistAndRank(Candidate[] candidates) {

        int eligibleCount = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa, c.codingScore)) {
                eligibleCount++;
            }
        }

        Candidate[] shortlisted = new Candidate[eligibleCount];
        int index = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa, c.codingScore)) {
                shortlisted[index++] = c;
            }
        }

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ")
                  .append(shortlisted[i].name).append(" (")
                  .append(shortlisted[i].compositeScore).append(")");
            
            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
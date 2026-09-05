package main.java.week4.practice_problems;


import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();
        int[] prices = new int[n];
        
        System.out.print("Enter daily stock prices: ");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        
        System.out.println("Maximum Profit: " + maxProfit(prices));
    }
}
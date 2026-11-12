package week11.practice_problems;

public class BestSingleTradeProfit {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;

        int minimumPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maximumProfit = Math.max(maximumProfit, prices[i] - minimumPrice);
            minimumPrice = Math.min(minimumPrice, prices[i]);
        }
        return maximumProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{2, 4, 1, 8}));
    }
}

package week7.assignment_problems;

import java.util.Scanner;

public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int maximumItems) {
        this.cartId = cartId;
        prices = new double[maximumItems];
    }

    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i < itemCount) {
                count++;
            }
        }
        return count;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter cart ID: ");
            String cartId = scanner.nextLine();
            System.out.print("Enter maximum items: ");
            Cart cart = new Cart(cartId, scanner.nextInt());
            System.out.print("Enter number of items: ");
            int numberOfItems = scanner.nextInt();
            for (int i = 0; i < numberOfItems; i++) {
                System.out.print("Enter price for item " + (i + 1) + ": ");
                cart.addItem(scanner.nextDouble());
            }
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
        }
    }
}

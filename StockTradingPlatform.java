import java.util.ArrayList;
import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> stockNames = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        double balance = 10000;
        int choice;

        do {
            System.out.println("\n===== Stock Trading Platform =====");
            System.out.println("Balance: " + balance);
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // FIX

            switch (choice) {

                case 1:
                    System.out.print("Enter stock name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    double cost = price * qty;

                    if (cost > balance) {
                        System.out.println("Not enough balance!");
                    } else {
                        balance -= cost;
                        stockNames.add(name);
                        quantities.add(qty);
                        prices.add(price);
                        System.out.println("Stock bought!");
                    }
                    break;

                case 2:
                    System.out.print("Enter stock name to sell: ");
                    String sellName = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < stockNames.size(); i++) {
                        if (stockNames.get(i).equalsIgnoreCase(sellName)) {

                            System.out.print("Enter quantity to sell: ");
                            int sellQty = sc.nextInt();

                            if (sellQty > quantities.get(i)) {
                                System.out.println("Not enough stock!");
                            } else {
                                quantities.set(i, quantities.get(i) - sellQty);
                                double amount = sellQty * prices.get(i);
                                balance += amount;
                                System.out.println("Stock sold!");
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Stock not found!");
                    }
                    break;

                case 3:
                    if (stockNames.isEmpty()) {
                        System.out.println("No stocks.");
                    } else {
                        System.out.println("\n--- Portfolio ---");
                        for (int i = 0; i < stockNames.size(); i++) {
                            System.out.println(stockNames.get(i) + " | Qty: " 
                                + quantities.get(i) + " | Price: " + prices.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
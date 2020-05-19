package best_time_to_buy_and_sell_stock_121;

public class Main {

	public static void main(String args[]) {

		System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
		System.out.println(maxProfit(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 }));
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 2, 4, 1 }));
		System.out.println(maxProfit(new int[] { 7, 2, 1, 4 }));
		System.out.println(maxProfit(new int[] { 7, 2, 4, 1 }));
		System.out.println(maxProfit(new int[] { 1, 2 }));
	}

	public static int maxProfit(int[] prices) {

		if (prices.length == 0)
			return 0;

		int stock = prices[0];
		int sum = 0;

		for (int i = 0; i < prices.length - 1; i++) {
			if (stock > prices[i]) {
				stock = prices[i];
			}
			if (sum < prices[i + 1] - stock)
				sum = prices[i + 1] - stock;
		}
		return sum;
	}

}

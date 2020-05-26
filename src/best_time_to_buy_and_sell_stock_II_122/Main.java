package best_time_to_buy_and_sell_stock_II_122;

public class Main {

	public static void main(String args[]) {

		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })); // 7
		System.out.println(maxProfit(new int[] { 6, 1, 3, 2, 4, 7 })); // 7
		System.out.println(maxProfit(new int[] { 3, 2, 6, 5, 0, 3 })); // 7
		System.out.println(maxProfit(new int[] { 2, 1, 4, 5, 2, 9, 7 })); // 11

	}

	public static int maxProfit(int[] prices) {

		if (prices.length == 0)
			return 0;
		
		int total = 0;

		for (int i = 0; i < prices.length - 1; i++) {

			if(0 < prices[i + 1] - prices[i] )
				total = total + prices[i + 1] - prices[i];

		}
		return total;
	}
}

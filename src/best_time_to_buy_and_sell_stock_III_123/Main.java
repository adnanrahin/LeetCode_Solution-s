package best_time_to_buy_and_sell_stock_III_123;

public class Main {

	public static void main(String args[]) {

		System.out.println(maxProfit(new int[] { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 }));
	}

	public static int maxProfit(int[] prices) {

		int buy1 = Integer.MAX_VALUE;
		int buy2 = Integer.MAX_VALUE;

		int sell1 = 0;
		int sell2 = 0;

		for (int i = 0; i < prices.length; i++) {

			buy1 = Math.min(buy1, prices[i]);
			sell1 = Math.max(sell1, prices[i] - buy1);
			buy2 = Math.min(buy2, prices[i] - sell1);
			sell2 = Math.max(sell2, prices[i] - buy2);

			System.out.println(buy1 + " " + sell1 + " " + buy2 + " " + sell2);

		}
		return sell2;
	}

}

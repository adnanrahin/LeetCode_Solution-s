package best_time_to_buy_and_sell_stock_with_cooldown_309;

public class Main {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{5, 4, 3, 6, 1, 5, 4, 2, 7}));
    }

    public static int maxProfit(int[] prices) {

        int sell = 0, p_sell = 0, buy = Integer.MIN_VALUE, p_buy;

        for (int i = 0; i < prices.length; i++) {
            p_buy = buy;
            buy = Math.max(buy, p_sell - prices[i]);
            p_sell = sell;
            sell = Math.max(p_buy + prices[i], p_sell);
        }

        return sell;
    }
}

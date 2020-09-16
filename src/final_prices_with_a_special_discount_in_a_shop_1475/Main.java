package final_prices_with_a_special_discount_in_a_shop_1475;

public class Main {

    public static void main(String[] args) {

    }

    public static int[] finalPrices(int[] prices) {

        for (int i = 0; i < prices.length; i++) {
            int discount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            prices[i] -= discount;
        }
        return prices;
    }

}

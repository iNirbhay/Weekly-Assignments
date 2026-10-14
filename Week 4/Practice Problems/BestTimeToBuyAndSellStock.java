public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int lowestPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitToday = prices[i] - lowestPrice;
            if (profitToday > maxProfit) {
                maxProfit = profitToday;
            }
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}

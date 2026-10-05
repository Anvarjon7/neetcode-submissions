class Solution {

    int[] prices;
    int[] dp;

    public int maxProfit(int[] prices) {
        this.prices = prices;

        int n = prices.length;
        if(n <= 1) return 0;

        dp = new int[n];
        Arrays.fill(dp,-1);

        return solve(0);
    }


    private int solve(int i) {
        if(i >= prices.length) return 0;

        if(dp[i] != -1) {
            return dp[i];
        }

        int best = 0;

        int skip = solve(i + 1);

        for(int j = i + 1; j < prices.length; j++) {
            int profit = prices[j] - prices[i] + solve(j+2);

            best = Math.max(best, profit);
        }

        int result = Math.max(skip, best);
        dp[i] = result;

        return result;
    }
}

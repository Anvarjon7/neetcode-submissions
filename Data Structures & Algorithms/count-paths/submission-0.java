class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for(int row = 1; row < m; row++) {
            for(int col = 1; col < n; col++){
                dp[col] = dp[col] + dp[col-1];
            }
        }

        return dp[n-1];
    }
}

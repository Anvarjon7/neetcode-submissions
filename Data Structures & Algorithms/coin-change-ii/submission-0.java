class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int num : coins) {
            for(int sum = num; sum <= amount; sum++) {
                dp[sum] = dp[sum] + dp[sum - num];
                            

            }
            
        }
        return dp[amount];
    }

//    dp = [1,1,1,1,1] coins = [1,2,3]
//    dp = [1,1,2,2,3]
//    dp = [1,1,2,3,4]
//            1,2,3,4,5
   

// 1,1,1
// 1,2
// 3

}


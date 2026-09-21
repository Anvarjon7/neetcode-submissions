class Solution {
    public boolean canPartition(int[] nums) {

        int totalSum = 0;
        
        for(int num : nums) {
            totalSum+=num;
        }

        if(totalSum % 2 != 0) return false;

        int target = totalSum / 2;

        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int num : nums) {
            for(int s = target - num; s >= 0; s--){
                if(dp[s]) {
                    dp[s + num] = true;
                }
            }
        }

        return dp[target];
    }
}

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        int[] firstSkip = Arrays.copyOfRange(nums, 1, n);
        int[] lastSkip = Arrays.copyOfRange(nums,0, n - 1);

        return Math.max(countMax(firstSkip), countMax(lastSkip));
    }


    int countMax(int nums[]) {
        int prev2 = nums[0], prev1 = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.max(prev2, prev1);
    }
}

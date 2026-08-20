class Solution {
    public int maxProduct(int[] nums) {

        int l = nums.length;
        if(l == 1) return nums[0];
        
        int currMax = nums[0], currMin = nums[0];
        int res = 0;

        for(int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if(n == 0) {
                currMin = 1;
                currMax = 1;
            }

            int tmp = currMax * n;
            currMax = Math.max(Math.max(currMax * n, currMin * n),n);
            currMin = Math.min(Math.min(tmp, n * currMin), n);

            res = Math.max(res,currMax);
        }

        return res;
    }
}

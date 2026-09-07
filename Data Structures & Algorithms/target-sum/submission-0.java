class Solution {

    private int target;
    private Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        this.target = target;
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int currentSum) {
        
        if(index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        String key = index + "," + currentSum;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int pos = dfs(nums, index + 1, currentSum + nums[index]);
        int neg = dfs(nums, index + 1, currentSum - nums[index]);

        int result = pos + neg;
        memo.put(key, result);

        return result;
    }
}

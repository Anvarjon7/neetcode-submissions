class Solution {
   public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[] curr = new int[n+1];
        int[] prev = new int[n+1];

        for(int i = 0; i < n+1; i++) {
            curr[i] = 0;
            prev[i] = 0;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    curr[j] = prev[j - 1] + 1;
                }else {
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }

            prev = curr;
            curr = new int[n+1];
            Arrays.fill(curr,0);
        }

        return prev[prev.length-1];
    }
}

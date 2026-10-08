class Solution {

    String s1;
    String s2;
    String s3;

    Boolean[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        this.memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return explore(0,0,0);
    }


    private boolean explore(int i, int j, int k) {

        if(k == s3.length()) {
            return true;
        }

        if(memo[i][j] != null) {
            return memo[i][j];
        }

        boolean s1Result = false;
        boolean s2Result = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            s1Result = explore(i+1, j, k+1);
        }
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            s2Result = explore(i, j+1, k+1);
        }

        boolean res = s1Result || s2Result;
        memo[i][j] = res;

        return res;
    }
}

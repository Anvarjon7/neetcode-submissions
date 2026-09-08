class Solution {

    private String s;
    private List<String> wordDict;
    private Map<Integer, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        this.s = s;
        this.wordDict = wordDict;

        return dfs(0);
    }

    boolean dfs(int startIndex) {

        if(startIndex == s.length()) return true;
        if(memo.containsKey(startIndex)) {
            return memo.get(startIndex);
        }

        for(String word : wordDict) {
            int end = startIndex + word.length();

            if(end <= s.length() && s.substring(startIndex, end).equals(word)) {
                if(dfs(end)) {
                    memo.put(startIndex, true);
                    return true;
                }
            }
        }

        memo.put(startIndex, false);
        return false;
    }
}

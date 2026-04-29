class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for(int i = 0; i < s.length(); i++){
            sFreq[s.charAt(i) - 'a']++;
            tFreq[t.charAt(i) - 'a']++;
        }

        for(char c : s.toCharArray()){
            int idx = c - 'a';
            if(sFreq[idx] != tFreq[idx]){
                return false;
            }
        }

        return true;
    }
}

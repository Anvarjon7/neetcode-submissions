class Solution {
    public int countSubstrings(String s) {
        
        int n = s.length();

        if(n == 0) return 0;

        int counter = 0;

        for(int center = 0; center < n; center++) {

            int left = center;
            int right = center;

            while(left >= 0 && right < n 
                   && s.charAt(left) == s.charAt(right)) {

                counter++;
                left--;
                right++;
            }

            left = center;
            right = center + 1;

            while(left >= 0 && right < n && 
                s.charAt(left) == s.charAt(right)) {

                counter++;
                left--;
                right++;
            }
        }


        return counter;
    }
}

class Solution {
    public String longestPalindrome(String s) {

         int n = s.length();

    if (n == 0) {
        return "";
    }

    int start = 0;
    int maxLength = 1;

    for (int center = 0; center < n; center++) {

        // Odd-length palindrome
        int left = center;
        int right = center;

        while (left >= 0
                && right < n
                && s.charAt(left) == s.charAt(right)) {

            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                start = left;
            }

            left--;
            right++;
        }

        // Even-length palindrome
        left = center;
        right = center + 1;

        while (left >= 0
                && right < n
                && s.charAt(left) == s.charAt(right)) {

            int currentLength = right - left + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                start = left;
            }

            left--;
            right++;
        }
    }

        return s.substring(start, start + maxLength);
    }
}

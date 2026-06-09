class Solution {
    public String longestPalindrome(String s) {

        int m = s.length();

        String t = new StringBuilder(s).reverse().toString();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        int maxLen = 0;
        int endIndex = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    int len = dp[i][j];

                    // Starting index in original string
                    int originalStart = i - len;

                    // Corresponding starting index in original string
                    int reversedStart = m - j;

                    if (originalStart == reversedStart && len > maxLen) {
                        maxLen = len;
                        endIndex = i;
                    }

                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s.substring(endIndex - maxLen, endIndex);
    }
}
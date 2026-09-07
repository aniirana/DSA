class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int mod = 1000000007;

        long[] dp = new long[n + 1];
        int[] last = new int[26];
        Arrays.fill(last, -1);
        dp[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            int ch = s.charAt(i - 1) - 'a';
            dp[i] = (2 * dp[i - 1]) % mod;

            if (last[ch] != -1) {
                dp[i] = (dp[i] - dp[last[ch] - 1] + mod) % mod;
            }
            last[ch] = i;

        }

        return (int) ((dp[n] - 1 + mod) % mod);
    }
}
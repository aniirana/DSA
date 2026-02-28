class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int mod = 1000000007;
        int bits = 0;

        for (int i = 1; i <= n; i++) {

            // Check power of 2
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            ans = ((ans << bits) | i) % mod;
        }

        return (int) ans;
    }
}
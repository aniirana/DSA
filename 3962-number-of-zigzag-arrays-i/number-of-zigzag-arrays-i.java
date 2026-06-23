class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        // length = 2
        for (int x = 1; x <= m; x++) {
            up[x] = x - 1;
            down[x] = m - x;
        }

        if (n == 2) {
            long ans = 0;
            for (int x = 1; x <= m; x++) {
                ans = (ans + up[x] + down[x]) % MOD;
            }
            return (int) ans;
        }

        for (int len = 3; len <= n; len++) {

            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];

            long pref = 0;
            for (int x = 1; x <= m; x++) {
                newUp[x] = pref;
                pref = (pref + down[x]) % MOD;
            }

            long suff = 0;
            for (int x = m; x >= 1; x--) {
                newDown[x] = suff;
                suff = (suff + up[x]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int x = 1; x <= m; x++) {
            ans = (ans + up[x] + down[x]) % MOD;
        }

        return (int) ans;
    }
}
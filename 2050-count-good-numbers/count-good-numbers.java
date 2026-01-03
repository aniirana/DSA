class Solution {
    static final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {   // ← return type fixed
        long even = (n + 1) / 2;
        long odd = n / 2;

        long ans = (pow(5, even) * pow(4, odd)) % MOD;
        return (int) ans;                  // ← cast added
    }

    public long pow(long x, long n) {
        if (n == 0) {
            return 1;
        }

        long half = pow(x, n / 2);
        long result = (half * half) % MOD;

        if (n % 2 == 1) {
            result = (result * x) % MOD;
        }

        return result;
    }
}

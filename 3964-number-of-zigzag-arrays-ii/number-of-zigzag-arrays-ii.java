class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int size = 2 * m;

        long[] state = new long[size];

        // Length = 2 initialization
        for (int v = 0; v < m; v++) {
            state[v] = v;               // up[v+1] = v
            state[m + v] = m - 1 - v;   // down[v+1] = m - (v+1)
        }

        long[][] T = new long[size][size];

        // up_new[v] = sum(down[u]) for u < v
        for (int v = 0; v < m; v++) {
            for (int u = 0; u < v; u++) {
                T[v][m + u] = 1;
            }
        }

        // down_new[v] = sum(up[u]) for u > v
        for (int v = 0; v < m; v++) {
            for (int u = v + 1; u < m; u++) {
                T[m + v][u] = 1;
            }
        }

        long[][] P = matrixPower(T, n - 2);

        long[] result = multiply(P, state);

        long ans = 0;
        for (long x : result) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    sum = (sum + A[i][j] * v[j]) % MOD;
                }
            }
            res[i] = sum;
        }

        return res;
    }

    private long[][] matrixPower(long[][] base, long exp) {
        int n = base.length;

        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;

                long aik = A[i][k];

                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;

                    res[i][j] = (res[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }

        return res;
    }
}
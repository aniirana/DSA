class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        if (n == 0 || m == 0) return 0L;

        // lastFinish[i] = finish time of the previous potion (initially potion 0) on wizard i
        long[] lastFinish = new long[n];

        // Initialize using potion 0 (S0 = 0)
        long cum = 0L;
        for (int i = 0; i < n; i++) {
            cum += (long) skill[i] * (long) mana[0];
            lastFinish[i] = cum; // finish time of potion 0 on wizard i
        }

        // Process potions 1..m-1
        for (int j = 1; j < m; j++) {
            // Build prefix sums Acol where Acol[i] = sum_{k=0..i-1} p[k][j]
            long[] Acol = new long[n + 1];
            Acol[0] = 0L;
            for (int i = 1; i <= n; i++) {
                Acol[i] = Acol[i - 1] + (long) skill[i - 1] * (long) mana[j];
            }

            // Earliest start S_j such that for all i: S_j + Acol[i] >= lastFinish[i]
            long Sj = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long candidate = lastFinish[i] - Acol[i];
                if (candidate > Sj) Sj = candidate;
            }
            if (Sj < 0) Sj = 0L;

            // Update finish times for this potion j
            for (int i = 0; i < n; i++) {
                lastFinish[i] = Sj + Acol[i + 1]; // finish time on wizard i = S_j + A_{i+1}
            }
        }

        // makespan = finish time of last potion on last wizard
        return lastFinish[n - 1];
    }
}

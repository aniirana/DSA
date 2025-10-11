import java.util.*;

class Solution {
    /**
     * Calculates the maximum total damage, where selecting a power 'p' 
     * forces the discard of all enemies with power 'p-1', 'p', and 'p+1'.
     * This is an adaptation of the "Delete and Earn" DP pattern.
     */
    public long maximumTotalDamage(int[] power) {
        // 1. Preprocessing: Count total damage for each unique power level
        java.util.HashMap<Integer, Long> damageMap = new java.util.HashMap<>();
        for (int p : power) {
            damageMap.put(p, damageMap.getOrDefault(p, 0L) + p);
        }

        // 2. Get sorted unique power levels (keys)
        java.util.ArrayList<Integer> keys = new java.util.ArrayList<>(damageMap.keySet());
        java.util.Collections.sort(keys);

        int n = keys.size();
        if (n == 0) return 0L;

        // dp[i] = Maximum total damage considering power levels up to keys[i]
        long[] dp = new long[n];
        
        // Use a pointer 'j' to track the last non-conflicting power level index.
        // Since keys are sorted, j only moves forward, making the search O(1) amortized.
        int j = -1; 
        
        for (int i = 0; i < n; i++) {
            int curPower = keys.get(i);
            long curDamage = damageMap.get(curPower);
            
            // --- A. Option: Include curPower ---
            
            // Find the last index 'j' such that keys[j] is not conflicting.
            // A non-conflicting power is keys[j] <= curPower - 3.
            // Since j only advances when curPower is far enough, this is efficient.
            while (j + 1 < i && keys.get(j + 1) <= curPower - 3) {
                j++;
            }
            
            long maxDamageFromPast = (j == -1) ? 0L : dp[j];
            long includeDamage = curDamage + maxDamageFromPast;

            // --- B. Option: Exclude curPower ---
            long excludeDamage = (i == 0) ? 0L : dp[i - 1];

            // dp[i] is the maximum of the two options
            dp[i] = Math.max(includeDamage, excludeDamage);
        }

        return dp[n - 1];
    }
}
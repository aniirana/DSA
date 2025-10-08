import java.util.Arrays;

public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            long minNeeded = (success + spell - 1) / spell; // ceil(success / spell)

            // inline binary search for first potion >= minNeeded
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) potions[mid] < minNeeded) left = mid + 1;
                else right = mid - 1;
            }

            pairs[i] = m - left;
        }

        return pairs;
    }
}

import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long lastUsed = Long.MIN_VALUE;
        int distinctCount = 0;
        
        for (int x : nums) {
            long start = (long) x - k;
            long end = (long) x + k;
            long assign = Math.max(start, lastUsed + 1);
            if (assign <= end) {
                distinctCount++;
                lastUsed = assign;
            }
        }
        
        return distinctCount;
    }
}

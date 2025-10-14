import java.util.*;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> numsList, int k) {
        int n = numsList.size();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = numsList.get(i); 

        for (int a = 0; a <= n - 2 * k; a++) {
            if (isIncreasing(nums, a, k) && isIncreasing(nums, a + k, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean isIncreasing(int[] nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums[i] >= nums[i + 1]) return false;
        }
        return true;
    }
}

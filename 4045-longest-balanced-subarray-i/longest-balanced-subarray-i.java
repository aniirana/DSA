import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> evens = new HashSet<>();
            Set<Integer> odds = new HashSet<>();

            for (int j = i; j < n; j++) {
                if ((nums[j] & 1) == 0) {   // even
                    evens.add(nums[j]);
                } else {                  // odd
                    odds.add(nums[j]);
                }

                if (evens.size() == odds.size()) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}

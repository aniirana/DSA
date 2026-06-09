class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        return 1L * k * (max - min);
    }
}
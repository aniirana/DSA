class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[] squares = new long[n];

        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        int negative = n / 2;
        long ans = 0;

        // Smallest squares are subtracted
        for (int i = 0; i < negative; i++) {
            ans -= squares[i];
        }

        // Largest squares are added
        for (int i = negative; i < n; i++) {
            ans += squares[i];
        }

        return ans;
    }
}
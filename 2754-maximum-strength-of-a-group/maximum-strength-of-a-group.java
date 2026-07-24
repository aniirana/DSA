class Solution {
    public long maxStrength(int[] nums) {
        int n=nums.length;
         if (n == 1) return nums[0];
        Arrays.sort(nums);
        long product = 1;
        int negCount = 0;
        int zeroCount = 0;

        for (int num : nums) {
            if (num < 0) negCount++;
            else if (num == 0) zeroCount++;
        }


        int skip = -1;
        if (negCount % 2 == 1) {
            skip = negCount - 1;   // index of largest negative
        }

        boolean taken = false;

        for (int i = 0; i < n; i++) {
            if (i == skip) continue;
            if (nums[i] == 0) continue;

            product *= nums[i];
            taken = true;
        }

        // If nothing was taken
        if (!taken) {
            // If zero exists, answer is 0
            if (zeroCount > 0) return 0;

            // Otherwise all numbers were negative and only one exists
            return nums[n - 1];
        }

        return product;
    
        

        
    }
}
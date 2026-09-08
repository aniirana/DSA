class Solution {
    public int countCommas(int n) {
        int count=0;
      
        for (long x = 1000; x <= n; x *= 1000) {
            count += n - x + 1;
        }

        return count;
    }
}
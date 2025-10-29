public class Solution {
    public int smallestNumber(int n) {
        int mask = 1;
        while (mask < n) {
            mask = (mask << 1) | 1;
        }
        return mask;
    }
}

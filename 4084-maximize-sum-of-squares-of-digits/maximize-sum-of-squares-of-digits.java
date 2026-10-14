class Solution {
    public String maxSumOfSquares(int num, int sum) {
        
        // Maximum possible digit sum
        if (sum > 9 * num) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        // Put as many 9s as possible
        while (sum >= 9) {
            ans.append('9');
            sum -= 9;
            num--;
        }

        // Put the remaining digit
        if (sum > 0) {
            ans.append(sum);
            num--;
        }

        // Fill remaining positions with 0
        while (num > 0) {
            ans.append('0');
            num--;
        }

        return ans.toString();
    }
}
class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] lastSeen = {-1, -1, -1}; // To store the last seen index of 'a', 'b', and 'c'
        int count = 0;

        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            }
        }

        return count;
    }

    // public static void main(String[] args) {
    //     Solution sol = new Solution();
    //     System.out.println(sol.numberOfSubstrings("abcabc")); // Output: 10
    //     System.out.println(sol.numberOfSubstrings("aaacb"));  // Output: 3
    //     System.out.println(sol.numberOfSubstrings("abc"));    // Output: 1
    // }
}
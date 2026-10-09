class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int need = 0; // number of ')' needed

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {

                // If need is odd, one ')' is pending.
                // Complete that pair first.
                if (need % 2 == 1) {
                    insertions++;
                    need--;
                }

                // Every '(' requires two ')'
                need += 2;

            } else {
                need--;

                // Extra ')' with no '(' available
                if (need < 0) {
                    // Insert '(' before this ')'
                    insertions++;
                    
                    // New '(' needs 2 ')',
                    // current ')' already provides one
                    need = 1;
                }
            }
        }

        // Insert all remaining required ')'
        return insertions + need;
    }
}
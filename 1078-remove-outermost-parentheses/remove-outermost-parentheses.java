class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // If depth > 0, this is NOT an outermost '('
                if (depth > 0) {
                    ans.append(ch);
                }

                depth++;
            }

            else { // ch == ')'
                depth--;

                // If depth > 0 after decreasing,
                // this is NOT an outermost ')'
                if (depth > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}
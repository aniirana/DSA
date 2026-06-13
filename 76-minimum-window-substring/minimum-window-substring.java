class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>();

        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int count = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // If this character is needed
            if (need.containsKey(ch)) {

                if (need.get(ch) > 0) {
                    count--;
                }

                need.put(ch, need.get(ch) - 1);
            }

            // All characters found
            while (count == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (need.containsKey(leftChar)) {

                    need.put(leftChar, need.get(leftChar) + 1);

                    // We now miss one required character
                    if (need.get(leftChar) > 0) {
                        count++;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
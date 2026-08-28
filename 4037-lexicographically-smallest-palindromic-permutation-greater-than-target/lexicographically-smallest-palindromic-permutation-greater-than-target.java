class Solution {
    String ans = "";
    char middle = '#';
    int m;

    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];
        m = s.length() / 2;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                count++;
                middle = (char) ('a' + i);
            }
        }

        if (count > 1) {
            return "";
        }

        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        solve(0, half, new StringBuilder(), target,false);
        return ans;
    }

    public boolean solve(int idx, int[] half, StringBuilder left, String target, boolean greater) {

        if (idx == m) {

            String l = left.toString();

            StringBuilder temp = new StringBuilder();
            temp.append(l);

            if (middle != '#') {
                temp.append(middle);
            }

            temp.append(new StringBuilder(l).reverse());

            String pal = temp.toString();

            if (pal.compareTo(target) > 0) {
                ans = pal;
                return true;
            }

            return false;
        }

        char limit = target.charAt(idx);

        for (int i = 0; i < 26; i++) {

            if (half[i] == 0)
                continue;

            char ch = (char) ('a' + i);

            // Cannot become greater anymore
            if (!greater && ch < limit)
                continue;

            half[i]--;
            left.append(ch);

            boolean newGreater = greater || (ch > limit);

            if (solve(idx + 1, half, left, target, newGreater))
                return true;

            left.deleteCharAt(left.length() - 1);
            half[i]++;
        }

        return false;
    }
}
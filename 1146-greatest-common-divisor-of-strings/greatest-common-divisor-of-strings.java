class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len = gcd(str1.length(), str2.length());

        String ans = str1.substring(0, len);

        if (check(str1, ans) && check(str2, ans)) {
            return ans;
        }

        return "";
    }

    public boolean check(String s, String t) {
        int m = t.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i % m)) {
                return false;
            }
        }

        return true;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        String smallest = s;
        int n = s.length();

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (seen.contains(curr)) continue;
            seen.add(curr);

            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }

            // Operation 1: Add 'a' to digits at odd indices
            char[] chars = curr.toCharArray();
            for (int i = 1; i < n; i += 2) {
                int digit = (chars[i] - '0' + a) % 10;
                chars[i] = (char) (digit + '0');
            }
            String added = new String(chars);
            if (!seen.contains(added)) {
                queue.offer(added);
            }

            // Operation 2: Rotate to the right by 'b'
            String rotated = curr.substring(n - b) + curr.substring(0, n - b);
            if (!seen.contains(rotated)) {
                queue.offer(rotated);
            }
        }

        return smallest;
    }
}

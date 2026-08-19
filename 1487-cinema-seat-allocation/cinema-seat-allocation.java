import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rows = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                rows.put(row, rows.getOrDefault(row, 0) | (1 << col));
            }
        }

        int groups = (n - rows.size()) * 2;

        int leftBlock = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middleBlock = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int rightBlock = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int reserved : rows.values()) {
            boolean leftAvailable = (reserved & leftBlock) == 0;
            boolean rightAvailable = (reserved & rightBlock) == 0;

            if (leftAvailable && rightAvailable) {
                groups += 2;
            } else if (leftAvailable
                    || rightAvailable
                    || (reserved & middleBlock) == 0) {
                groups++;
            }
        }

        return groups;
    }
}
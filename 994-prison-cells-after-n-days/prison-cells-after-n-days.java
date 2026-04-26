class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {

        n = n % 14;
        if (n == 0) n = 14;

        for (int i = 0; i < n; i++) {
            int[] arr = new int[cells.length];

            for (int j = 1; j < cells.length - 1; j++) {
                arr[j] = (cells[j - 1] == cells[j + 1]) ? 1 : 0;
            }

            cells = arr;
        }

        return cells;
    }
}
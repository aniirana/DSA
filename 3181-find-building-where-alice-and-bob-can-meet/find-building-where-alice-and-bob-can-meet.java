class Solution {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;

        // stores index of maximum height
        int[] segTree = new int[4 * n];
        buildTree(0, 0, n - 1, segTree, heights);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int a = queries[i][0];
            int b = queries[i][1];

            int min = Math.min(a, b);
            int max = Math.max(a, b);

            if (min == max) {
                ans[i] = min;
                continue;
            }

            if (heights[max] > heights[min]) {
                ans[i] = max;
                continue;
            }

            int l = max + 1;
            int r = n - 1;
            int res = -1;

            while (l <= r) {

                int mid = l + (r - l) / 2;

                int idx = query(0, 0, n - 1, l, mid, segTree, heights);

                if (idx != -1 &&
                        heights[idx] > Math.max(heights[min], heights[max])) {

                    res = idx;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            ans[i] = res;
        }

        return ans;
    }

    // Build Segment Tree
    private void buildTree(int node, int l, int r,
                           int[] segTree, int[] heights) {

        if (l == r) {
            segTree[node] = l;
            return;
        }

        int mid = l + (r - l) / 2;

        buildTree(2 * node + 1, l, mid, segTree, heights);
        buildTree(2 * node + 2, mid + 1, r, segTree, heights);

        int leftIdx = segTree[2 * node + 1];
        int rightIdx = segTree[2 * node + 2];

        if (heights[leftIdx] >= heights[rightIdx])
            segTree[node] = leftIdx;
        else
            segTree[node] = rightIdx;
    }

    // Range Maximum Index Query
    private int query(int node, int start, int end,
                      int l, int r,
                      int[] segTree, int[] heights) {

        if (start > r || end < l)
            return -1;

        if (start >= l && end <= r)
            return segTree[node];

        int mid = start + (end - start) / 2;

        int left = query(2 * node + 1, start, mid, l, r, segTree, heights);
        int right = query(2 * node + 2, mid + 1, end, l, r, segTree, heights);

        if (left == -1)
            return right;

        if (right == -1)
            return left;

        return heights[left] >= heights[right] ? left : right;
    }
}
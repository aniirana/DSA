class Solution {

    static class Interval {
        int l, r, weight, index;

        Interval(int l, int r, int weight, int index) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.index = index;
        }
    }

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    Result[][] dp;
    int[] next;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();
        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort according to starting position
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);
            return Integer.compare(a.index, b.index);
        });

        // next[i] = first interval whose start > arr[i].r
        next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(arr[i].r);
        }

        dp = new Result[n][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    private Result solve(int i, int k) {

        if (i >= n || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // -------------------------
        // Option 1: Skip
        // -------------------------
        Result skip = solve(i + 1, k);

        // -------------------------
        // Option 2: Take
        // -------------------------
        Result nextResult = solve(next[i], k - 1);

        List<Integer> takeList =
            new ArrayList<>(nextResult.indices);

        takeList.add(arr[i].index);

        // Indices must be sorted for lexicographical comparison
        Collections.sort(takeList);

        Result take = new Result(
            arr[i].weight + nextResult.score,
            takeList
        );

        // Choose better result
        Result best;

        if (take.score > skip.score) {
            best = take;
        } else if (take.score < skip.score) {
            best = skip;
        } else {
            // Same score -> lexicographically smaller
            if (lexicographicallySmaller(take.indices, skip.indices)) {
                best = take;
            } else {
                best = skip;
            }
        }

        return dp[i][k] = best;
    }

    private int findNext(int end) {

        int low = 0;
        int high = n;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid].l > end) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean lexicographicallySmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int len = Math.min(a.size(), b.size());

        for (int i = 0; i < len; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}
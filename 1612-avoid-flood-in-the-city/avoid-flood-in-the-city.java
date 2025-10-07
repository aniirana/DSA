class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // Track which lakes are full, and the last day they were filled
        Map<Integer, Integer> lakeFullDay = new HashMap<>();
        // Track indices of dry days
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; ++i) {
            int lakeId = rains[i];
            if (lakeId == 0) {
                dryDays.add(i);
                ans[i] = 1; // placeholder, will be updated if actually used to dry a lake
            } else {
                if (lakeFullDay.containsKey(lakeId)) {
                    Integer dryDay = dryDays.higher(lakeFullDay.get(lakeId));
                    if (dryDay == null) return new int[0];
                    ans[dryDay] = lakeId;
                    dryDays.remove(dryDay);
                }
                lakeFullDay.put(lakeId, i);
            }
        }
        return ans;
    }
}
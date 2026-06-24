class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {

        Deque<Integer> dq = new LinkedList<>();
        int[] list = new int[arr.length - k + 1];

        int s = 0;
        int e = 0;
        int idx = 0;

        while (e < arr.length) {

            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[e]) {
                dq.pollLast();
            }

            dq.offerLast(e);

            if (e - s + 1 < k) {
                e++;
            }
            else if (e - s + 1 == k) {

                if (dq.peekFirst() < s) {
                    dq.pollFirst();
                }

                list[idx++] = arr[dq.peekFirst()];

                s++;
                e++;
            }
        }

        return list;
    }
}
class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        if(freq.containsKey(1L)){
            int ones=freq.get(1L);
            if(ones%2==0){
                ans=Math.max(ones-1,ans);
            }
            else{
                ans=Math.max(ans,ones);
            }
        }

       for(long start:freq.keySet()){
        if(start==1){
            continue;
        }
        long current=start;
        int len=0;

        while(freq.containsKey(current) && freq.get(current)>=2){
            len+=2;
            if (current > 1000000000L) break; 
            current=current*current;
        }

        if(freq.containsKey(current)){
            len++;
        }
        else{
            len--;
        }
        ans=Math.max(ans,len);
       }
    return ans;
    }
}
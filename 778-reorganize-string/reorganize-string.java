class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                pq.offer(new int[]{i,freq[i]});
            }

        }
        StringBuilder ans=new StringBuilder();
        int[] prev=null;
        while(!pq.isEmpty()){
            int cur[]=pq.poll();
            char ch=(char)(cur[0]+'a');
            

            
               ans.append(ch);
                
                cur[1]--;
                
                
            

            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }

            prev=cur;

        }

        if (ans.length() != s.length()) {
            return "";
        }

        return ans.toString();
        
    }
}
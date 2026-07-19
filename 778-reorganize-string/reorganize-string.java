class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        int[] freq=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                pq.offer(new int[]{i,freq[i]});
            }
        }

        int[] prev=null;
        StringBuilder sb=new StringBuilder();
        
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            char ch=(char)(curr[0]+'a');
            sb.append(ch);
            curr[1]--;

            if(prev!=null && prev[1]>0){
                pq.offer(prev);
            }

            prev=curr;

        }

        if(sb.length() != s.length()){
            return "";
        }

        return sb.toString();
        
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            
            map.put(s.charAt(i),i);
        }

        int pend=0;
        int pstart=0;
        for(int i=0;i<n;i++){
            pend=Math.max(pend,map.get(s.charAt(i)));

            if(i==pend){
                ans.add(pend-pstart+1);
                pstart=i+1;
            }
            
        }
        return ans;
    }
}
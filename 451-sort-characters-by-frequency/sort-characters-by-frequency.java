class Solution {
    public String frequencySort(String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
           
            map.put(ch,map.getOrDefault(ch,0)+1);
            
        }
     
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b) -> b.getValue() - a.getValue());


        for(Map.Entry<Character,Integer> entry:list){
            int val=entry.getValue();
            while(val>0){
                sb.append(entry.getKey());
                val--;
            }
        }

        return sb.toString();
    }
}
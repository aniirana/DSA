class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        if(n<k){
            return false;
        }

        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int count=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()%2!=0){
                count++;
            }

            
        }

        if(count>k){
            return false;
        }


        return true;
        
    }
}
class Solution {
    HashMap<String,Boolean> map=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }

        return solve(s1,s2);
    }

    public boolean solve(String s1,String s2){
        int m=s1.length();
        int n=s2.length();


        if(s1.equals(s2)){
            return true;
        }

        String key=s1+"#"+s2;

        if(map.containsKey(key)){
            return map.get(key);
        }
        for(int k=1;k<n;k++){
            boolean swap=(solve(s1.substring(0,k),s2.substring(n-k))
                        &&
                        solve(s1.substring(k),s2.substring(0,n-k)));

            boolean noswap=(solve(s1.substring(0,k),s2.substring(0,k))
                            &&
                            solve(s1.substring(k),s2.substring(k)));

            if(swap || noswap){
                map.put(key,true);
                return true;
            }
        }

        map.put(key,false);
        return false;
    }
}
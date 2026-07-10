class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();

        int i=0;
       

        int maxlen=0;

        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);

            while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }

            set.add(ch);
            maxlen=Math.max(maxlen,j-i+1);
        }

        return maxlen;
        
    }
}
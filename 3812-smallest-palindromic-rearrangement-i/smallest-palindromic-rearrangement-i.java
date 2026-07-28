class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        if(n==1) return s;
        int[] freq=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            int times=freq[i]/2;

            while(times-- >0){
                sb.append((char)(i+'a'));
            }
        }

        StringBuilder right=new StringBuilder(sb).reverse();

        StringBuilder middle=new StringBuilder();
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                middle.append((char)(i+'a'));
            }
        }

        return sb.toString() + middle.toString() + right.toString();
    }
}
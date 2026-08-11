class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        StringBuilder sb=new StringBuilder();

        int i=0;
        int j=0;
        boolean flag=true;
        while(i<m && j<n){
            if(flag){
                sb.append(word1.charAt(i));
                i++;
                flag= false;
            }else{
                sb.append(word2.charAt(j));
                j++;
                flag=true;
            }
        }

        while(i<m){
            sb.append(word1.charAt(i));
            i++;
        }

        while(j<n){
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}
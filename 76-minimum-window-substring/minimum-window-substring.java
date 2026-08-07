class Solution {
    public String minWindow(String s, String t) {
        //freq array method will be used here 
        int m = s.length();
        int n = t.length();
        int[] freq = new int[128];

        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            freq[ch]++;
        }
        int left = 0;
        int count = n;
        int start=0;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);

            if(freq[ch]>0){
                count--;
            }
            freq[ch]--;

            while(count==0){
                if(i-left+1<len){
                    len=i-left+1;
                    start=left;
                }

                char lchar=s.charAt(left);
                freq[lchar]++;
                if(freq[lchar]>0){

                    count++;
                }
                left++;
            }
        }

        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
class Solution {
    public int minimumPushes(String word) {
        int[] freq=new int[26];
        int n=word.length();

        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            freq[ch-'a']++;
        }
        Arrays.sort(freq);

        int count=0;
        int val=1;
        int ans=0;
        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;

            if(count==8){
                val++;
                count=0;
            }

            ans+=(freq[i]*val);
            freq[i]=0;
            count++;

            

        }
        return ans;
    }
}
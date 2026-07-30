class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        
        int ans=0;
        int cnt=0;
        int cost=1;
        int[] freq=new int[26];

        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            freq[ch-'a']++;
        }

        Arrays.sort(freq);

        for(int i=25;i>=0;i--){
            if(freq[i]==0) break;

            ans+=freq[i]*cost;
            cnt++;


            if(cnt==8){
                cost++;
                cnt=0;
            }
        }
        return ans;
    }
}
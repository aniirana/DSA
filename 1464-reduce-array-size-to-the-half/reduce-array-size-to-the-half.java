class Solution {
    public int minSetSize(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int target=n/2;
        int ans=0;
        int removed=0;
        int[] bucket=new int[n+1];
        
        for(int i:map.values()){
            bucket[i]++;
        }

        for(int freq=n;freq>=1;freq--){
            while(bucket[freq]>0 && removed<target){
                removed+=freq;
                ans++;
                bucket[freq]--;
            }
        }
        return ans;
    }
}
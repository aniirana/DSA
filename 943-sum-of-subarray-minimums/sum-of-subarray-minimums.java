class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> st=new Stack<>();
        //next smaller right      
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
               
                left[i]=n;
            }
            else{
                left[i]=st.peek();
            }
            st.push(i);

        }  
        st.clear();
        //now next smaller left
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]=-1;
            }
            else{
                right[i]=st.peek();
            }
            st.push(i);
        }

        long ans=0;
        long MOD = 1_000_000_007;
        for(int i=0;i<n;i++){
            long leftCount = i - right[i];
            long rightCount = left[i] - i;

           ans = (ans + ((long)arr[i] * leftCount * rightCount) % MOD) % MOD;

        }
        return (int)ans;
    }
}
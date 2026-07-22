class Solution {
    public boolean find132pattern(int[] nums) {
        int n=nums.length;

        Stack<Integer> st=new Stack<>();
        int third=Integer.MIN_VALUE;
        int prevlarg=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            prevlarg=Math.max(prevlarg,nums[i]);
            if(st.isEmpty()){
                st.push(nums[i]);
            }

            while(!st.isEmpty() && st.peek()<nums[i]){
                third=Math.max(third,st.pop());
            }

            if(nums[i]<third && third<prevlarg){
                return true;
            }

            st.push(nums[i]);    
        }

        return false;

    }
}
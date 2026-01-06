class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] leftsmaller=new int[n];
        int[] rightsmaller=new int[n];

        Stack<Integer> st=new Stack<>();

        //next smaller right
        for(int i=n-1;i>=0;i--){
            int currele=heights[i];

            while(!st.isEmpty() && heights[st.peek()]>=currele){
                st.pop();
            }

            
            rightsmaller[i]=st.isEmpty()?n:st.peek();
            

            st.push(i);
        }

            st.clear();
        //next smaller left
        for(int i=0;i<n;i++){
            int currele=heights[i];

            while(!st.isEmpty() && heights[st.peek()]>=currele){
                st.pop();

            }

            leftsmaller[i]=st.isEmpty()?-1:st.peek();

            st.push(i);
        }

        int maxarea=0;

        for(int i=0;i<n;i++){
            int width=rightsmaller[i]-leftsmaller[i]-1;
            int area=width*heights[i];

            maxarea=Math.max(maxarea,area);
        }


        return maxarea;
    }
}
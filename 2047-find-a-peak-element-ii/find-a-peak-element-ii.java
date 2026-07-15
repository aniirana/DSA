class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length;
        int low=0;
        int col=mat[0].length;
        int high=col-1;
        int[] ans=new int[2];
        while(low<=high){
            int mid=low+(high-low)/2;
            int max=0;
            for(int i=1;i<row;i++){
                if(mat[i][mid]>mat[max][mid]){
                    max=i;
                }
            }
            int current=mat[max][mid];

            int left = (mid == 0) ? -1 : mat[max][mid - 1];
            int right = (mid == col - 1) ? -1 : mat[max][mid + 1];
            
            if(current>left && current>right){
                return new int[]{max,mid};
            }

            if(current>left){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
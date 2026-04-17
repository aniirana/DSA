class Solution {
    public void dfs(int[][] image,int[][] ans,int sr,int sc,int color,int[] delrow,int[] delcol,int inicolor){
        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;

        for(int i=0;i<4;i++){
            int nrow=sr+delrow[i];
            int ncol=sc+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==inicolor && ans[nrow][ncol]!=color){
                dfs(image,ans,nrow,ncol,color,delrow,delcol,inicolor);
            }

        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans =image;
        int inicolor=image[sr][sc];
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        dfs(image,ans,sr,sc,color,delrow,delcol,inicolor);
        return ans;
        
    }
}
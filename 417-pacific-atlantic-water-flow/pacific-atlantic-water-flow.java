class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        List<List<Integer>> ans =new ArrayList<>();

        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(i,0,heights[i][0],heights,pacific);
        } 

        for(int j=0;j<n;j++){
            dfs(0,j,heights[0][j],heights,pacific);
        }

        for(int i=0;i<m;i++){
            dfs(i,n-1,heights[i][n-1],heights,atlantic);
        } 

        for(int j=0;j<n;j++){
            dfs(m-1,j,heights[m-1][j],heights,atlantic);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                   ans.add(Arrays.asList(i,j));
                }
            }
            
        }
        return ans;
        
    }

    public void dfs(int r,int c,int prevheight,int[][] heights,boolean[][] vis){
        int m=heights.length;
        int n=heights[0].length;
        if(r<0 || r>=m || c<0 || c>=n || vis[r][c] || prevheight>heights[r][c]){
            return;
        }

        vis[r][c]=true;

        dfs(r+1,c,heights[r][c],heights,vis);
        dfs(r-1,c,heights[r][c],heights,vis);
        dfs(r,c+1,heights[r][c],heights,vis);
        dfs(r,c-1,heights[r][c],heights,vis);

       
    }
}
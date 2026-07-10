class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int len=word.length();
        int[][] vis=new int[m][n];

        //dfs+backtrack krna hai mujhe 
        //bt ke liye recurse then add then remove 
       for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j,vis,board,0,word)) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean dfs(int r,int c,int[][] vis,char[][] board,int index,String word){
        int m=board.length;
        int n=board[0].length;
        char ch=word.charAt(index);
       
        if(r<0 || r>=m || c<0 || c>=n || vis[r][c]==1 || board[r][c]!=ch){
            return false;
        }

        if(index==word.length()-1){
            return true;
        }

         vis[r][c]=1;

        //recurse
       boolean found = dfs(r+1,c,vis,board,index+1,word) ||
                    dfs(r-1,c,vis,board,index+1,word) ||
                    dfs(r,c+1,vis,board,index+1,word) ||
                    dfs(r,c-1,vis,board,index+1,word);

        //bt
        vis[r][c]=0;

        return found;
    }
}
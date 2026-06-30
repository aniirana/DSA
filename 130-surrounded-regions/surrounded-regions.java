class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        boolean[][] visited=new boolean[m][n]; 
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(board,visited,0,i);
            }

            if(board[m-1][i]=='O'){
                dfs(board,visited,m-1,i);
            }
            
        }

        for(int j=0;j<m;j++){
            if(board[j][0]=='O'){
                dfs(board,visited,j,0);
            }

            if(board[j][n-1]=='O'){
                dfs(board,visited,j,n-1);

            }
            
           
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }
        
    }

    public void dfs(char[][] board,boolean[][] visited,int r,int c){
        if(r<0 || r>=board.length || c<0 ||c>=board[0].length || visited[r][c] || board[r][c]=='X'){
            return;
        }
        
        visited[r][c]=true;

        dfs(board,visited,r-1,c);
        dfs(board,visited,r+1,c);
        dfs(board,visited,r,c-1);
        dfs(board,visited,r,c+1);
    }
}
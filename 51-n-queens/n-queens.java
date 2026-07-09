class Solution {
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board=new int[n][n];
        solve(n,0,board);

        return ans;
    }

    public void solve(int n,int col,int[][] board){
        if (col == n) {

            List<String> curr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1)
                        sb.append('Q');
                    else
                        sb.append('.');
                }

                curr.add(sb.toString());
            }

            ans.add(curr);
            return;
        }


        for(int row=0;row<n;row++){

            if(check(row,col,board)){
                board[row][col]=1;
                
                solve(n,col+1,board);

              
                board[row][col]=0;
                

            }
            
        }
    }

    public boolean check(int row,int col,int[][] board){
        //check left
        for(int i=col;i>=0;i--){
            if(board[row][i]==1){
                return false;
            }
        }

        //check diag1
        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(board[i][j]==1){
                return false;
            }
            i-=1;
            j-=1;
        }


        //check diag2
        int m=row;
        int n=col;
        while(m<board.length && n>=0){
            if(board[m][n]==1){
                return false;
            }
            m+=1;
            n-=1;
        }

        return true;
    }
}
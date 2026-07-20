/*
Pattern: Constraint Backtracking

Time: O(N!)
Space: O(N²) + O(N) recursion stack

Idea:
- Place exactly one queen in each row.
- For the current row, try every column.
- A position is valid if:
    • No queen exists in the same column.
    • No queen exists on the upper-left diagonal.
    • No queen exists on the upper-right diagonal.
- If valid, place the queen and recurse for the next row.
- Backtrack by removing the queen to explore other configurations.
*/

class Solution {
    public boolean helper2(char[][] board, int row, int column, int n){
        for(int i=0; i<row; i++){
            if(board[i][column]=='Q'){
                return false;
            }
        }
        int r=row;
        int c=column;
        while(r!=0 && c!=0){
            r--;
            c--;
            if(board[r][c]=='Q'){
                return false;
            }
        }
        r=row;
        c=column;
        while(r!=0 && c!=(n-1)){
            r--;
            c++;
            if(board[r][c]=='Q'){
                return false;
            }
        }
        return true;
    }
    public void helper(List<List<String>> list, char[][] board, int row, int n){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(int i=0; i<n; i++){
                temp.add(new String(board[i]));
            }
            list.add(new ArrayList(temp));
            return;
        }
        for(int i=0; i<n; i++){
            if(helper2(board, row, i, n)){
                board[row][i]='Q';
                helper(list, board, row+1, n);
                board[row][i]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        char[][] board=new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        helper(list, board, 0, n);
        return list;
    }
}
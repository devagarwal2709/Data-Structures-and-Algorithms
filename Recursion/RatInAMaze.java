/*
Pattern: Grid DFS + Backtracking

Time: O(4^(N²)) (worst case)
Space: O(N²) recursion stack + path

Idea:
- Start DFS from (0,0).
- Explore all four directions (D, L, R, U).
- Skip blocked, visited, or out-of-bounds cells.
- Mark the current cell as visited before recursion.
- Append the move to the current path.
- Backtrack by removing the move and restoring the cell.
- When the destination is reached, store the current path.
*/

class Solution {
    public void helper(List<String> list, StringBuilder temp, int[][] maze, int row, int column){
        if(row<0 || row>=maze.length || column<0 || column>=maze[0].length || maze[row][column]!=1){
            return;
        }
        if(row==maze.length-1 && column==maze[0].length-1){
            list.add(temp.toString());
            return;
        }
        int t1=maze[row][column];
        maze[row][column]=2;
        temp.append('D');
        helper(list, temp, maze, row+1, column);
        temp.setLength(temp.length()-1);
        temp.append('L');
        helper(list, temp, maze, row, column-1);
        temp.setLength(temp.length()-1);
        temp.append('R');
        helper(list, temp, maze, row, column+1);
        temp.setLength(temp.length()-1);
        temp.append('U');
        helper(list, temp, maze, row-1, column);
        temp.setLength(temp.length()-1);
        maze[row][column]=t1;
    }
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> list=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        helper(list, temp, maze, 0, 0);
        return list;
    }
}
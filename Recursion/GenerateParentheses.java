/*
Pattern:
Backtracking + Decision Tree + Constraint Pruning

Time:
O(4^n / √n)   // Catalan number growth

Space:
O(n) recursion stack (excluding output)

Idea:
Build the string one character at a time.
Track the number of '(' and ')' placed.
Only place '(' if openings remain.
Only place ')' if it won't make the prefix invalid (close < open).
Backtrack after every choice.
*/

class Solution {
    public void helper(ArrayList<String> list, StringBuilder temp, int index, int n, int x, int y){
        if(index==n){
            list.add(temp.toString());
            return;
        }
        if(x<(n/2)){
            temp.append('(');
            helper(list, temp, index+1, n, x+1, y);
            temp.setLength(temp.length()-1);
        }
        if(x>y){
            temp.append(')');
            helper(list, temp, index+1, n, x, y+1);
            temp.setLength(temp.length()-1); 
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        helper(list, temp, 0, n*2, 0, 0);
        return list;
    }
}
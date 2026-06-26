/*
Pattern: Balanced Parentheses + String Traversal

Time: O(n)
Space: O(n)

Idea:
Traverse the string while maintaining a balance count.
Whenever balance becomes 0, one primitive valid parentheses
string has ended. Append only its inner part (excluding the
first '(' and last ')') to the answer using StringBuilder.
*/

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans= new StringBuilder();
        int vote=0;
        int start=1;
        for(int i=0;  i<s.length(); i++){
            if(s.charAt(i)=='('){
                vote++;
            }
            else if(s.charAt(i)==')'){
                vote--;
            }
            if(vote==0){
                ans.append(s.substring(start, i));
                start=i+2;
            }
        }
        return ans.toString();
    }
}
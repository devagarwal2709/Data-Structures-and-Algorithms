/*
Pattern: Valid Parentheses — Stack Matching

Time: O(n)
Space: O(n)

Idea:
Push opening brackets onto the stack.
For every closing bracket, the stack top must be
its matching opening bracket.

*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }
            else{
                if(ch==')'){
                    if(st.isEmpty() || st.peek()!='('){
                        return false;
                    }
                    st.pop();
                }
                else if(ch=='}'){
                    if(st.isEmpty() || st.peek()!='{'){
                        return false;
                    }
                    st.pop();
                }
                else if(ch==']'){
                    if(st.isEmpty() || st.peek()!='['){
                        return false;
                    }
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
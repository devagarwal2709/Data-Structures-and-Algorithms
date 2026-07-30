/*
Pattern: Prefix to Infix — Expression Stack

Time: O(n) stack operations
Space: O(n)

Idea:
Scan prefix from right to left.
Push operands as strings.

For an operator:
- Pop two expressions a and b.
- Combine as: (a operator b)
- Push the complete expression back.

Final stack top is the infix expression.
*/

class Solution {
    static String preToInfix(String s) {
        Stack<String> st=new Stack<>();
        for(int i=s.length()-1; i>=0; i--){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String a=st.pop();
                String b=st.pop();
                String c="("+a+ch+b+")";
                st.push(c);
            }
        }
        return st.peek();
    }
}

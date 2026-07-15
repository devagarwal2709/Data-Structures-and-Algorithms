/*
Pattern:
Recursion + Recursive Insertion

Time:
O(n²)

Space:
O(n)

Idea:
Pop one element recursively until the stack becomes empty.
While backtracking, insert each popped element into its correct
position in the already sorted stack using another recursive helper.
*/

class Solution {
    public void helper(int store, Stack<Integer> st){
        if(st.isEmpty()){
            st.push(store);
            return;
        }
        int x=st.peek();
        if(store>x){
            st.push(store);
        }
        else{
            st.pop();
            helper(store, st);
            st.push(x);
        }
    }
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }
        int store=st.pop();
        sortStack(st);
        helper(store, st);
    }
}
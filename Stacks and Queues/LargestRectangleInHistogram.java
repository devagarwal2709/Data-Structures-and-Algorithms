/*
Pattern: Monotonic Stack + Boundary Expansion

Time:
O(n)

Space:
O(n)

Idea:
Treat each bar as the limiting height of a rectangle.
Use monotonic stacks to find the previous and next
smaller bar, giving the maximum width over which the
current bar can extend. Compute area as width × height
and take the maximum.
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int[] a=new int[heights.length];
        for(int i=heights.length-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                a[i]=heights.length;
            }
            else{
                a[i]=st.peek();
            }
            st.push(i);
        }
        Stack<Integer> st1=new Stack<>();
        int[] b=new int[heights.length];
        for(int i=0; i<heights.length; i++){
            while(!st1.isEmpty() && heights[st1.peek()]>heights[i]){
                st1.pop();
            }
            if(st1.isEmpty()){
                b[i]=-1;
            }
            else{
                b[i]=st1.peek();
            }
            st1.push(i);
        }
        int max=0;
        for(int i=0; i<heights.length; i++){
            int area=((a[i]-i)+(i-b[i]-1))*heights[i];
            max=Math.max(max, area);
        }
        return max;
    }
}
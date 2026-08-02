/*
Pattern: Stack Simulation

Time:
O(n)

Space:
O(n)

Idea:
Traverse asteroids from left to right using a stack of
surviving asteroids. A collision occurs only when a
right-moving asteroid is followed by a left-moving one.
Resolve chain collisions by removing smaller asteroids
until the current asteroid is destroyed or safely survives.
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<asteroids.length; i++){
            if(st.isEmpty()){
                st.push(asteroids[i]);
            }
            else if(asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{
                if(st.peek()<0){
                    st.push(asteroids[i]);
                    continue;
                }
                while(!st.isEmpty() && st.peek()>0 && -1*asteroids[i]>st.peek()){
                    st.pop();
                }
                if(!st.isEmpty() && -1*asteroids[i]==st.peek()){
                    st.pop();
                    continue;
                }
                if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }
            }
        }
        int[] arr=new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            arr[i]=st.pop();
        }
        return arr;
    }
}
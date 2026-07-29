/*
Pattern: Min Stack — Value Encoding

Time: O(1) for push, pop, top, getMin
Space: O(n) stack + O(1) auxiliary

Idea:
Keep the current minimum in a variable.
When a new minimum x arrives, store (2*x - oldMin)
as an encoded marker and update min = x.
If stackTop < min, it is encoded:
- Actual top = min
- Previous min = 2*min - stackTop
Use long to prevent overflow during encoding.

*/

class MinStack {
    Stack<Long> st;
    long min=0;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push((long)value);
            min=value;
        }
        else if(value<min){
            st.push((long)(2*(long)value)-min);
            min=value;
        }
        else{
            st.push((long)value);
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        if(st.peek()<min){
            min=2*min-st.peek();
        }
        st.pop();
    }
    
    public int top() {
        if(st.isEmpty()){
            return -1;
        }
        if(min>st.peek()){
            return (int)min;
        }
        long x=st.peek();
        return (int)x;
    }
    
    public int getMin() {
        if(st.isEmpty()){
            return -1;
        }
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
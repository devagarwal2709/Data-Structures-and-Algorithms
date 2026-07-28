/*
Pattern: Queue Using Two Stacks

Time:
push: O(1)
pop: O(n)
peek: O(n)
empty: O(1)

Space: O(n)

Idea:
Use one stack for storage.
For pop/peek, transfer elements to the second stack
to reverse the order, access the queue front,
then transfer everything back.
*/

class MyQueue {
    Stack<Integer> st;
    Stack<Integer> temp;
    public MyQueue() {
        st=new Stack<>();
        temp=new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        while(!st.isEmpty()){
            int store=st.pop();
            temp.push(store);
        }
        int ans=temp.pop();
        while(!temp.isEmpty()){
            int store=temp.pop();
            st.push(store);
        }
        return ans;
    }
    
    public int peek() {
        if(empty()){
            return -1;
        }
        while(!st.isEmpty()){
            int store=st.pop();
            temp.push(store);
        }
        int ans=temp.peek();
        while(!temp.isEmpty()){
            int store=temp.pop();
            st.push(store);
        }
        return ans;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
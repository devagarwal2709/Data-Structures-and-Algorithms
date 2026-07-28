/*
Pattern: Stack Using Single Queue

Time:
push: O(1)
pop: O(n)
top: O(n)
empty: O(1)

Space: O(n)

Idea:
Store elements in normal queue order.
For pop/top, rotate elements from front to rear
until the most recently pushed element reaches the front.
*/

class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q=new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.offer(x);
    }
    
    public int pop() {
        if(empty()){
            return -1;
        }
        for(int i=0; i<q.size()-1; i++){
            int store=q.poll();
            q.offer(store);
        }
        return q.poll();
    }
    
    public int top() {
        if(empty()){
            return -1;
        }
        int store=0;
        for(int i=0; i<q.size(); i++){
            store=q.poll();
            q.offer(store);
        }
        return store;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
/*
Pattern: LFU Cache (HashMap + Doubly Linked Lists)

Time:
get: O(1)
put: O(1)

Space: O(capacity)

Idea:
Maintain a HashMap(key → Node) for O(1) lookup.
Maintain a HashMap(freq → DLL), where each frequency
has its own LRU list.
On every access/update:
- Remove node from current frequency DLL.
- Increase its frequency.
- Insert into the tail of the next frequency DLL.
Track minFreq to evict the least frequently used key.
If multiple keys have the same frequency,
evict the Least Recently Used (LRU) among them.
*/

class Node{
    int data;
    int value;
    int freq;
    Node prev;
    Node next;
    Node(int d, int v){
        data=d;
        value=v;
        freq=1;
        prev=null;
        next=null;
    }
}
class DLL{
    Node head;
    Node tail;
    int size;
    DLL(){
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        size=0;
    }
    public void insertAtTail(Node x){
        tail.prev.next=x;
        x.prev=tail.prev;
        x.next=tail;
        tail.prev=x;
        size++;
    }
    public void deleteNode(Node x){
        x.prev.next=x.next;
        x.next.prev=x.prev;
        size--;
    }
}
class LFUCache {
    HashMap<Integer,Node> map=new HashMap<>();
    HashMap<Integer,DLL> temp=new HashMap<>();
    int x;
    int minfreq;
    public LFUCache(int capacity) {
        minfreq=Integer.MAX_VALUE;
        x=capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node a=map.get(key);
            DLL dll=temp.get(a.freq);
            dll.deleteNode(a);
            if(dll.size == 0){
                temp.remove(a.freq);
                if(a.freq==minfreq){
                    minfreq++;
                }
            }
            a.freq++;
            freqUpdate(a);
            return a.value;
        }
        else{
            return -1;
        }
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node a=map.get(key);
            a.value=value;
            DLL dll=temp.get(a.freq);
            dll.deleteNode(a);
            if(dll.size == 0){
                temp.remove(a.freq);
                if(a.freq==minfreq){
                    minfreq++;
                }
            }
            a.freq++;
            freqUpdate(a);
            return;
        }
        else if(map.size()==x){
            DLL dll=temp.get(minfreq);
            map.remove(dll.head.next.data);
            dll.deleteNode(dll.head.next);
            if(dll.size == 0){
                temp.remove(minfreq);
            }
        }
        Node a=new Node(key, value);
        map.put(key, a);
        freqUpdate(a);
        minfreq=1;
    }
    public void freqUpdate(Node a){
        if(temp.containsKey(a.freq)){
            DLL dll=temp.get(a.freq);
            dll.insertAtTail(a);
        }
        else{
            DLL dll=new DLL();
            temp.put(a.freq, dll);
            dll.insertAtTail(a);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
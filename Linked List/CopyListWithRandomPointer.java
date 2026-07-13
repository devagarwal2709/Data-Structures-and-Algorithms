/*
Pattern:
Clone Linked List with Random Pointer (HashMap)

Time:
O(n)

Space:
O(n)

Idea:
Create a copy of every node while storing a mapping from
original node -> copied node.
In the second pass, use the mapping to assign random pointers.
*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map=new HashMap<>();
        Node temp1=head;
        Node dummy=new Node(0);
        Node temp=dummy;
        while(temp1!=null){
            temp.next=new Node(temp1.val);
            temp=temp.next;
            map.put(temp1, temp);
            temp1=temp1.next;
        }
        temp=dummy.next;
        temp1=head;
        while(temp1!=null){
            if(temp1.random==null){
                temp.random=null;
            }
            else{
                temp.random=map.get(temp1.random);
            }
            temp=temp.next;
            temp1=temp1.next;
        }
        return dummy.next;
    }
}
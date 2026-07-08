/*
Pattern: Doubly Linked List - Pointer Reversal

Time: O(n)
Space: O(1)

Idea:
Traverse to the tail. Starting from the tail, swap each node's
next and prev pointers while moving towards the original head.
The original tail becomes the new head.
*/

/* Structure of doubly linked list node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        Node temp = head;
        int i=1;
        while(temp.next!=null){
            temp=temp.next;
            i++;
        }
        Node a = temp;
        if(i==1){
            return head;
        }
        temp.next=temp.prev;
        temp.prev=null;
        temp=temp.next;
        while(temp.prev!=null){
            Node ptr = temp.next;
            temp.next=temp.prev;
            temp.prev=ptr;
            temp=temp.next;
        }
        temp.prev=temp.next;
        temp.next=null;
        return a;
    }
}
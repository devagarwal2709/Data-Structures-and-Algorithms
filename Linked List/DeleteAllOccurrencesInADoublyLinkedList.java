/*
Pattern:
Doubly Linked List Deletion

Time:
O(n)

Space:
O(1)

Idea:
Traverse the DLL while saving the next node before modifying links.
If the current node matches the key:
- Update previous node's next pointer.
- Update next node's prev pointer.
- Update head if deleting the first node.
Continue traversal using the saved next node.
*/

/* Structure of Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp=head;
        Node save;
        while(temp!=null){
            save=temp.next;
            if(temp.data==x){
                if(temp.next!=null){
                    temp.next.prev=temp.prev;
                }
                if(temp.prev!=null){
                    temp.prev.next=temp.next;    
                }
                if(temp==head){
                    head=head.next;
                }
            }
            temp=save;
        }
        return head;
    }
}
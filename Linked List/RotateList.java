/*
Pattern:
Rotate Linked List (Three-Reversal Approach)

Time:
O(n)

Space:
O(1)

Idea:
Reverse the entire list, then reverse the first k nodes,
then reverse the remaining nodes, and reconnect them.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head, int k){
        ListNode prev=null;
        ListNode current=head;
        ListNode after=null;
        int a=0;
        while(current!=null && a<k){
            after=current.next;
            current.next=prev;
            prev=current;
            current=after;
            a++;
        }
        return prev;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp1=head;
        int length=0;
        while(temp1!=null){
            temp1=temp1.next;
            length++;
        }
        k=k%length;
        if(k==0){
            return head;
        }
        temp1=reverse(head, length);
        ListNode pass=temp1;
        int a=0;
        while(a<k){
            pass=pass.next;
            a++;
        }
        ListNode temp2=reverse(temp1, k);
        ListNode temp3=reverse(pass, length-k);
        temp1.next=temp3;
        return temp2;
    }
}
/*
Pattern:
Reverse Nodes in K-Group

Time:
O(n)

Space:
O(1)

Idea:
Reverse each complete group of k nodes in-place.
Reconnect consecutive reversed groups while leaving any remaining
nodes (< k) unchanged.
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
    public ListNode helper(ListNode head, ListNode pass, int k){
        ListNode prev=null;
        ListNode current=head;
        ListNode after=null;
        int b=0;
        while(b<k && current!=null){
            after=current.next;
            current.next=prev;
            prev=current;
            current=after;
            b++;
        }
        if(pass!=null){
            pass.next=prev;
        }
        return after;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int length=0;
        ListNode temp=head;
        ListNode ans=temp;
        while(temp!=null){
            if(length==k-1){
                ans=temp;
            }
            temp=temp.next;
            length++;
        }
        int x=length/k;
        int a=0;
        ListNode temp1=helper(head, null, k);
        ListNode pass=head;
        ListNode temp2;
        while(a<(x-1)){
            temp2=helper(temp1, pass, k);
            pass=temp1;
            temp1=temp2;
            a++;
        }
        pass.next=temp1;
        return ans;
    }
}
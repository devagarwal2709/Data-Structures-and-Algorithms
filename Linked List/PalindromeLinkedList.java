/*
Pattern: Slow & Fast Pointer + Reverse Second Half

Time: O(N)
Space: O(1)

Idea:
Find the middle using slow and fast pointers.
Reverse the second half of the list.
Compare the first half with the reversed second half node by node.
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode before=null;
        ListNode current=slow;
        ListNode after=null;
        while(current!=null){
            after=current.next;
            current.next=before;
            before=current;
            current=after;
        }
        while(before!=null){
            if(head.val!=before.val){
                return false;
            }
            head=head.next;
            before=before.next;
        }
        return true;
    }
}
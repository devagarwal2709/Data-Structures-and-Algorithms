/*
Pattern: Two Pointer Chains (Odd-Even Reordering)

Time: O(N)
Space: O(1)

Idea:
Maintain separate odd and even chains while traversing.
Reconnect odd nodes together, reconnect even nodes together,
then attach the even chain after the odd chain.
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode odd=head;
        ListNode even=odd.next;
        ListNode ans=even;
        while(even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=ans;
        return head;
    }
}
/*
Pattern: Slow and Fast Pointer (Tortoise and Hare)

Time: O(n)
Space: O(1)

Idea:
Move slow by one node and fast by two nodes.
When fast reaches the end (or cannot move two steps),
slow will be at the middle of the linked list.
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if(fast.next==null){
            return slow;
        }
        else{
            return slow.next;
        }
    }
}
/*
Pattern:
Two Pointers

Time:
O(n + m)

Space:
O(1)

Idea:
Traverse both lists simultaneously.
When a pointer reaches null, redirect it to the head of the other list.
Both pointers traverse exactly (lengthA + lengthB), automatically canceling the length difference.
They meet at the intersection node or both become null.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(true){
            if(tempA==tempB){
                return tempA;
            }
            else if(tempA==null){
                tempA=headB;
            }
            else if(tempB==null){
                tempB=headA;
            }
            else{
                tempA=tempA.next;
                tempB=tempB.next;
            }
        }
    }
}
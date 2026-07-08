/*
Pattern: Delete Node (Given Only Node)

Time: O(1)
Space: O(1)

Idea:
Copy the next node's value into the current node,
then bypass the next node.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
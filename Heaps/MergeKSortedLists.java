/*
Pattern: Min Heap + K-Way Merge

Time: O(N log K)

Space: O(K)

Idea:

Keep the smallest current node from each linked list in a Min Heap.

Poll the smallest node, attach it directly to the result,
then push its next node into the heap.

Reuse the existing ListNode objects instead of creating new nodes.
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=new ListNode();
        ListNode temp=ans;
        PriorityQueue<ListNode> pq=new PriorityQueue<>(
            (a,b) -> a.val-b.val
        );
        for(int i=0; i<lists.length; i++){
            if(lists[i]!=null){
                pq.offer(lists[i]);
                lists[i]=lists[i].next;
            }
        }
        while(pq.size()!=0){
            ListNode current=pq.poll();
            temp.next=current;
            temp=temp.next;
            if(current.next!=null){
                pq.offer(current.next);
                current=current.next;
            }
        }
        return ans.next;
    }
}
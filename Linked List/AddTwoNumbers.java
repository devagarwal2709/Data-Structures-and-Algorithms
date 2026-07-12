/*
Pattern:
Simulation + Dummy Node + Carry

Time:
O(max(n, m))

Space:
O(max(n, m))   // Output list (O(1) auxiliary)

Idea:
Traverse both lists simultaneously.
At each step, add corresponding digits and carry.
Create a new node with sum % 10.
Carry = sum / 10.
Continue until both lists are exhausted, then append any remaining carry.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode dummy = new ListNode(-1);
        ListNode temp3=dummy;
        int value=0;
        int carry=0;
        while(temp1!=null || temp2!=null){
            if(temp2==null){
                value=(temp1.val+carry)%10;
                carry=(temp1.val+carry)/10;
                temp1=temp1.next;
            }
            else if(temp1==null){
                value=(temp2.val+carry)%10;
                carry=(temp2.val+carry)/10;
                temp2=temp2.next;
            }
            else{
                value=(temp1.val+temp2.val+carry)%10;
                carry=(temp1.val+temp2.val+carry)/10;
                temp1=temp1.next;
                temp2=temp2.next;
            }
            temp3.next=new ListNode(value);
            temp3=temp3.next;
        }
        if(carry==1){
            temp3.next=new ListNode(1);
        }
        return dummy.next;
    }
}
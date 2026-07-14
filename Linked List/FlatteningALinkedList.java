/*
Pattern:
Flatten a Linked List (Merge Bottom Lists)

Time:
O(N × M)

Space:
O(number of columns) due to recursion

Idea:
Recursively flatten the right side, then merge the current
bottom list with the already flattened right list using
the bottom pointer.
*/

/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node mergelist(Node root, Node right){
        Node ans=root;
        Node temp=root.bottom;
        Node save;
        while(temp!=null && right!=null){
            if(temp.data<=right.data){
                temp=temp.bottom;
                root=root.bottom;
                }
            else{
                save=right.bottom;
                root.bottom=right;
                right.bottom=temp;
                root=right;
                right=save;
            }
        }
        while(right!=null){
            save=right.bottom;
            root.bottom=right;
            root=right;
            right=save;
        }
        ans.next=null;
        return ans;
    }
    public Node flatten(Node root) {
        if(root==null|| root.next==null){
            return root;
        }
        Node right=flatten(root.next);
        return mergelist(root, right);
    }
}
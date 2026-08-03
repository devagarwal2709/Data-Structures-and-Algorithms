/*
Pattern: Monotonic Deque

Time:
O(n)

Space:
O(k)

Idea:
Maintain a decreasing deque of indices.
Front always stores the maximum element of the current window.
Remove expired indices from the front and all smaller elements
from the back before inserting the current index.
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        int[] arr=new int[nums.length-k+1];
        int max=0;
        int j=0;
        for(int i=0; i<k; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        for(int i=k; i<nums.length; i++){
            arr[j]=nums[dq.peekFirst()];
            j++;
            if(dq.peekFirst()+k==i){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        arr[j]=nums[dq.peekFirst()];
        return arr;
    }
}
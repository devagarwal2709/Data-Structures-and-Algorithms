/*
Pattern: Min Heap of Size K

Time: O(n log k)

Space: O(k)

Idea:

Maintain a Min Heap containing the k largest elements seen so far.

If the heap size exceeds k, remove the smallest element.

At the end, the smallest element among these k largest elements
is the kth largest element.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int a=0;
        while(pq.size()!=k){
            pq.offer(nums[a]);
            a++;
        }
        for(int i=k; i<nums.length; i++){
            if(pq.peek()<nums[i]){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}
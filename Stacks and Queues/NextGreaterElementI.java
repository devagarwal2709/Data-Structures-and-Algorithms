/*
Pattern: Next Greater Element — Monotonic Stack

Time: O(n + m)
Space: O(n)

Idea:
Scan nums2 from right to left while maintaining a
monotonic decreasing stack.

Pop elements <= current since they cannot be the
next greater element for current or future elements.

After popping:
- Empty stack → NGE = -1
- Otherwise → stack top is NGE

Store value → NGE in a HashMap for O(1) lookup
for elements of nums1.
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        int[] arr=new int[nums1.length];
        for(int i=nums2.length-1; i>=0; i--){
            while(!st.isEmpty() && st.peek()<nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i], -1);
                st.push(nums2[i]);
            }
            else{
                map.put(nums2[i], st.peek());
                st.push(nums2[i]);
            }
        }
        for(int i=0; i<nums1.length; i++){
            arr[i]=map.get(nums1[i]);
        }
        return arr;
    }
}
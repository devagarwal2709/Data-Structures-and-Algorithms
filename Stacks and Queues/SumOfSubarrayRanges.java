/*
Pattern: Contribution Technique + Monotonic Stack

Time:
O(n)

Space:
O(n)

Idea:
Treat each element independently by counting the number
of subarrays where it acts as the minimum and maximum.
Use monotonic stacks to find previous/next smaller and
greater boundaries, compute each element's contribution,
and subtract total minimum contribution from maximum
contribution.
*/

class Solution {
    public long subArrayRanges(int[] nums) {
        Stack<Integer> st1=new Stack<>();
        int[] a=new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            while(!st1.isEmpty() && nums[st1.peek()]>=nums[i]){
                st1.pop();
            }
            if(st1.isEmpty()){
                a[i]=nums.length;
            }
            else{
                a[i]=st1.peek();
            }
            st1.push(i);
        }
        Stack<Integer> st2=new Stack<>();
        int[] b=new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!st2.isEmpty() && nums[st2.peek()]>nums[i]){
                st2.pop();
            }
            if(st2.isEmpty()){
                b[i]=-1;
            }
            else{
                b[i]=st2.peek();
            }
            st2.push(i);
        }
        Stack<Integer> st3=new Stack<>();
        int[] c=new int[nums.length];
        for(int i=nums.length-1; i>=0; i--){
            while(!st3.isEmpty() && nums[st3.peek()]<=nums[i]){
                st3.pop();
            }
            if(st3.isEmpty()){
                c[i]=nums.length;
            }
            else{
                c[i]=st3.peek();
            }
            st3.push(i);
        }
        Stack<Integer> st4=new Stack<>();
        int[] d=new int[nums.length];
        for(int i=0; i<nums.length; i++){
            while(!st4.isEmpty() && nums[st4.peek()]<nums[i]){
                st4.pop();
            }
            if(st4.isEmpty()){
                d[i]=-1;
            }
            else{
                d[i]=st4.peek();
            }
            st4.push(i);
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
        long total_max=0;
        long total_min=0;
        for(int i=0; i<nums.length; i++){
            total_max+=1L*(c[i]-i)*(i-d[i])*nums[i];
            total_min+=1L*(a[i]-i)*(i-b[i])*nums[i];
        }
        return total_max-total_min;
    }
}
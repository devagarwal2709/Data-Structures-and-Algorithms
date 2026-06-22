/*
Pattern: Binary Search on Answers (Split Array Largest Sum)

Time: O(n * log(sum))
Space: O(1)

Idea:
Binary search on the maximum subarray sum.

For a candidate limit (mid),
count the minimum partitions required.

If partitions > k,
increase the limit.

Otherwise,
try a smaller limit.

Store the minimum valid limit found.
*/

class Solution {
    public int splitArray(int[] nums, int k) {
        long sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>max){
                max=nums[i];
            }
            sum+=nums[i];
        }
        int start=max;
        int end=(int) sum;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            long a=0;
            int count=1;
            for(int i=0; i<nums.length; i++){
                a+=nums[i];
                if(a>mid){
                    a=nums[i];
                    count++;
                }
            }
            if(count>k){
                start=mid+1;
            }
            else if(count<=k){
                ans=mid;
                end=mid-1;
            }
        }
        return ans;
    }
}
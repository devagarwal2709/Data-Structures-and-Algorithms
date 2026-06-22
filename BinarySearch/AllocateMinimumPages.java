/*
Pattern: Binary Search on Answers (Book Allocation)

Time: O(n * log(sum))
Space: O(1)

Idea:
Binary search on the maximum pages assigned
to a student.

For a candidate limit (mid),
allocate books sequentially.

If pages exceed the limit,
assign remaining books to a new student.

If required students <= k,
try a smaller limit.

Otherwise,
try a larger limit.

Store the minimum valid limit found.
*/

class Solution {
    public int findPages(int[] arr, int k) {
        if(k>arr.length){
            return -1;
        }
        long sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
            sum+=arr[i];
        }
        int start=max;
        int end=(int) sum;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            long a=0;
            int count=1;
            for(int i=0; i<arr.length; i++){
                a+=arr[i];
                if((a)>mid){
                    count++;
                    a=arr[i];
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
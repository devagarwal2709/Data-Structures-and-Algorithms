/*
Pattern: Merge Sort + Two Pointers

Time: O(n log n)
Space: O(n)

Idea:
1. Divide array using Merge Sort.
2. Count reverse pairs in left half.
3. Count reverse pairs in right half.
4. Before merging:
   Count pairs satisfying
   left[i] > 2 * right[j]
   using two pointers.
5. Since halves are sorted,
   multiple pairs can be counted at once.
6. Merge both halves normally.
7. Use long to avoid overflow.
*/

class Solution {
    int mergesort(int[] arr, int start, int end){
        if(start>=end){
            return 0;
        }
        int count=0;
        int mid=start+(end-start)/2;
        count+=mergesort(arr, start, mid);
        count+=mergesort(arr, mid+1, end);
        int[] temp = new int[end-start+1];
        int lp=start;
        int rp=mid+1;
        int i=0;
        while(lp<=mid && rp<=end){
            long a=arr[rp];
            if(arr[lp]>2*a){
                count+=(mid-lp+1);
                rp++;
            }
            else{
                lp++;
            }
        }
        lp=start;
        rp=mid+1;
        while(lp<=mid && rp<=end){
            if(arr[lp]>arr[rp]){
                temp[i]=arr[rp];
                i++;
                rp++;
            }
            else{
                temp[i]=arr[lp];
                i++;
                lp++;
            }
        }
        while(lp<=mid){
            temp[i]=arr[lp];
            i++;
            lp++;
        }
        while(rp<=end){
            temp[i]=arr[rp];
            i++;
            rp++;
        }
        int b=0;
        while(start<=end){
            arr[start]=temp[b];
            start++;
            b++;
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergesort(nums, 0, nums.length-1);
    }
}
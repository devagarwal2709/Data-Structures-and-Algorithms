/*
Pattern: Merge Sort + Counting During Merge

Time: O(n log n)
Space: O(n)

Idea:
1. Divide array using Merge Sort.
2. Count inversions in left half.
3. Count inversions in right half.
4. While merging:
   If left[i] > right[j],
   all remaining elements in left half
   form inversions with right[j].
5. Add (mid - i + 1) to answer.
6. Merge both halves normally.
*/

class Solution {
    static int mergesort(int[] arr, int start, int end){
        if(start>=end){
            return 0;
        }
        int mid=start+(end-start)/2;
        int count=0;
        count+=mergesort(arr, start, mid);
        count+=+mergesort(arr, mid+1, end);
        int[] temp = new int[end-start+1];
        int lp=start;
        int rp=mid+1;
        int i=0;
        while(lp<mid+1 && rp<end+1){
            if(arr[lp]>arr[rp]){
                temp[i]=arr[rp];
                i++;
                rp++;
                count=count+(mid-lp+1);
            }
            else{
                temp[i]=arr[lp];
                i++;
                lp++;
            }
        }
        while(lp<mid+1){
            temp[i]=arr[lp];
            i++;
            lp++;
        }
        while(rp<end+1){
            temp[i]=arr[rp];
            i++;
            rp++;
        }
        int a=start;
        int b=0;
        while(a<=end){
            arr[a]=temp[b
            ];
            a++;
            b++;
        }
        return count;
    }
    static int inversionCount(int arr[]) {
        return mergesort(arr, 0, arr.length-1);
    }
}
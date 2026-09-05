/*
Pattern: Bottom-Up Heap Construction

Time: O(n)

Space: O(1)

Idea:

Start from the last non-leaf node and heapify down each element towards the root.

For max heapify, compare the current element with its children
and swap with the greater child if needed.

Process all non-leaf nodes from bottom to top to convert the
min heap into a max heap in-place.
*/

public class Solution {
    public static void heapifydown(int[] arr, int index){
        if(2*index+1>=arr.length){
            return;
        }
        int left=2*index+1;
        int right=2*index+2;
        int greatest=index;
        if(left<arr.length && arr[greatest]<arr[left]){
            greatest=left;
        }
        if(right<arr.length && arr[greatest]<arr[right]){
            greatest=right;
        }
        if(greatest!=index){
            int temp=arr[index];
            arr[index]=arr[greatest];
            arr[greatest]=temp;
        }
        else{
            return;
        }
        heapifydown(arr, greatest);
    }
    public static int[] MinToMaxHeap(int n, int[] arr){
        for(int i=(n-2)/2; i>=0; i--){
            heapifydown(arr, i);
        }
        return arr;
    }
}
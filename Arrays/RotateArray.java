/*
LeetCode 189 - Rotate Array

Pattern: Array Reversal

Approach:
1. Reverse entire array
2. Reverse first k elements
3. Reverse remaining elements

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {

    public void reverse(int[] arr, int start, int end) {
        for (int i = start; i < start + ((end + 1 - start) / 2); i++) {
            int temp = arr[i];
            arr[i] = arr[start + end - i];
            arr[start + end - i] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;

        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
}
/*
Pattern: Array Reversal
Time: O(n)
Space: O(1)

Idea:
Reverse whole array,
reverse first k elements,
reverse remaining elements.
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
/*
Pattern: Next Permutation
Time: O(n)
Space: O(1)

Idea:

1. Find first decreasing element from right (pivot).
2. Find next larger element from right and swap.
3. Reverse the suffix.

Goal:
Generate the smallest permutation larger than current.
*/

class Solution {

```
public void nextPermutation(int[] nums) {
    int pivotIndex = -1;
    for (int i = nums.length - 1; i > 0; i--) {
        if (nums[i - 1] < nums[i]) {
            pivotIndex = i - 1;
            break;
        }
    }
    if (pivotIndex != -1) {
        for (int i = nums.length - 1; i > pivotIndex; i--) {
            if (nums[i] > nums[pivotIndex]) {
                int temp = nums[i];
                nums[i] = nums[pivotIndex];
                nums[pivotIndex] = temp;
                break;
            }
        }
    }
    int left = pivotIndex + 1;
    int right = nums.length - 1;
    while (left < right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
    }
}
```

}

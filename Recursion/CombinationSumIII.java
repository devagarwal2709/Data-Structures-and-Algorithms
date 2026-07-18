/*
Pattern:
Include / Exclude + Constraint Pruning

Time:
O(2^9) ≈ O(1)

Space:
O(k) recursion stack (excluding output)

Idea:
For each number (1–9), choose to:
1. Include it.
2. Exclude it.

Stop when exactly k numbers have been chosen.
Store the combination only if the sum equals n.
Prune whenever the sum exceeds n.
*/

class Solution {
    public void helper(List<List<Integer>> list, List<Integer> temp, int[] arr, int sum, int index, int k, int n){
        if(temp.size()==k){
            if(sum==n){
                list.add(new ArrayList<>(temp));
            }
            return;
        }
        if(index==9){
            return;
        }
        if(sum+arr[index]<=n){
            sum+=arr[index];
            temp.add(arr[index]);
            helper(list, temp, arr, sum, index+1, k, n);
            sum-=arr[index];
            temp.remove(temp.size()-1);
        }
        else{
            return;
        }
        helper(list, temp, arr, sum, index+1, k, n);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(list, temp, arr, 0, 0, k, n);
        return list;
    }
}
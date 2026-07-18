/*
Pattern:
Backtracking + Take / Skip

Time:
Exponential (depends on target and candidates)

Space:
O(target / minCandidate) recursion stack (excluding output)

Idea:
At each index, make two choices:
1. Take the current element:
   - Add it to the current combination.
   - Stay at the same index since reuse is allowed.
2. Skip the current element:
   - Move to the next index.

Prune the take branch if adding the current element exceeds the target.
Backtrack after exploring the take branch.
*/

class Solution {
    public void helper(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int sum, int index){
        if(index==candidates.length){
            if(target==sum){
                list.add(new ArrayList<>(temp));
            }
            return;
        }
        if(sum+candidates[index]<=target){
            temp.add(candidates[index]);
            sum+=candidates[index];
            helper(list, temp, candidates, target, sum, index);
            sum-=temp.get(temp.size()-1);
            temp.remove(temp.size()-1);
        }
        helper(list, temp, candidates, target, sum, index+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(list, temp, candidates, target, 0, 0);
        return list;
    }
}
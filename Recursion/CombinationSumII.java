/*
Pattern:
Backtracking + For Loop + Skip Duplicate Siblings

Time:
O(2^n) in the worst case (pruned significantly)

Space:
O(n) recursion stack (excluding output)

Idea:
1. Sort the array.
2. At each recursion level, choose one element from the remaining array.
3. Skip duplicate values at the same recursion level to avoid generating identical branches.
4. Since each element can be used only once, recurse with i + 1.
5. Stop immediately when the target is reached.
6. Since the array is sorted, break the loop when the current value exceeds the remaining target.
*/

class Solution {
    public void helper(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int index, int sum){
        if(sum==target){
            list.add(new ArrayList<>(temp));
            return;
        }
        if(index==candidates.length){
            return;
        }
        for(int i=index; i<candidates.length; i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(sum+candidates[i]<=target){
                temp.add(candidates[i]);
                sum+=candidates[i];
                helper(list, temp, candidates, target, i+1, sum);
                sum-=temp.get(temp.size()-1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(list, temp, candidates, target, 0, 0);
        return list;
    }
}
/*
Pattern:
- For-loop Backtracking

Idea:
- Each recursion level processes one digit.
- Loop through all letters mapped to the current digit.
- Choose → Recurse(index+1) → Backtrack.

Time: O(4^N * N)
Space: O(N) (excluding output)
*/

class Solution {
    public void helper(List<String> list, StringBuilder temp, String digits, String[] store, int index){
        if(index==digits.length()){
            list.add(temp.toString());
            return;
        }
        int digit=digits.charAt(index)-'0';
        for(int i=0; i<store[digit].length(); i++){
            temp.append(store[digit].charAt(i));
            helper(list, temp, digits, store, index+1);
            temp.setLength(temp.length()-1);
        }
    }
    public List<String> letterCombinations(String digits){
        List<String> list=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        String[] store=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        helper(list, temp, digits, store, 0);
        return list;
    }
}
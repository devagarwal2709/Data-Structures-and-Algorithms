/*
Pattern: Hashing + Custom Sorting

Time: O(n + k log k)
Space: O(k)

Idea:
Count character frequencies using a HashMap, store each
(character, frequency) pair in a list, sort the list by
frequency, then append each character according to its count.
*/

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Pair<Character, Integer>> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            list.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
        list.sort((a,b) -> Integer.compare(a.getValue(), b.getValue()));
        for(int i=list.size()-1; i>=0; i--){
            for(int j=list.get(i).getValue(); j>0; j--){
                sb.append(list.get(i).getKey());
            }
        }
        return sb.toString();
    }
}
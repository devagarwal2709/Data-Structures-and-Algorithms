/*
Pattern: Min Heap + Frequency Map + Greedy

Time: O(N log K)

Space: O(K)

Idea:

Store the frequency of each card and keep all distinct card values
in a Min Heap.

Always start a group from the smallest remaining card.

For each group, check whether consecutive cards exist.
Decrease their frequencies and remove them from the heap when
their frequency becomes zero.

If any required consecutive card is missing, return false.
*/

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int groups=0;
        if(hand.length%groupSize!=0){
            return false;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int a: hand){
            if(map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }
            else{
                map.put(a, 1);
            }
        }
        for(int x: map.keySet()){
            pq.offer(x);
        }
        while(map.size()!=0){
            int current=pq.peek();
            for(int j=0; j<groupSize; j++){
                if(map.containsKey(current)){
                    map.put(current, map.get(current)-1);
                    if(map.get(current)==0){
                        map.remove(current);
                        pq.poll();
                    }
                }
                else{
                    return false;
                }
                current++;
            }
        }
        return true;
    }
}
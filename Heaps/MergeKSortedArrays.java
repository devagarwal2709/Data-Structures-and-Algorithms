/*
Pattern: Min Heap + K-Way Merge

Time: O(N log R)

Space: O(R)

Idea:

Keep only the smallest unprocessed element from each row in a Min Heap.

Each heap node stores:
value, row, column

Poll the smallest element, add it to the answer,
then push the next element from the same row.

Continue until all elements are processed.
*/

class Solution {
    class Node{
        int value;
        int row;
        int column;
        
        Node(int value, int row, int column){
            this.value=value;
            this.row=row;
            this.column=column;
        }
    }
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        ArrayList<Integer> list=new ArrayList<>();
        PriorityQueue<Node> pq=new PriorityQueue<>(
            (a,b) -> a.value-b.value
        );
        for(int i=0; i<mat.length; i++){
            pq.offer(new Node(mat[i][0], i, 0));
        }
        while(list.size()!=mat.length*mat[0].length){
            Node current=pq.poll();
            int r=current.row;
            int c=current.column;
            list.add(current.value);
            if(c+1<mat[0].length){
                pq.offer(new Node(mat[r][c+1], r, c+1));
            }
        }
        return list;
    }
}
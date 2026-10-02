/*
Pattern: Max Heap + Visited Set

Time: O(n log n + m log m + k log k)
Space: O(k)

Idea:
Sort both arrays in descending order. Start with the pair of
largest elements and use a max heap to retrieve the highest sums.
Generate neighboring index pairs and use a visited set to avoid
processing the same pair more than once.
*/

class Solution {
    class Node{
        int val1;
        int val2;
        Node(int val1, int val2){
            this.val1=val1;
            this.val2=val2;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        PriorityQueue<Node> pq=new PriorityQueue<>(
        (m,n)-> Integer.compare(a[n.val1]+b[n.val2],a[m.val1]+b[m.val2])
        );
        HashSet<String> set=new HashSet<>();
        ArrayList<Integer> list=new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0;
        int j=a.length-1;
        while(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
        i=0;
        j=b.length-1;
        while(i<j){
            int temp=b[i];
            b[i]=b[j];
            b[j]=temp;
            i++;
            j--;
        }
        pq.offer(new Node(0,0));
        set.add("0,0");
        for(int z=0; z<k; z++){
            if(pq.isEmpty()){
                break;    
            }
            Node temp=pq.poll();
            list.add(a[temp.val1]+b[temp.val2]);
            int x=temp.val1;
            int y=temp.val2;
            if(y+1<b.length && !set.contains(x+","+(y+1))){
                pq.offer(new Node(x,y+1));
                set.add(x+","+(y+1));
            }
            if(x+1<a.length && !set.contains((x+1)+","+y)){
                pq.offer(new Node(x+1,y));
                set.add((x+1)+","+y);
            }
        }
        return list;
    }
}
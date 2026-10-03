/*
Pattern: Two Heaps (Max Heap + Min Heap)

Time: O(log n) addNum, O(1) findMedian
Space: O(n)

Idea:
Maintain the lower half in a max heap and the upper half
in a min heap. Keep the lower half equal in size to the
upper half or larger by one. The heap roots provide
the middle value(s) for calculating the median.
*/

class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianFinder() {
        pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq2=new PriorityQueue<>();
    }
    public void addNum(int num) {
        if(pq1.isEmpty()){
            pq1.offer(num);
            return;
        }
        if(pq2.isEmpty()){
            if(pq1.peek()>num){
                pq2.offer(pq1.poll());
                pq1.offer(num);
            }
            else{
                pq2.offer(num);
            }
            return;
        }
        if(pq1.size()==pq2.size()){
            if(pq2.peek()<num){
                pq1.offer(pq2.poll());
                pq2.offer(num);
            }
            else{
                pq1.offer(num);
            }
        }
        else{
            if(pq1.peek()>num){
                pq2.offer(pq1.poll());
                pq1.offer(num);
            }
            else{
                pq2.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if(pq1.size()==pq2.size()){
            return ((double)pq1.peek()+pq2.peek())/2;
        }
        return pq1.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
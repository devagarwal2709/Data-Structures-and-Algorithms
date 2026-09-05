public /*
Pattern: Binary Min Heap

Time: O(log n) per operation

Space: O(n)

Idea:

Maintain the min-heap property where every parent is smaller than its children.
Insert at the end and move the element upward.
Extract the minimum from the root and heapify downward.
Delete an element by decreasing it to Integer.MIN_VALUE,
moving it to the root, then extracting the minimum.
*/

class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;

    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    int parent(int i) { return (i - 1) / 2; }

    int left(int i) { return (2 * i + 1); }

    int right(int i) { return (2 * i + 2); }

    void insertKey(int k) {
        harr[heap_size]=k;
        heap_size++;
        decreaseKey(heap_size-1, k);
    }

    int extractMin() {
        if(heap_size==0){
            return -1;
        }
        int store=harr[0];
        harr[0]=harr[heap_size-1];
        heap_size--;
        MinHeapify(0);
        return store;
    }

        
    void deleteKey(int i) {
        if (i >= heap_size) return;
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    // Function to change value at ith index and store that value at first index.
    void decreaseKey(int i, int new_val) {

        // storing new value at ith index.
        harr[i] = new_val;

        while (i != 0 && harr[parent(i)] > harr[i]) {

            // swapping values of ith index with its parent node
            // if value at parent node is greater.
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;

        // if left or right child is smaller than current element,
        // we store its position.
        if (l < heap_size && harr[l] < harr[smallest]) smallest = l;

        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;

        // if smallest is not equal to i, we swap the values at their position.
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;

            // calling function recursively for the smallest index.
            MinHeapify(smallest);
        }
    }
}

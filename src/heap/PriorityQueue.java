package heap;

/** A priority queue: represented by the min heap.
 *  Used in Prim's algorithm. */
public class PriorityQueue{
	// FILL IN CODE as needed
    private MinHeap heap;
    private int [] position;
    private int size;

    public void PriorityQueue(int size){
        heap = new MinHeap(size);
        position = new int[size];
        this.size = 0;
    }
    void insert(int nodeId, int priority){

    }
    int removeMin(){
        return 1;
    }
    void reduceKey(int nodeId, int newPriority){

    }

}


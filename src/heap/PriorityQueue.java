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

    public int getSize(){
        return this.size;
    }
    public void insert(int nodeId, int priority){
        heap.insert(priority);
        position[nodeId] = heap.getIndex(priority);
        size++;

    }
    public int removeMin(){
        size--;
        int min = heap.removeMin();
        for(int i = 0; i < position.length; i++){
            if(position[i] == min){
                position[i] = -1;
            }
        }
        return min;
    }
    public void reduceKey(int nodeId, int newPriority){
        if(newPriority < heap.heap[position[nodeId]]){
            heap.heap[position[nodeId]] = newPriority;
            heap.pushUp(heap.heap[position[nodeId]]);
            position[nodeId] = heap.getIndex(newPriority);
        }else{
            //key will not be reduced
        }
    }

}


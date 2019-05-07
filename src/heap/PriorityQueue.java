package heap;

/** A priority queue: represented by the min heap.
 *  Used in Prim's algorithm. */
public class PriorityQueue{
	// FILL IN CODE as needed
    private HeapNode[] heap;
    private int [] position;
    private int maxSize;
    private int size;

    public PriorityQueue(int size){
        heap = new HeapNode[size+1];
        position = new int[size];
        this.maxSize = size;
        this.size = 0;
        heap[0] = new HeapNode(Integer.MIN_VALUE,Integer.MIN_VALUE);
    }

    public int getSize(){
        return this.size;
    }

    public void reduceKey(int nodeId, int newPriority){

        if(newPriority < heap[position[nodeId]].getPriority()){
            heap[position[nodeId]].setPriority(newPriority);
            pushUp(position[nodeId]);

        }else{
            //key will not be reduced
        }
    }
    /** Return the index of the left child of the element at index pos
     *
     * @param pos the index of the element in the heap array
     * @return the index of the left child
     */
    private int leftChild(int pos) {
        return 2 * pos;
    }

    /** Return the index of the right child
     *
     * @param pos the index of the element in the heap array
     * @return the index of the right child
     */
    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    /** Return the index of the parent
     *
     * @param pos the index of the element in the heap array
     * @return the index of the parent
     */
    private int parent(int pos) {
        return pos / 2;
    }

    /** Returns true if the node in a given position is a leaf
     *
     * @param pos the index of the element in the heap array
     * @return true if the node is a leaf, false otherwise
     */
    private boolean isLeaf(int pos) {
        return ((pos > size / 2) && (pos <= size));
    }

    /** Swap given elements: one at index pos1, another at index pos2
     *
     * @param pos1 the index of the first element in the heap
     * @param pos2 the index of the second element in the heap
     */
    private void swap(int pos1, int pos2) {
        int tmpPos1 = heap[pos1].getNodeId();
        int tmpPos2 = heap[pos2].getNodeId();
        position[tmpPos1] = pos2;
        position[tmpPos2] = pos1;


        HeapNode tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    /** Insert an element into the heap
     *
     * @param elem the element to insert
     */
    public void insert(int elem, int priority) {
        if(size < maxSize){
            size++;
            heap[size] = new HeapNode(elem, priority);

            int current = size;
            while (heap[current].getPriority() < heap[parent(current)].getPriority()) {
                swap(current, parent(current));
                current = parent(current);
            }
            position[elem] = current;
        }else{
            System.out.println("Heap is full");
        }

    }

    /** Print the array that stores the heap */
    public void print() {
        int i;
        for (i = 1; i <= size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }

    /** Remove minimum element (it is at the top of the minHeap)
     *
     * @return the smallest element in the heap
     */
    public int removeMin() {
        swap(1, size); // swap the end of the heap into the root
        size--;  	   // removed the end of the heap
        // fix the heap property - push down as needed
        if (size != 0)
            pushdown(1);
        return heap[size + 1].getNodeId();
    }

    /** Push the value down the heap if it does not satisfy the heap property
     *
     * @param position the index of the element in the heap
     */
    private void pushdown(int position) {
        int smallestchild;
        while (!isLeaf(position)) {
            if(size < position)
                return;
            smallestchild = leftChild(position); // set the smallest child to left child
            if ((smallestchild < size) && (heap[smallestchild].getPriority() > heap[smallestchild + 1].getPriority()))
                smallestchild = smallestchild + 1; // right child was smaller, so smallest child = right child

            // the value of the smallest child is less than value of current,
            // the heap is already valid
            if (heap[position].getPriority() <= heap[smallestchild].getPriority())
                return;
            swap(position, smallestchild);
            position = smallestchild;
        }
    }
    public void pushUp(int position){
        int currChild;
        while (!isLeaf(position ) ||  heap[position].getPriority() < heap[parent(position)].getPriority()){
            currChild = parent(position); // set the smallest child to left child
            if ((currChild < size) && (heap[currChild].getPriority() < heap[currChild + 1].getPriority()))
                currChild = currChild + 1; // right child was smaller, so smallest child = right child
            // the value of the smallest child is less than value of current,
            // the heap is already valid
            if (heap[position].getPriority() >= heap[currChild].getPriority())
                return;
            swap(position, currChild);
            position = parent(position);
        }
    }
    /** Returns the index of a given priority in the heap
     *
     * @param priority
     * @return the index of the priority or -1 if priority is not in heap
     */
    public int getIndex(int priority){
        System.out.println("Size: "+ size);
        for(int i = 0; i < size; i++){
            if(heap[i].getPriority() == priority){
                return i;
            }
        }
        return -1;
    }
}





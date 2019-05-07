package algo;

import graph.*;
import heap.PriorityQueue;

/** Subclass of MSTAlgorithm. Uses Prim's algorithm to compute MST of the graph. */
public class PrimAlgorithm extends MSTAlgorithm {

    private int sourceVertex;

    /**
     * Constructor for PrimAlgorithm. Takes the graph
     * @param graph input graph
     * @param sourceVertex the first vertex of MST
     */
    public PrimAlgorithm(Graph graph, int sourceVertex) {
        super(graph);
        this.sourceVertex = sourceVertex;
    }

    /**
     * Compute minimum spanning tree for this graph using Prim's algorithm.
     * Add edges of MST to edgesMST list.
     * */
    @Override
    public void computeMST() {
        // FILL IN CODE
        // Note: must use a PriorityQueue and be efficient
        Edge edge;
        boolean[] known = new boolean[numNodes()];
        PriorityQueue priorityQueue = new PriorityQueue(numNodes());
        int [][] table = new int[numNodes()][2];
        for(int i = 0; i < numNodes(); i++){
            table[i][0] = Integer.MAX_VALUE; //cost
            table[i][1] = -1;                //parent




        }
        table[sourceVertex][0]=0;
        table[sourceVertex][1]=0;
        for(int i = 0; i < numNodes(); i++){
            if(i == sourceVertex){
                priorityQueue.insert(i, 0);
            }else{
                priorityQueue.insert(i, Integer.MAX_VALUE);
            }

        }

        priorityQueue.reduceKey(sourceVertex, 0);

        while(priorityQueue.getSize() != 0){

            int vertex = priorityQueue.removeMin();

            known[vertex] = true;
            Edge tmp;
            for(tmp = getFirstEdge(vertex); tmp != null; tmp = tmp.next()){
                int destinationVertex = tmp.getId2();
                int cost = tmp.getCost();
                if(!known[destinationVertex]){
                    if(table[destinationVertex][0] > cost){
                        table[destinationVertex][0] = cost;
                        table[destinationVertex][1] = vertex;
                        priorityQueue.reduceKey(destinationVertex, cost);
                    }
                }
            }

        }
        for(int i = 0; i < numNodes(); i++){
            if(i == sourceVertex){
                edge = new Edge(i, i, 0);
                addMSTEdge(edge);
            }else{
                edge  = new Edge(i, table[i][1], table[i][0]);
                addMSTEdge(edge);

            }
        }



    }

}

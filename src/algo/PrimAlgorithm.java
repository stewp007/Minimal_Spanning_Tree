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

           // priorityQueue.insert(i, Integer.MAX_VALUE);


        }
        table[sourceVertex][0]=0;
        table[sourceVertex][1]=0;
        for(int i = 0; i < numNodes(); i++){
            if(i == sourceVertex){
                priorityQueue.insert(i, 0);
            }else{
                priorityQueue.insert(i, Integer.MAX_VALUE);
            }
            //priorityQueue.insert(i, Integer.MAX_VALUE);
        }
        System.out.println("Source Vertex: "+ sourceVertex);
        priorityQueue.reduceKey(sourceVertex, 0);
        /*
        for(int i = 0; i < numNodes(); i++){*/
        while(priorityQueue.getSize() != 0){

            int vertex = priorityQueue.removeMin();
            /*
            if(vertex == sourceVertex){
                edge = new Edge(sourceVertex, sourceVertex, 0);
                addMSTEdge(edge);
                known[vertex] = true;
            }else{
                edge  = new Edge(vertex, table[vertex][1], table[vertex][0]);
                addMSTEdge(edge);
                known[vertex] = true;
            }
*/
            //System.out.println(vertex);
            known[vertex] = true;
            Edge tmp;
            for(tmp = getFirstEdge(vertex); tmp != null; tmp = tmp.next()){
                int destinationVertex = tmp.getId2();
                int cost = tmp.getCost();
                if(!known[destinationVertex]){
                    if(table[destinationVertex][0] > cost){
                        table[destinationVertex][0] = cost;
                        table[destinationVertex][1] = vertex;
                        System.out.println("Destination: "+ destinationVertex);
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

package algo;

import graph.*;
import sets.DisjointSets;

/** Subclass of MSTAlgorithm. Computes MST of the graph using Kruskal's algorithm. */
public class KruskalAlgorithm extends MSTAlgorithm {

    /**
     * Constructor for KruskalAlgorithm. Takes the graph
     * @param graph input graph
     */
    public KruskalAlgorithm(Graph graph) {
        super(graph);
    }

    /**
     * Compute minimum spanning tree for this graph. Add edges of MST to
     * edgesMST list. Should use Kruskal's algorithm and DisjointSet class.
     */
    @Override
    public void computeMST() {
        // FILL IN CODE
        DisjointSets vertex = new DisjointSets();
        vertex.createSets(numNodes());
        Edge[] sortedEdges = new Edge[numEdges()];
        Edge tmp;
        int c = 0;
        for(int i = 0; i < numNodes(); i++) {

            for (tmp = getFirstEdge(i); tmp!= null; tmp = tmp.next()){
                sortedEdges[c] = tmp;
                c++;
            }
        }
        insertionSort(sortedEdges, 0, sortedEdges.length, false);
        for(Edge edge: sortedEdges){
            if(vertex.find(edge.getId1()) != vertex.find(edge.getId2())){
                addMSTEdge(edge);
                vertex.union(edge.getId1(), edge.getId2());
            }
        }

    }

    /**
     * InsertionSort used for Edge array
     * @param array array of comparables
     * @param lowindex starting index
     * @param highindex end index
     * @param reversed determines order of sorting
     */
    public void insertionSort(Edge[] array, int lowindex, int highindex, boolean reversed){
        Edge curr;
        int j;
        if(reversed){
            for (int i = lowindex; i <= highindex; i++) {
                curr = array[i];
                j = i - 1;
                while (j >= lowindex && array[j].compareTo(curr) < 0) {
                    array[j + 1] = array[j]; // shift elems to the right
                    j--;
                }
                array[j + 1] = curr;
            }
        }else{
            for (int i = lowindex; i < highindex; i++) {
                curr = array[i];
                j = i - 1;
                while (j >= lowindex && array[j].compareTo(curr) > 0) {
                    array[j + 1] = array[j]; // shift elems to the right
                    j--;
                }
                array[j + 1] = curr;
            }
        }

    }

}

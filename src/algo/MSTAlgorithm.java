package algo;

import graph.Edge;
import graph.Graph;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/** Parent class of PrimAlgorithm and KruskalAlgorithm.
 * Do not modify, except fill out code in printMST() method. */
public abstract class MSTAlgorithm {
    private Graph graph; // stores the graph of CityNode-s and edges connecting
    // them
    private List<Edge> edgesMST = new ArrayList<>(); // edges that belong to
    // MinimalSpanningTree

    public MSTAlgorithm(Graph graph) {
        this.graph = graph;
    }

    /** Add an edge to the list of edges of the Minimal Spanning Tree
     *
     * @param edge edge that is a part of MST
     */
    public void addMSTEdge(Edge edge) {
        edgesMST.add(edge);
    }

    /**
     * Compute minimum spanning tree for this graph. Add edges of MST to
     * edgesMST list. Will be implemented differently in Prim's and Kruskal's
     */
    public abstract void computeMST();

    /** Print the edges of the MST tree.
     * On each line it should print one edge, using names of two cities.
     * */
    public void printMST() {
        // FILL IN CODE
    }

    /**
     * Return the number of nodes in the underlying graph
     * @return number of nodes
     */
    public int numNodes() {
        return graph.numNodes();
    }

    /** Return the head of the linked list that contains all edges outgoing
     * from nodeId
     * @param nodeId id of the node
     * @return head of the linked list of Edges
     */
    public Edge getFirstEdge(int nodeId) {
        return graph.getFirstEdge(nodeId);
    }


    // -------------------- method needed for GUIApp-------------------
    /**
     * Used in GUIApp to display the MST. Returns a 2D Array, where each element
     * represents an edge and is an array of two Points (where this edge starts
     * and where it is going).
     */
    public Point[][] getMSTEdges() {
        Point[][] edges = new Point[edgesMST.size()][2];
        Point[] locations = graph.getNodes();
        int i = 0;

        for (Edge edge : edgesMST) {
            edges[i][0] = locations[edge.getId1()];
            edges[i][1] = locations[edge.getId2()];
            i++;
        }

        return edges;
    }

}


package graph;

/**
 * A class that represents a graph: stores the array of city nodes, the
 * adjacency list, as well as the hash table that maps city names to node ids.
 * Nodes are cities (of type CityNode); edges connect them and the cost of each edge
 * is the distance between the cities.
 * Fill in code in this class. You may add additional methods and variables.
 * You are required to implement a PriorityQueue from scratch, instead of using Java's built in.
 */

import java.awt.*;
import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Graph {
    private CityNode[] nodes; // nodes of the graph
    private Edge[] adjacencyList; // adjacency list; for each vertex stores a linked list of edges
    private int numEdges; // total number of edges
    // Add other variables as needed
    private int numNodes;


    /**
     * Constructor. Reads graph info from the given file,
     * and creates nodes and edges of the graph.
     *
     * @param filename name of the file that has nodes and edges
     */
    public Graph(String filename) {
       // FILL IN CODE: load the graph from the given file
        int c = 0;
        String line;
        HashMap<String, Integer> map = new HashMap<>();
        numEdges = 0;
        try(BufferedReader file = new BufferedReader(new FileReader(filename))){
            file.readLine();
            line = file.readLine();
            numNodes = Integer.parseInt(line);
            nodes = new CityNode[numNodes];
            line = file.readLine();
            while(c  < numNodes){
                System.out.println(line);
                String[] cities = line.split(" ");
                CityNode node = new CityNode(cities[0], Double.parseDouble(cities[1]), Double.parseDouble(cities[2]));
                nodes[c] = node;
                map.put(cities[0], c);
                c++;
                line = file.readLine();

            }
            adjacencyList = new Edge[numNodes];

            while((line = file.readLine()) != null){
                String [] edges = line.split(" ");
                Edge edge1 = new Edge(map.get(edges[0]), map.get(edges[1]), Integer.parseInt(edges[2]));
                numEdges++;
                Edge edge2 = new Edge(map.get(edges[1]), map.get(edges[0]), Integer.parseInt(edges[2]));
                numEdges++;
                if(adjacencyList[map.get(edges[0])] == null){
                    adjacencyList[map.get(edges[0])] = edge1;
                }else {
                    Edge tmp1;
                    for (tmp1 = adjacencyList[map.get(edges[0])]; tmp1.next() != null; tmp1 = tmp1.next()) { }
                    tmp1.setNext(edge1);
                }
                if(adjacencyList[map.get(edges[1])] == null){
                    adjacencyList[map.get(edges[1])] = edge2;
                }else {
                    Edge tmp2;
                    for(tmp2 = adjacencyList[map.get(edges[1])]; tmp2.next() != null; tmp2 = tmp2.next()) { }
                    tmp2.setNext(edge2);
                }

            }

        }catch(IOException e){
            System.out.println("error");
        }






    }



    /**
     * Return the number of nodes in the graph
     * @return number of nodes
     */
    public int numNodes() {
        return nodes.length;
    }

    /** Return the head of the linked list that contains all edges outgoing
     * from nodeId
     * @param nodeId id of the node
     * @return head of the linked list of Edges
     */
    public Edge getFirstEdge(int nodeId) {
        return adjacencyList[nodeId];
    }

    /**
     * Return the edges of the graph as a 2D array of points.
     * Called from GUIApp to display the edges of the graph.
     *
     * @return a 2D array of Points.
     * For each edge, we store an array of two Points, v1 and v2.
     * v1 is the source vertex for this edge, v2 is the destination vertex.
     * This info can be obtained from the adjacency list
     */
    public Point[][] getEdges() {
        Point[][] edges2D = new Point[numEdges][2];
        // FILL IN CODE
        int i = 0;
        for(Edge edge: adjacencyList){
            Edge tmp;
            for(tmp = edge; tmp!= null; tmp = tmp.next()){
                edges2D[i][0] = this.getNode(tmp.getId1()).getLocation();
                edges2D[i][1] = this.getNode(tmp.getId2()).getLocation();
                i++;
            }
        }



        return edges2D;
    }

    /**
     * Get the nodes of the graph as a 1D array of Points.
     * Used in GUIApp to display the nodes of the graph.
     * @return a list of Points that correspond to nodes of the graph.
     */
    public Point[] getNodes() {
        if (nodes == null) {
            System.out.println("Graph is empty. Load the graph first.");
            return null;
        }
        Point[] nodes = new Point[this.nodes.length];
        // FILL IN CODE
        for(int i = 0; i < this.nodes.length; i++){
            nodes[i] = this.nodes[i].getLocation();
        }


        return nodes;
    }

    /**
     * Used in GUIApp to display the names of the cities.
     * @return the list that contains the names of cities (that correspond
     * to the nodes of the graph)
     */
    public String[] getCities() {
        if (nodes == null) {
            //System.out.println("Graph is empty, load the graph from the file first");
            return null;
        }
        String[] labels = new String[nodes.length];
        // FILL IN CODE
        for(int i = 0; i < numNodes; i++){
            labels[i] = nodes[i].getCity();
        }


        return labels;

    }

    /**
     * Return the CityNode for the given nodeId
     * @param nodeId id of the node
     * @return CityNode
     */
    public CityNode getNode(int nodeId) {
        return nodes[nodeId];
    }


}
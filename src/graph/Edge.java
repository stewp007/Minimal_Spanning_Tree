package graph;

/** Edge class represents an edge in the adjacency list of the graph. 
  * Implements Comparable. Compares Edges based on the cost. Fill in code in compareTo. */
public class Edge implements Comparable<Edge> {
    private int id1; //source vertex
    private int id2; //destination vertex 
	private int cost;
	private Edge next;

	/**
	 * Constructor of class Ege
	 * @param id1 id of the first vertex
	 * @param id2 id of the second vertex
	 * @param cost cost (weight) of the edge
	 */
	public Edge(int id1, int id2, int cost){
		this.id1 = id1;
		this.id2 = id2;		
		this.cost = cost;
		next = null;
	}

	/**
	 * Getter for next
	 * @return the next edge in the linked list
	 */
	public Edge next(){
		return this.next;
	}

	/**
	 * Getter for id1
	 * @return id1
	 */
	public int getId1(){
		return this.id1;
	}

	/**
	 * Getter for id2
	 * @return id2
	 */
	public int getId2(){
		return this.id2;
	}

	/**
	 * Getter for the cost of the edge
	 * @return cost of the edge
	 */
	public int getCost(){
		return this.cost;
	}

	/**
	 * Setter for next
	 * @param newnext nextEdge in the linked list
	 */
	public void setNext(Edge newnext){
		this.next = newnext;
	}


	/**
	 * Compares this edge to a given edge based on the cost
	 * @param o another edge
	 * @return 0 if edges are equal; -1 if this edge is "less", and 1 otherwise
	 */
	@Override
	public int compareTo(Edge o) {
		// FILL IN CODE: compare edges based on the cost

		return 0; // change
	}
	
         
 }
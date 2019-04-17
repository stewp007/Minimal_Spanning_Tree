package sets;

/** A class that represents the Disjoint Sets data structure. Please refer
 * to the lecture slides.
 * This class is used in Kruskal's.
 * */
public class DisjointSets {
    private int[] parent;

    public void createSets(int n) {
        // FILL IN CODE
    }

    /**
     * Returns the root of the "tree" that x belongs to. Uses path compression
     * heuristic.
     * @param x node id
     * @return root of the tree that x belongs to
     */
    public int find(int x) {
        // FILL IN CODE

        return -1; // change
    }

    /**
     * Merges the trees of x and y.
     * @param x node id
     * @param y node id
     */
    public void union(int x, int y) {
        // FILL IN CODE

    }

}


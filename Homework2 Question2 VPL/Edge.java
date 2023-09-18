//Title: Edge class
//Author: Sarp Arslan
//Description: Edge class to create edges that will be added to the graph.
//-----------------------------------------------------
public class Edge implements Comparable<Edge> {
	private final int v, w;
	public final double weight;

	// Summary: Constructor of the Edge class
	// Precondition: Vertices of the edge are not defined yet.
	// Postcondition:Vertices and weight are identified.
	public Edge(int v, int w, double weight) {
		
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int either() {
	   	// Summary: return one end of the edge
		// Precondition: none
		// Postcondition: returns one end of the edge
		return v;
	}

	public int other(int vertex) {
	    // Summary: return the other end of the edge
		// Precondition: a vertex of the edge is provided
		// Postcondition: returns the other end of the edge
		if (vertex == v)
			return w;
		else
			return v;
	}

	public int compareTo(Edge that) {
	    // Summary: compare the weight of the edge with another edge
		// Precondition: another Edge object is provided
		// Postcondition: returns -1 if the weight of this edge is less than that of the other edge,
		// returns +1 if the weight of this edge is greater than that of the other edge,
		// returns 0 if the weights of the two edges are equal
		if (this.weight < that.weight)
			return -1;
		else if (this.weight > that.weight)
			return +1;
		else
			return 0;
	}
}

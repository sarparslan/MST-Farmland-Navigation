
//-----------------------------------------------------
//Title: Prim class
//Author: Sarp Arslan
//Description: Prim class to use Prim's Minimum Spanning Tree Algorithm
//-----------------------------------------------------

import java.util.LinkedList;
import java.util.Queue;

public class Prim {

	private boolean[] marked; // whether a vertex is already in the tree
	private Queue<Edge> mst; // the edges in the minimum spanning tree
	private MinPQ<Edge> pq; // the priority queue of edges

	public Prim(EdgeWeightedGraph G) {
	    // Summary : Constructor of the Prim class.
		// Precondition: a connected graph G is provided
		// Postcondition: the constructor creates a minimum spanning tree of G using Prim's algorithm
		pq = new MinPQ<Edge>();
		mst = new LinkedList<Edge>();
		marked = new boolean[G.V()];
		visit(G, 0);
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if (marked[v] && marked[w])
				continue;
			if (EdgeControl(e)) {
				mst.add(e);
			} else {
				int End = e.either();
				int Other = e.other(End);
				Edge newEdge = new Edge(Other, End, e.weight);
				mst.add(newEdge);
			}
			if (!marked[v])
				visit(G, v);
			if (!marked[w])
				visit(G, w);
		}
	}

	// Summary: add all the edges connected to vertex v that are not yet in the tree to the priority queue
	private void visit(EdgeWeightedGraph G, int v) {
		// Precondition: a graph G and a vertex v are provided
		// Postcondition: all edges connected to v that are not yet in the tree are added to the priority queue
		marked[v] = true;
		for (Edge e : G.adj(v))
			if (!marked[e.other(v)])
				pq.insert(e);
	}

	// Summary: determine if adding an edge e to the tree creates a cycle
	public boolean EdgeControl(Edge e) {
		// Precondition: an edge e is provided
		// Postcondition: returns true if adding e to the tree would not create a cycle
		int End = e.either();
		int Other = e.other(End);
		for (Edge edge : mst) {
			int comparedEnd = edge.either();
			int comparedOther = edge.other(comparedEnd);
			if (Other == comparedOther) {
				return false;
			}
		}
		return true;
	}

	// Summary: return the minimum spanning tree as an iterable collection of edges
	public Iterable<Edge> mst() {
		// Precondition: the minimum spanning tree has been constructed
		// Postcondition: returns the minimum spanning tree as an iterable collection of edges
		return mst;
	}

}

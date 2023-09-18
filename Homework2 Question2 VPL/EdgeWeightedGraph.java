
//-----------------------------------------------------
//Title: EdgeWeightedgraph class
//Author: Sarp Arslan
//Description: EdgeWeightedgraph class to create a graph with edges who have weights.
//-----------------------------------------------------
import java.util.Iterator;

public class EdgeWeightedGraph {

// Number of vertices
private final int V;
// Array of Bags to store adjacent edges
private final Bag<Edge>[] adj;

// Summary : Constructor
// Preconditions: Size of the graph is given
// Postconditions: Initializes the graph with an array of Bags for storing adjacent edges
public EdgeWeightedGraph(int V) {
	this.V = V;
	adj = (Bag<Edge>[]) new Bag[V];
	for (int v = 0; v < V; v++)
		adj[v] = new Bag<Edge>();
}

// Summary : Adds edge between two vertices
// Preconditions: Two vertices are given as argument
// Postconditions: Adds the edge by adding their vertex ids to the related bags.
// Since it's an undirected graph implementation, it performs the operation for both vertices.
public void addEdge(Edge e) {
	int v = e.either(), w = e.other(v);
	adj[v].add(e);
	adj[w].add(e);
}

// Summary : Returns adjacent edges of the given vertex
// Preconditions: Vertex id is given
// Postconditions: Returns a collection of adjacent edges to the given vertex
public Iterable<Edge> adj(int v) {
	return adj[v];
}

// Summary: the number of vertices in the graph
// Postconditions: Returns the number of vertices in the graph
public int V() {
	return V;
}

// Bag class to hold adjacent edges
public class Bag<Item> implements Iterable<Item> {

	private Node<Item> first;
	private int n;

	private class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	// Summary : Constructor
	// Postconditions: Initializes an empty bag
	public Bag() {
		first = null;
		n = 0;
	}

	// Summary : Returns true if this bag is empty
	// Postconditions: Returns true if the bag is empty
	public boolean isEmpty() {
		return first == null;
	}

	// Summary : Returns the number of items in this bag
	// Postconditions: Returns the number of items in the bag
	public int size() {
		return n;
	}

	// Summary : Adds the item to this bag
	// Postconditions: Adds the item to the bag
	public void add(Item item) {
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		n++;
	}

	// Summary : Returns an iterator for iterating over the items in this bag
	// Postconditions: Returns an iterator for iterating over the items in the bag
	public Iterator<Item> iterator() {
		return new LinkedIterator(first);
	}

	// Summary : Iterator class for iterating over the items in the bag
	private class LinkedIterator implements Iterator<Item> {
		private Node<Item> current;

		public LinkedIterator(Node<Item> first) {
			current = first;
		}

		// Summary : Returns true if there are more items to iterate over
		// Postconditions: Returns true if there are more items to iterate over
		public boolean hasNext() {
			return current != null;
		}

		// Summary. : Removes the current item from the bag (not supported)
		// Postconditions: Throws an UnsupportedOperationException
		public void remove() {
			throw new UnsupportedOperationException();
		}

		// Summary : Returns the next item in the iteration
		// Postconditions: Returns the next item in the iteration


			public Item next() {
				if (!hasNext())
					return null;
				Item item = current.item;
				current = current.next;
				return item;
			}
		}
	}
}
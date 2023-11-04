//-----------------------------------------------------
//Title: MST class
//Author:Sarp Arslan
//Description: MST class to find minimum spanning tree on  graph.
//-----------------------------------------------------

import java.util.ArrayList;

public class MST {

	String[] list;
	EdgeWeightedGraph g;
	String a[];

	public MST(int[][] grid, int rows, int columns) {
	    // Summary : Constructor of MST class
		// Precondition: a 2D array of integers representing a grid, and the number of rows and columns are provided
		// Postcondition: the constructor creates an EdgeWeightedGraph from the grid using the gridToGraph method,
		// and then uses Prim's algorithm to find the minimum spanning tree of the graph and print its total weight
		g = new EdgeWeightedGraph(rows * columns);
		gridToGraph(grid, rows, columns);
		Prim p = new Prim(g);
		System.out.println(totalWeightMST(p.mst()));

	}

	public void gridToGraph(int[][] grid, int rows, int columns) {
	   	// Summary : create an EdgeWeightedGraph from a 2D array representing a grid
		// Precondition: a 2D array of integers representing a grid, and the number of rows and columns are provided
		// Postcondition: an EdgeWeightedGraph is created from the grid
		a = new String[rows * columns];
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				a[count] = String.format("(%d,%d)", i + 1, j + 1);
				count++;
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int currentVertex = i * columns + j;
				if (i > 0) {
					int topVertex = (i - 1) * columns + j;
					int distance = grid[i][j] ^ grid[i - 1][j];
					Edge e = new Edge(currentVertex, topVertex, distance);
					g.addEdge(e);
				}
				if (j > 0) {
					int leftVertex = i * columns + (j - 1);
					int distance = grid[i][j] ^ grid[i][j - 1];
					Edge e = new Edge(currentVertex, leftVertex, distance);
					g.addEdge(e);
				}
			}
		}
	}

	public int totalWeightMST(Iterable<Edge> mst) {
	    // Summary: calculate the total weight of an iterable collection of edges
		// Precondition: an iterable collection of edges representing a minimum spanning tree is provided
		// Postcondition: returns the total weight of the minimum spanning tree
		int totalWeight = 0;
		for (Edge e : mst) {
			totalWeight += e.weight;
		}
		return totalWeight;
	}

}


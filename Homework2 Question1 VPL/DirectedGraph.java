
//-----------------------------------------------------
//Title: DirectedGraph class
//Author:Sarp Arslan
//Description: Creates a directed graph, checks whether graph has a cycle or not
//-----------------------------------------------------

import java.util.ArrayList;

public class DirectedGraph {
    // instance variables
    private int numVertices;
    private ArrayList<String> vertices;
    private ArrayList<ArrayList<String>> adjacencyLists;
    private int edge_num = 0;

    // constructor
    public DirectedGraph(int numVertices) {
        // sets up the adjacency lists for the given number of vertices
        this.numVertices = numVertices;
        this.adjacencyLists = new ArrayList<ArrayList<String>>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            this.adjacencyLists.add(new ArrayList<String>());
        }
        this.vertices = new ArrayList<String>();
    }

    // adds a new vertex to the graph
    // Summary: Adds a new vertex to the graph if it doesn't already exist.
    // Precondition: None.
    // Postcondition: The graph contains a new vertex with the given label.
    public void addVertex(String vertex) {
        if (!this.vertices.contains(vertex)) {
            this.vertices.add(vertex);
            this.adjacencyLists.add(new ArrayList<String>());
            this.numVertices++;
        }
    }

    // adds a new directed edge to the graph
    // Summary: Adds a new directed edge to the graph between the given source and destination vertices.
    // Precondition: The source and destination vertices are already in the graph.
    // Postcondition: The graph contains a new directed edge from the source to the destination.
    public void addEdge(String src, String dest) {
        addVertex(src);
        addVertex(dest);
        int srcIndex = this.vertices.indexOf(src);
        int destIndex = this.vertices.indexOf(dest);
        this.adjacencyLists.get(srcIndex).add(dest);
        edge_num++;
    }

    // checks if a directed edge exists between two vertices
    // Summary: Checks if a directed edge exists between the given source and destination vertices.
    // Precondition: The source and destination vertices are already in the graph.
    // Postcondition: Returns true if a directed edge exists from the source to the destination, false otherwise.
    public boolean hasEdge(String src, String dest) {
        int srcIndex = this.vertices.indexOf(src);
        return srcIndex >= 0 && this.adjacencyLists.get(srcIndex).contains(dest);
    }

    // gets the neighbors of a vertex in the graph
    // Summary: Returns the list of neighbors of the given vertex in the graph.
    // Precondition: The vertex is already in the graph.
    // Postcondition: Returns a list of vertices that are adjacent to the given vertex in the graph.
    public ArrayList<String> getNeighbors(String vertex) {
        int vertexIndex = this.vertices.indexOf(vertex);
        if (vertexIndex >= 0) {
            return this.adjacencyLists.get(vertexIndex);
        } else {
            return new ArrayList<String>();
        }
    }

    // gets the list of vertices in the graph
    // Summary: Returns the list of vertices in the graph.
    // Precondition: None.
    // Postcondition: Returns a list of all vertices in the graph.
    public ArrayList<String> getVertices() {
        return this.vertices;
    }

    // checks if the graph has a cycle
    // Summary: Checks if the graph contains a cycle (i.e., a path from a vertex to itself).
    // Precondition: None.
    // Postcondition: Returns true if the graph contains a cycle, false otherwise.

    public boolean hasCycle() {
        boolean[] visited = new boolean[numVertices];
        boolean[] currentlyVisiting = new boolean[numVertices];
        
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && hasCycleUtil(i, visited, currentlyVisiting)) {
                return true;
            }
        }
        
        return false;
    }

    private boolean hasCycleUtil(int vertex, boolean[] visited, boolean[] currentlyVisiting) {
        visited[vertex] = true;
        currentlyVisiting[vertex] = true;
        
        ArrayList<String> neighbors = adjacencyLists.get(vertex);
        for (String neighbor : neighbors) {
            int neighborIndex = vertices.indexOf(neighbor);
            if (!visited[neighborIndex]) {
                if (hasCycleUtil(neighborIndex, visited, currentlyVisiting)) {
                    return true;
                }
            } else if (currentlyVisiting[neighborIndex]) {
                return true;
            }
        }
        
        currentlyVisiting[vertex] = false;
        return false;
    }

    
    
	
}



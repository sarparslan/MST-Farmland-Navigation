
//-----------------------------------------------------
//Title: main class
//Author:Sarp Arslan
//Description: Main class for run the program
//-----------------------------------------------------

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int edge_number;
        int vertex_number;
        System.out.println("Enter the number of taxi pickups:");

        vertex_number = input.nextInt();
        System.out.println("Enter the number of taxi rides:");
        edge_number = input.nextInt();

        DirectedGraph digraph = new DirectedGraph(vertex_number);

        System.out.println("Enter the taxi rides:");

        input.nextLine();
        HashMap<String, Integer> taxiPickups = new HashMap<>();
        for (int i = 0; i < edge_number; i++) {
            // read in the source and destination vertices for the current taxi ride
            String[] parts = input.nextLine().split(" ");
            String src = parts[0];
            String dest = parts[1];

            // keep track of the number of times each taxi pickup location appears
            taxiPickups.put(src, taxiPickups.getOrDefault(src, 0) + 1);

            // add the directed edge to the graph
            digraph.addEdge(src, dest);
        }

        input.close();

        // print out the adjacency list representation of the graph
        for (String vertex : digraph.getVertices()) {
            System.out.print(vertex + ": ");
            ArrayList<String> neighbors = digraph.getNeighbors(vertex);
            String reversedNeighbors = "";

            // reverse the order of the neighbors for printing 
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                reversedNeighbors += neighbors.get(i) + " ";
            }

            System.out.println(reversedNeighbors.trim());
        }

        // check if the graph contains a cycle or can be represented as a tree
        boolean result = digraph.hasCycle();
        if (result) {
            System.out.println("This ride network cannot be kept in a tree structure.");
        } else {
            if (vertex_number - edge_number == 1) {
                System.out.println("This ride network can be kept in a tree structure");
            }
        }
    }
}

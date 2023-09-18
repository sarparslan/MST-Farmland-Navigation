
//-----------------------------------------------------
//Title: Main class
//Author: Sarp Arslan
//Description: Main class for run the program
//-----------------------------------------------------
import java.util.Scanner;

public class main {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int testCases = scanner.nextInt();
	
	// Loop through each test case
	for (int t = 0; t < testCases; t++) {
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		int r1 = scanner.nextInt();
		int c1 = scanner.nextInt();
		int r2 = scanner.nextInt();
		int c2 = scanner.nextInt();

		// Create a 2D array to represent the grid
		int[][] grid = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}

		// Create a Minimum Spanning Tree object to find the shortest path

		MST mst = new MST(grid, rows, columns);
	}

	// Close the scanner object
	scanner.close();
}

}
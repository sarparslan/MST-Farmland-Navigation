# MST-Farmland-Navigation
All farmland in a town will be harvested by a company. The company first needs to calculate the
minimum cost of navigating between the farms. Since these farmlands are all next to each other,
information is collected from the landowners in the town and kept in a grid structure with N rows
and M columns. You are asked to write a program for this company. This program uses the MST
(Minimum Spanning Tree) algorithm to output a single integer expressing the minimum cost of
good trip in a grid structure.
Let your program first get the number of test cases from the user. For each test case, ask for the
number of rows and columns in the grid. Then calculate the cost of an edge e connecting any two
cells with values a and b as follows:
E(e)=a ⊕ b (where ⊕ denotes the bitwise xor operation of integers a and b)
We define good trip between two cells (u1,v1) and (u2,v2) as a trip starting at cell (u1,v1) and
ending at cell (u2,v2) while visiting every cell of the grid at least once. For a given edge e, if you
visit this edge T(e) times then the cost of the trip is:
∑ ( E(e) * ( T(e) / 2 ) (here, T(e) / 2 is the ceiling of the result of the division of T(e) by 2)
(∀e)
Now please find the minimum path cost of harvesting all farmland for the given starting cell
(u1,v1) and ending cell (u2,v2).

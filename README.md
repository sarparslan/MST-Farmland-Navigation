# MST-Farmland-Navigation

This Java program is designed to help a company calculate the minimum cost of harvesting all farmland in a town. The program uses the Minimum Spanning Tree (MST) algorithm to find the optimal route for harvesting all farmlands efficiently.

## Introduction

Welcome to the Farmland Harvesting Cost Calculator program! This program is designed to help a company calculate the minimum cost of navigating between farmlands in a grid structure using the Minimum Spanning Tree (MST) algorithm.

## Problem Statement

All farmland in a town will be harvested by a company. The company needs to calculate the minimum cost of navigating between the farms, which are arranged in a grid structure with N rows and M columns. The cost of an edge connecting any two cells with values "a" and "b" is calculated as follows: E(e) = a ⊕ b, where "⊕" denotes the bitwise XOR operation.

A good trip between two cells (u1,v1) and (u2,v2) is defined as a trip starting at cell (u1,v1) and ending at cell (u2,v2) while visiting every cell of the grid at least once. For a given edge "e," if you visit this edge "T(e)" times, then the cost of the trip is calculated as: ∑ (E(e) * (T(e) / 2)), where "T(e) / 2" is the ceiling of the result of the division of "T(e)" by 2.

## Features

- Calculation of the minimum cost of harvesting all farmland.
- Utilizes the MST algorithm to find the optimal route.
- Supports multiple test cases and customizable grid sizes.
- Clear and extensible Java codebase.

## Getting Started

1. Clone this repository to your local machine.

2. Compile and run the Java program using your preferred Java development environment.

3. Follow the prompts to input the number of test cases, grid dimensions, and farmland values to calculate the minimum cost.

## Usage

To use the Farmland Harvesting Cost Calculator, follow these steps:

1. Run the Java program.

2. Enter the number of test cases.

3. For each test case, provide the number of rows and columns in the grid, along with the coordinates of the starting and ending cells.

4. Input the values of the cells in the grid.

5. The program will calculate and display the minimum cost of harvesting all farmland for each test case.

## Input Format

<img width="561" alt="Screenshot 2023-11-06 at 20 40 41" src="https://github.com/sarparslan/MST-Farmland-Navigation/assets/96438389/836399e5-9343-4048-a378-3d2421f53d41">

Here, the first line is the number of test cases and the next line is the grid size for that test case
(N X M).
The line expressed by line 3 for this sample case is will consist of four integers, r1,c1,r2,c2,
denoting the coordinates (r1,c1) of the starting cell and (r2,c2) of the ending cell.

## Output Format

Finally, N lines will follow, each containing M integers, denoting the values in the grid, such that
the j.value in the i.row will denote the number in the cell (i, j) of the grid.

<img width="578" alt="Screenshot 2023-11-06 at 20 41 03" src="https://github.com/sarparslan/MST-Farmland-Navigation/assets/96438389/a53fd916-e0ca-4ea8-9117-caf3958faf22">


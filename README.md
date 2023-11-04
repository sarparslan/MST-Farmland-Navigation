# MST-Farmland-Navigation

This Java program is designed to help a company calculate the minimum cost of harvesting all farmland in a town. The program uses the Minimum Spanning Tree (MST) algorithm to find the optimal route for harvesting all farmlands efficiently.

## Introduction

In the town, all farmland needs to be harvested by a company. The goal is to calculate the minimum cost of navigating between the farmlands, which are arranged in a grid structure. The program collects information from landowners in the town to determine the cost of traveling between farmlands based on their values. It then calculates the minimum cost of a good trip that visits every cell in the grid at least once.

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

For each test case, the input format includes:

- The number of rows and columns in the grid.
- The coordinates of the starting and ending cells (u1, v1) and (u2, v2).
- The values of the cells in the grid, which determine the cost of traveling between them.

## Output Format

The program calculates and displays the minimum path cost of harvesting all farmland for each test case. It also provides additional information about the analysis, including the optimal route.

package co.ke.proaktiv.io.algorithms.depthfirstsearch;

public class NumberOfIslands {
	private final char[][] grid;
	
	public NumberOfIslands(char[][] grid) {
		this.grid = grid;
	}
	
	public int getNoOfIslands() {
		return numIslands(this.grid);
	}

	private int numIslands(char[][] grid) {
		int noOfIslands = 0;
		int rLen = grid.length;
		int cLen = grid[0].length;
		
		for(int r = 0; r < rLen; r++) {
			for(int c = 0; c < cLen; c++) {
				noOfIslands += numIslands(grid, r , c);
			}
		}
		return noOfIslands;
	}
	
	private int numIslands(char[][] grid, int r, int c) {
		if(r < 0 || r >= grid.length) return 0;
		if(c < 0 || c >= grid[r].length) return 0;
		if(grid[r][c] != '1') return 0;
		
		grid[r][c] = '0';
		
		numIslands(grid, r - 1, c);
		numIslands(grid, r + 1, c);
		numIslands(grid, r, c - 1);
		numIslands(grid, r, c + 1);
		
		return 1;
	}
}

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
*/
package co.ke.proaktiv.io.algorithms.breathfirstsearch;

import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
		Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
		
		for(int r = 0; r < rLen; r++) {
			for(int c = 0; c < cLen; c++) {
				char current = grid[r][c];
				
				if(current == '1') {
					q.offer(new SimpleEntry<>(r, c));
					
                    // mark as visited
                    grid[r][c] = '0';

					while(!q.isEmpty()) {
						Map.Entry<Integer, Integer> cell = q.poll();
						
						int cellR = cell.getKey();
						int cellC = cell.getValue();
						
						if(cellR - 1 >= 0 && grid[cellR - 1][cellC] == '1') {
							q.add(new SimpleEntry<>(cellR - 1, cellC));
                            // mark as visited
                            grid[cellR - 1][cellC] = '0';
						}
						if(cellR + 1 < rLen && grid[cellR + 1][cellC] == '1') {
							q.add(new SimpleEntry<>(cellR + 1, cellC));
                            // mark as visited
                            grid[cellR + 1][cellC] = '0';
						}
						if(cellC - 1 >= 0 && grid[cellR][cellC - 1] == '1') {
							q.add(new SimpleEntry<>(cellR, cellC - 1));
                            // mark as visited
                            grid[cellR][cellC - 1] = '0';
						}
						if(cellC + 1 < cLen && grid[cellR][cellC + 1] == '1') {
							q.add(new SimpleEntry<>(cellR, cellC + 1));
                            // mark as visited
                            grid[cellR][cellC + 1] = '0';
						}				
					}
					
					noOfIslands += 1;
				}
			}
		}
		return noOfIslands;
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
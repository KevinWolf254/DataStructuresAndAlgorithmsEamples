package co.ke.proaktiv.io.algorithms.breathfirstsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberOfIslandsTest {

	@Test
	void testGetNoOfIslands() {
		// given
		char[][] grid = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}
		};
		NumberOfIslands underTest = new NumberOfIslands(grid);
		
		// when
		int result = underTest.getNoOfIslands();
		
		// then
		assertTrue(result == 1);
	}

}

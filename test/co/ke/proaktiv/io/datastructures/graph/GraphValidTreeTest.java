package co.ke.proaktiv.io.datastructures.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphValidTreeTest {

	@Test
	void testIsValidTree_returnsTrue_whenNoOfNodesIsOne_andEdgesLengthIsZero() {
		// given
		GraphValidTree underTest = new GraphValidTree(1, new int[][] {});
		
		// when
		boolean result = underTest.isValidTree();
		
		// then
		assertTrue(result);
	}
	
	@Test
	void testIsValidTree_returnsFalse_whenNoOfNodesIsMoreThanOne_andEdgesLengthIsZero() {
		// given
		GraphValidTree underTest = new GraphValidTree(2, new int[][] {});
		
		// when
		boolean result = underTest.isValidTree();
		
		// then
		assertFalse(result);
	}
	
	@Test
	void testIsValidTree_returnsTrue_whenIsValidTree() {
		// given
		GraphValidTree underTest = new GraphValidTree(5, new int[][] {{0, 1}, {0, 2}, {0, 3}, {1, 4}});
		
		// when
		boolean result = underTest.isValidTree();
		
		// then
		assertTrue(result);
	}
	
	@Test
	void testIsValidTree_returnsFalse_whenIsNotValidTree() {
		// given
		GraphValidTree underTest = new GraphValidTree(5, new int[][] {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}});
		
		// when
		boolean result = underTest.isValidTree();
		
		// then
		assertFalse(result);
	}
}

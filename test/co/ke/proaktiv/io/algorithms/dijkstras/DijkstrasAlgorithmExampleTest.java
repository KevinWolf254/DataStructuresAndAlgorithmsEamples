package co.ke.proaktiv.io.algorithms.dijkstras;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class DijkstrasAlgorithmExampleTest {

	@Test
	void testGetShortestPath() {
		// given
		DijkstrasAlgorithmExample underTest = new DijkstrasAlgorithmExample(
				3, 
				new int[][] {{0, 1, 2}, {0, 3, 4}, {1, 2, 4}, {2, 3, 1}},
				0);
		
		// when
		Map<Integer, List<Integer>> result = underTest.getShortestPath();
		
		// then
		assertTrue(result.size() == 4);
		
		List<Integer> r1 = result.get(0);
		assertTrue(r1.get(0) == 0);
		assertTrue(r1.get(1) == 0);
		
		List<Integer> r2 = result.get(1);
		assertTrue(r2.get(0) == 2);
		assertTrue(r2.get(1) == 0);

		List<Integer> r3 = result.get(2);
		assertTrue(r3.get(0) == 6);
		assertTrue(r3.get(1) == 1);

		List<Integer> r4 = result.get(3);
		assertTrue(r4.get(0) == 4);
		assertTrue(r4.get(1) == 0);
		
	}
	

}

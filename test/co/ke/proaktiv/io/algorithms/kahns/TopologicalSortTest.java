package co.ke.proaktiv.io.algorithms.kahns;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Test;

class TopologicalSortTest {

	@Test
	void testGetSorted_returnsATopologicalSort_whenDirectedAcyclicGraphIsProvided() {
		// given
		TopologicalSort underTest = new TopologicalSort(new int[][] {
			{2, 0},
			{2, 4},
			{0, 3},
			{4, 3},
			{0, 1},
			{4, 5},
			{3, 1},
			{5, 1}
		});
		// when
		List<Integer> result = underTest.getSorted();
		// then
		System.out.println(result);
		assertTrue(result.equals(List.of(2, 0, 4, 3, 5, 1)));
	}

	@Test
	void testGetSorted_returnsEmpty_whenDirectedCyclicGraphIsProvided() {
		// given
		TopologicalSort underTest = new TopologicalSort(new int[][] {
			{2, 0},
			{2, 4},
			{0, 3},
			{4, 3},
			{1, 0},
			{4, 5},
			{3, 1},
			{5, 1}
		});
		// when
		List<Integer> result = underTest.getSorted();
		// then
		System.out.println(result);
		assertTrue(result.isEmpty());
	}
}

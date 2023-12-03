package co.ke.proaktiv.io.algorithms.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SubSetsExampleTests {

	@Test
	void testGetSubSets() {
		// given
		SubSetsExample underTest = new SubSetsExample(new int[] {1, 2, 3});
		// when
		List<List<Integer>> result = underTest.getSubsets();
		// then
		System.out.println(result);
		assertTrue(result.size() == 8);		
	}

}

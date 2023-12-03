package co.ke.proaktiv.io.algorithms.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CombinationSumTest {

	@Test
	void testGetCombinations() {
		// given
		CombinationSum underTest = new CombinationSum(new int[] {2,3,5}, 8);
		// when
		List<List<Integer>> result = underTest.getCombinations();
		// then
		assertTrue(result.size() == 3);
	}

}

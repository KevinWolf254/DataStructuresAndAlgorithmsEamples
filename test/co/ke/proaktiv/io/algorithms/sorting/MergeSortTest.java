package co.ke.proaktiv.io.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MergeSortTest {

	@Test
	void testSort() {
		// given
		int[] numbers = {3, 7, 1, 0, -1};
		MergeSort underTest = new MergeSort(numbers);
		
		// when
		underTest.sort();
		
		// then
		assertTrue(Arrays.equals(numbers, new int[] {-1, 0, 1, 3, 7}));
	}

}

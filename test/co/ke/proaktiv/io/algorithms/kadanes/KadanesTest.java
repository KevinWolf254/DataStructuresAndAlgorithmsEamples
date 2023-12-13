package co.ke.proaktiv.io.algorithms.kadanes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KadanesTest {

	@Test
	void testMaxSum() {
		// given
		Kadanes underTest = new Kadanes(new int[] {4, -1, 2, -7, 3, 4});
		
		// when
		int result = underTest.maxSum();
		
		// then
		assertTrue(result == 7);
	}
	

	@Test
	void testMaxSumIntervals() {
		// given
		Kadanes underTest = new Kadanes(new int[] {4, -1, 2, -7, 3, 4});

		// when
		int[] result = underTest.maxSumIntervals();

		// then
		assertTrue(result[0] == 4 && result[1] == 5);
	}

}

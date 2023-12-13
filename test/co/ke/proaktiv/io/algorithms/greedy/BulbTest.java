package co.ke.proaktiv.io.algorithms.greedy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BulbTest {

	@Test
	void testGetCost() {
		// given
		Bulb underTest = new Bulb(new int [] {1, 0, 1});
		// when
		int result = underTest.getCost();
		// then
		assertTrue(result == 2);
	}

}

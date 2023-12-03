package co.ke.proaktiv.io.algorithms.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordSearchTest {

	@Test
	void testExist_returnsTrue_whenWordIsPresentFromBeginning() {
		// given
		WordSearch underTest = new WordSearch(new char[][] {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}
		}, "ABCCED");
		// when
		boolean ans = underTest.exist();
		// then
		assertTrue(ans);
	}
	
	@Test
	void testExist_returnsTrue_whenWordIsPresentAtEnd() {
		// given
		WordSearch underTest = new WordSearch(new char[][] {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}
		}, "SEE");
		// when
		boolean ans = underTest.exist();
		// then
		assertTrue(ans);
	}
	
	@Test
	void testExist_returnsFalse_whenWordIsAbsent() {
		// given
		WordSearch underTest = new WordSearch(new char[][] {
			{'A', 'B', 'C', 'E'},
			{'S', 'F', 'C', 'S'},
			{'A', 'D', 'E', 'E'}
		}, "ABCB");
		// when
		boolean ans = underTest.exist();
		// then
		assertFalse(ans);
	}

}

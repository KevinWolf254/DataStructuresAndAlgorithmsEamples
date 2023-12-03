package co.ke.proaktiv.io.algorithms.backtracking;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
	private final char[][] board;
	private final char[] word;
	
	public WordSearch(char[][] board, String word) {
		this.board = board;
		this.word = word.toCharArray();
	}
	
	public boolean exist() {
		return exist(this.board, this.word);
	}

	private boolean exist(char[][] board, char[] word) {
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(exists(board, word, r, c, 0, new HashSet<String>())) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean exists(char[][] board, char[] word, int r, int c, int currIndex, Set<String> visited) {
		if(currIndex == word.length) {
			return true;
		}
		String location = "" +r+ ","+c;
		if(r < 0 || r >= board.length || c < 0 || c >= board[r].length || visited.contains(location) ||
				board[r][c] != word[currIndex]) {
			return false;
		}
		int nxtIndex = currIndex + 1;
		visited.add(location);
		boolean success = (exists(board, word, r, c + 1, nxtIndex, visited) ||
				exists(board, word, r, c - 1, nxtIndex, visited) ||
				exists(board, word, r + 1, c, nxtIndex, visited) ||
				exists(board, word, r - 1, c, nxtIndex, visited));
		
		visited.remove(location);
		return success;
	}

}

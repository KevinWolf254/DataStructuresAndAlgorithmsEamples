package co.ke.proaktiv.io.algorithms.sorting;

public class MergeSort {
	private final int[] numbers;
	
	public MergeSort(int[] numbers) {
		this.numbers = numbers;
	}
	
	public void sort() {
		sort(this.numbers);
	}
	
	private void sort(int[] numbers) {
		int len = numbers.length;
		if(len == 1) return;
		
		int lLen = len / 2;
		int rLen = len - lLen;
		
		int[] lNumbers = new int[lLen];
		int[] rNumbers = new int[rLen];
		
		int lIdx = 0, rIdx = 0, idx = 0;
		
		while(lIdx < lLen) {
			lNumbers[lIdx] = numbers[idx];
			lIdx++;
			idx++;
		}
		while(rIdx < rLen) {
			rNumbers[rIdx] = numbers[idx];
			rIdx++;
			idx++;
		}
		
		sort(lNumbers);
		sort(rNumbers);
		
		merge(numbers, lNumbers, rNumbers);
	}
	
	private void merge(int[] numbers, int[] lNumbers, int[] rNumbers) {
		int lIdx = 0, rIdx = 0, idx = 0, lLen = lNumbers.length, rLen = rNumbers.length;
		
		while(lIdx < lLen && rIdx < rLen) {
			int lNumber = lNumbers[lIdx];
			int rNumber = rNumbers[rIdx];
			
			if(lNumber < rNumber) {
				numbers[idx] = lNumber;
				lIdx++;
				idx++;
			} else {
				numbers[idx] = rNumber;
				rIdx++;
				idx++;
			}
		}
		
		while(lIdx < lLen) {
			numbers[idx] = lNumbers[lIdx];
			lIdx++;
			idx++;			
		}
		
		while(rIdx < rLen) {
			numbers[idx] = rNumbers[rIdx];
			rIdx++;
			idx++;			
		}
	}
}

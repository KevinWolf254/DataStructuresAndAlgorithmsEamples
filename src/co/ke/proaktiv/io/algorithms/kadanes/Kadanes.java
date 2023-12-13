package co.ke.proaktiv.io.algorithms.kadanes;

public class Kadanes {
	private final int[] nums;
	
	public Kadanes(int[] nums) {
		this.nums = nums;
	}
	
	public int maxSum() {
		return maxSum(this.nums);
	}
	
	private int maxSum(int[] nums) {
		int maxSum = nums[0];
		int currSum = 0;
		
		for(int num : nums) {
			currSum = Math.max(currSum, 0);
			currSum += num;
			maxSum = Math.max(maxSum, currSum);
		}
		
		return maxSum;
	}
	
	public int[] maxSumIntervals() {
		return maxSumIntervals(this.nums);
	}
	
	private int[] maxSumIntervals(int[] nums) {
		int maxSum = nums[0];
		int currSum = 0;
		int currLIndx = 0, currRIndx = 0;
		
		int lIndx = 0, rIndx = 0;
		
		for(int num : nums) {
			if(currSum < 0) {
				currSum = 0;
				currLIndx = currRIndx;
			}
			
			currSum += num;
			
			if(currSum > maxSum) {
				maxSum = currSum;
				lIndx = currLIndx;
				rIndx = currRIndx;
			}
			currRIndx++;
		}
		
		return new int[] {lIndx, rIndx};
	}
}
/*
clarifying questions
	min and max of nums?
	negative and positive?
	will input be fixed or dynamic?
	
approach 1 - TC = O(n^2), SC = O(1)
	brute force
		double for loop
		check if sum if greater than maxSum
		return maxSum

approach 2 - greedy
	ensure currSum is always positive
	if not greater than 0 set currSum = 0
	increment currSum with currNum
	if currSum is greater than maxSum
	update maxSum to currSum

*/
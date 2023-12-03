package co.ke.proaktiv.io.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSetsExample {
	private List<List<Integer>> subsets;
	private int[] nums;
	
	public SubSetsExample(int[] nums) {
		this.nums = nums;
		this.subsets = new ArrayList<>();
	}

	public List<List<Integer>> getSubsets() {
		return subsets(this.nums);
	}
	
	private List<List<Integer>> subsets(int[] nums) {
		generate(nums, 0, new ArrayList<Integer>());
		return subsets;
	}

	private void generate(int[] nums, int currIndex, ArrayList<Integer> subset) {
		if(currIndex >= nums.length) {
			this.subsets.add(new ArrayList<>(subset));
			return;
		}
		
		subset.add(nums[currIndex]);
		generate(nums, currIndex + 1, subset);
		
		subset.remove(subset.size() - 1);
		generate(nums, currIndex + 1, subset);

	}
	

/*
clarifying questions
    what would be the min and max length of nums? 1 ipto 10
    can contain positive and negative? yes
    no duplicates? yes
    any order? no
*/
}

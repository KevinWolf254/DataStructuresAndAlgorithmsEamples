package co.ke.proaktiv.io.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private final List<List<Integer>> combinations;
    private final int[] candidates;
    private final int target;
    
	public CombinationSum(int[] candidates, int target) {
		this.combinations = new ArrayList<>();
		this.candidates = candidates;
		this.target = target;
	}
	
	public List<List<Integer>> getCombinations() {
		return combinationSum(this.candidates, this.target);
	}
	
	private List<List<Integer>> combinationSum(int[] candidates, int target) {
		addCombination(candidates, target, 0, 0, new ArrayList<>());
		System.out.println(combinations);
        return combinations;
    }
	
	private void addCombination(int[] candidates, int target, int currIndex, int sum, List<Integer> combination) {
		if(sum == target) {
			combinations.add(new ArrayList<>(combination));
			return;
		}
		if(sum > target || currIndex >= candidates.length) {
			return;
		}
		
		int candidate = candidates[currIndex];
		int nextSum = sum + candidate;
		combination.add(candidate);
		addCombination(candidates, target, currIndex, nextSum, combination);
		
		combination.remove(combination.size() - 1);
		addCombination(candidates, target, currIndex + 1, sum, combination);
		
	}
}


/*
- input = distinct integers
- inpput = target
- output = list unique combinations of candidates that sum = target in any order
- same number can be used = target

clarifying question 
    distinct inputs? yes
    positive and negative? only positive
    min and max range candidates? 2 <= c <= 40
    min and max of target? 1 <= t <= 40
    target positive and negative?
    distinct outputs? yes

approach 1
    use dfs and backtracking
    for distinction i can add and remove a num at a certain index

        [1,2] , 3 - TC(n * 2^t)
                []
            /       \
           [1]                []      - 0
        /       \           /   \
    [1,1]       [1,2]       [2]   []          - 1
    /   \         |         /       \
[1,1,1]  [1,1,2] [1,2,2]  [2]        []     

*/
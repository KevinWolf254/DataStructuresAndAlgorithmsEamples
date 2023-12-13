package co.ke.proaktiv.io.algorithms.greedy;

public class Bulb {
	private int[] states;
	
	public Bulb(int[] states) {
		this.states = states;
	}
	
	public int getCost() {
		return cost(this.states);
	}
	
	private int cost(int[] bulbsState) {
		int cost = 0;
		for(int i = 0; i < bulbsState.length; i++) {
			int state = bulbsState[i];
			
			if(cost % 2 != 0) {
				if(state == 1) {
					bulbsState[i] = 0;
				} else {
					bulbsState[i] = 1;					
				}
			}
			
			if(bulbsState[i] == 0) {
				cost += 1;
			}
			
		}
		return cost;
	}
}
/*
get the cost = no of switches that needs to be done for all bulbs to be on (1)
0 = off
1 = on

clarifying questions
	min and max of bulbs? 1 - 1000
	will we be dynamically adding the bulbs? no, it will be fixed
	only two state? yes, on and off

approach 1 - brute force TC = O(n^2)
	iterate through bulbsState
		if state == 0
			increment cost
			change state to 1
			iterate through the rest and change their state 1 to 0 and 0 to 1

approach 2 TC = O(n)
	iterate through bulbsState
	if cost == odd
		change state i.e. 1 - 0 and 0 - 1
	if state == 0
		increment cost
			
	
*/
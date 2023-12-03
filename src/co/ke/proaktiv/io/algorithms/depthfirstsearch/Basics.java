package co.ke.proaktiv.io.algorithms.depthfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Basics {
	private final char[][] edges;//[[a, b], [b,c], [a, d],[c,d]]
	private final char src;
	private final HashMap<Character, List<Character>> adjacencyList;
	
	public Basics(char[][] edges, char src) {
		this.edges = edges;
		this.src = src;
		this.adjacencyList = createAdjecencyList(this.edges);
	}
	
	public void printDirectedAcyclicGraphUsingStack() {
		Stack<Character> stack = new Stack<>();
		
		stack.add(this.src);
		
		while(!stack.isEmpty()) {
			char current = stack.pop();
			System.out.println(current);
			
			List<Character> children = this.adjacencyList.get(current);
			for(char child : children) {
				stack.push(child);
			}
		}
	}
	
	public void printDirectedAcyclicGraphUsingRecursion() {
		recursion(this.adjacencyList, this.src);
	}
	
	private void recursion(HashMap<Character, List<Character>> adjacencyList, char src) {
		System.out.println(src);
		List<Character> children = adjacencyList.getOrDefault(src, new ArrayList<>());
		
		for(int i = children.size() - 1; i >= 0; i--) {
			char child = children.get(i);
			recursion(adjacencyList, child);
		}
	}

	public HashMap<Character, List<Character>> createAdjecencyList(char[][] edges) {
		HashMap<Character, List<Character>> adjacencyList = new HashMap<>();
		
		for(char[] edge : edges) {
			char parent = edge[0];
			char child = edge[1];			
			
			List<Character> children = adjacencyList.getOrDefault(parent, new ArrayList<>());
			children.add(child);
			adjacencyList.put(parent, children);

			adjacencyList.putIfAbsent(child, new ArrayList<>());
		}
		return adjacencyList;
	}
}

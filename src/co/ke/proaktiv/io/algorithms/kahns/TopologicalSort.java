package co.ke.proaktiv.io.algorithms.kahns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {
	private final int[][] edges;
	
	public TopologicalSort(int[][] edges) {
		this.edges = edges;
	}
	
	public List<Integer> getSorted() {
		return sort(this.edges);
	}
	
	private List<Integer> sort(int[][] edges) {
		List<Integer> result = new ArrayList<>();
		
		Map<Integer, Integer> indegrees = new HashMap<>();
		
		for(int[] edge : edges) {
			int parent = edge[0];
			int child = edge[1];
			indegrees.put(child, indegrees.getOrDefault(child, 0) + 1);
			indegrees.putIfAbsent(parent, 0);
		}
		Queue<Integer> queue = new LinkedList<>();
		
		for(Map.Entry<Integer, Integer> entry : indegrees.entrySet()) {
			int node = entry.getKey();
			int count = entry.getValue();
			if(count == 0) {
				queue.offer(node);
			}
		}
		
		while(!queue.isEmpty()) {
			int parent = queue.poll();
			result.add(parent);
			
			for(int[] edge : edges) {
				int node = edge[0];
				if(node == parent) {
					int child = edge[1];
					int count = indegrees.get(child);
					count -= 1;
					indegrees.put(child, count);
					if(count == 0) {
						queue.offer(child);
					}
				}
			}	
		}
		
		if(result.size() != indegrees.size()) {
			return List.of();
		}
		
		return result;
	}
}

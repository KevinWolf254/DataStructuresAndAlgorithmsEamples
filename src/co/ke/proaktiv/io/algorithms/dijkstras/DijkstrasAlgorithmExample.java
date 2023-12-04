package co.ke.proaktiv.io.algorithms.dijkstras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstrasAlgorithmExample {
	private final int totalNodes;
	private final int[][] edgesWithWeight;//[src, dst, wgt]
	private final int src;
	
	public DijkstrasAlgorithmExample(int totalNodes, int[][] edgesWithWeight, int src) {
		this.edgesWithWeight = edgesWithWeight;
		this.totalNodes = totalNodes;
		this.src = src;
	}
	
	public Map<Integer, List<Integer>> getShortestPath() {
		return shortestPath(this.totalNodes, this.edgesWithWeight, this.src);
	}
	
	private Map<Integer, List<Integer>> shortestPath(int totalNodes, int[][] edgesWithWeight, int src) {
		
		Map<Integer, List<List<Integer>>> adj = new HashMap<>();
		
		for(int[] edge : edgesWithWeight) {
			int s = edge[0];
			int d = edge[1];
			int w = edge[2];
						
			List<Integer> dstsWithWght = new ArrayList<>();
			dstsWithWght.add(d);
			dstsWithWght.add(w);
			
			List<List<Integer>> list = adj.getOrDefault(s, new ArrayList<>());
			list.add(dstsWithWght);	
			adj.put(s, list);
			
			adj.putIfAbsent(d, new ArrayList<>());
		}
		
		System.out.println(adj);
		
		PriorityQueue<List<Integer>> q = new PriorityQueue<>((a, b) -> a.get(1) - b.get(1));
		q.offer(List.of(src, 0, 0));
		
		Map<Integer, List<Integer>> shortestPath = new HashMap<>(totalNodes);
		
		while(!q.isEmpty()) {
			List<Integer> current = q.poll();
			int s = current.get(0);
			int w = current.get(1);
			int b = current.get(2);
			
			if(shortestPath.containsKey(s)) {
				continue;
			}
			shortestPath.put(s, List.of(w, b));
			
			List<List<Integer>> dsts = adj.get(s);
			for(List<Integer> dst : dsts) {
				int s1 = dst.get(0);
				int w1 = dst.get(1);
				
				if(shortestPath.containsKey(s1)) {
					continue;
				}
				
				q.add(List.of(s1, w + w1, s));
			}
			
		}
		
		for(int n = 0; n <= totalNodes; n++) {
			if(!shortestPath.containsKey(n)) {
				shortestPath.put(n, List.of(-1, -1));
			}
		}
		System.out.println(shortestPath);
		
		return shortestPath;
	}
	
}

/*

	edgesWithWeight = [[0, 1, 2], [0, 3, 4], [1, 2, 4], [2, 3, 1]]
	adjLst = 
		{
			0: [[1, 2], [3, 4]],
			1: [[2, 4]],
			2: [[3, 1]],
			3: []
		}
	minHeap = [[0, 0]] - [[1, 2], [3, 4]] - [[3, 4], [2, 6]], [[3, 7]]
	
	
	1
  /   \
0 		2
  \   /
	3

*/
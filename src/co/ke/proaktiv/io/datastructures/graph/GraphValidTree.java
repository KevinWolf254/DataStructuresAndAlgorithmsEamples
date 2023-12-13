package co.ke.proaktiv.io.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphValidTree {
	private final int noOfNodes;
	private final int[][] edges;
	
	public GraphValidTree(int noOfNodes, int[][] edges) {
		this.noOfNodes = noOfNodes;
		this.edges = edges;
	}
	
	public boolean isValidTree() {
		return validTree(this.noOfNodes, this.edges);
	}
	
	private boolean validTree(int n, int[][] edges) {
		if(n > 1 && edges.length == 0) return false;		
		if(n == 1 && edges.length == 0) return true;
		
		HashMap<Integer, List<Integer>> adj = new HashMap<>();
		for(int[] edge : edges) {
			int parent = edge[0];
			int child = edge[1];
			
			List<Integer> pChildren = adj.getOrDefault(parent, new ArrayList<>());
			pChildren.add(child);
			adj.put(parent, pChildren);

			List<Integer> cChildren = adj.getOrDefault(child, new ArrayList<>());
			cChildren.add(parent);
			adj.put(child, cChildren);
		}
		HashSet<Integer> visited = new HashSet<>();
		return validTree(0, -1, adj, visited) && visited.size() == n;
	}

	private boolean validTree(int node, int prevNode, HashMap<Integer, List<Integer>> adj, HashSet<Integer> visited) {
		if(!adj.containsKey(node)) return false;
		if(visited.contains(node)) return false;
		visited.add(node);
		
		List<Integer> children = adj.get(node);
		for(int child : children) {
			if(child == prevNode) {
				continue;
			}
			if(!validTree(child, node, adj, visited)) {
				return false;
			}
		}
		return true;
	}
}


/*
clarifying questions
    min and max of n? 1 - 2000
    min and max of edges len? 0 - 5000
    min and max of edges[i] len? 2
    min and max of edges[i][0] and edges[i][1]? 0 - 2000
    its undirected? yes
    define a valid tree?
        should have a root
        all nodes should have exactly one parent except for root
        all nodes to be connected
        should be acyclic - no cycles
        is 0 the root? yes

approach 1 - TC = (e + v), SC = O(e + v)
    convert edges to adj list
    use dfs 
    base case return false if visited
    add nodes to visited
    iterate through children
    ensure in child of parent is not parent
*/
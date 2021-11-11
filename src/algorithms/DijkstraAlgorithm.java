package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import data_structures.Graph;

public class DijkstraAlgorithm implements MinimumCostPathAlgorithm {

	@Override
	public int[][] findMinimumCostMatrix(Graph g) {
		long start = System.currentTimeMillis();
		
		int V = g.getNumVertices();
		int[][] minCosts = new int[V][V];
		
		for (int source = 0; source < V; source ++) {
			Set<Integer> visited = new HashSet<>();
			int[] distances = new int[V];
			
			for (int i = 0; i < V; i++)
				distances[i] = Integer.MAX_VALUE;
			distances[source] = 0;
			
			int v = source;
			int nextV = 0;
			int lowestDist;
			while (visited.size() != V && nextV != -1) {
				int[] adjacentCosts = g.getAdjacentVerticesCosts(v);
				nextV = -1;
				lowestDist = Integer.MAX_VALUE;
				
				for (int w = 0; w < adjacentCosts.length; w ++) {
					if (!visited.contains(w) && adjacentCosts[w] > 0) {
						int newDist = distances[v] + adjacentCosts[w];
						int knownDist = distances[w];
						if (newDist < knownDist)
							distances[w] = newDist;
					}
					
					if (!visited.contains(w) && v != w && distances[w] < lowestDist) {
						nextV = w;
						lowestDist = distances[w];
					}
				}
				visited.add(v);
				v = nextV;
			}
			
			minCosts[source] = distances;
		}
		
		long finish = System.currentTimeMillis();
		System.out.println("Tiempo: " + (finish - start));
		
		return minCosts;
	}

}

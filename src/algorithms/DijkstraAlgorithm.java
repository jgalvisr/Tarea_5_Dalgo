package algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import data_structures.Graph;

public class DijkstraAlgorithm implements MinimumCostPathAlgorithm {

	@Override
	public int[][] findMinimumCostMatrix(Graph g) {
		int V = g.getNumVertices();
		int[][] minCosts = new int[V][V];
		
		for (int source = 0; source < V; source ++) {
			Set<Integer> visited = new HashSet<>();
			int[] distances = new int[V];
			
			distances[source] = 0;
			for (int i : distances)
				distances[i] = Integer.MAX_VALUE;
			
			int v = source;
			while (visited.size() != V) {
				int[] adjacentCosts = g.getAdjacentVerticesCosts(v);
				int nextV = -1;
				int lowestDist = Integer.MAX_VALUE;
				
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
		
		return minCosts;
	}

}

package algorithms;

import data_structures.Graph;

public class BellmanFordAlgorithm implements MinimumCostPathAlgorithm {

	@Override
	public int[][] findMinimumCostMatrix(Graph g) {
		int V = g.getNumVertices();
		int[][] minCosts = new int[V][V];
		
		for (int source = 0; source < V; source ++) {
			int[] distances = new int[V];
			distances[source] = 0;
			for (int i : distances)
				distances[i] = Integer.MAX_VALUE;
			
			for (int i = 0; i < V-1; i ++) {
				for (int v = 0; v < V; v ++) {
					for (int w = 0; w < V; w ++) {
						if (g.hasEdge(v, w)) {
							// Edge (v, w)
							int cost = g.getEdgeCost(v, w);
							int newDist = distances[v] + cost;
							int knownDist = distances[w];
							if (newDist < knownDist)
								distances[w] = newDist;
						}
					}
				}				
			}
			minCosts[source] = distances;
		}
		return minCosts;
	}

}

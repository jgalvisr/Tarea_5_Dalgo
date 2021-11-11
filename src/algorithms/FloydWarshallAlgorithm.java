package algorithms;

import data_structures.Graph;

public class FloydWarshallAlgorithm implements MinimumCostPathAlgorithm {

	@Override
	public int[][] findMinimumCostMatrix(Graph g) {
		int V = g.getNumVertices();
		
		int[][] minCost = new int[V][V];

	    for (int i = 0; i < V; i++)
	      for (int j = 0; j < V; j++)
	        minCost[i][j] = g.getEdgeCost(i, j) == -1 ? Integer.MAX_VALUE : g.getEdgeCost(i, j);

	    
	    for (int k = 0; k < V; k++) {
	      for (int i = 0; i < V; i++) {
	        for (int j = 0; j < V; j++) {
	          if (minCost[i][k] < Integer.MAX_VALUE && minCost[k][j] < Integer.MAX_VALUE && minCost[i][k] + minCost[k][j] < minCost[i][j])
	            minCost[i][j] = minCost[i][k] + minCost[k][j];
	        }
	      }
	    }
	    
	    return minCost;
	}

}

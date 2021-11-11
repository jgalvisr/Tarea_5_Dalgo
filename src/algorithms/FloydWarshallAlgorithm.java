package algorithms;

import data_structures.Graph;

public class FloydWarshallAlgorithm implements MinimumCostPathAlgorithm {

	@Override
	public int[][] findMinimumCostMatrix(Graph g) {
		int V = g.getNumVertices();
		
		int[][][] m = new int[V][V][V];
		
		for (int k = 0; k <= V; k ++) {
			for (int i = 0; i < V; i ++) {
				for (int j = 0; j < V; j ++) {
					if (k == 0) {
						m[k][i][j] = g.getEdgeCost(i, j);
					}
					else {
						int val1 = m[k-1][i][j];
						int val2 = m[k-1][i][k-1];
						int val3 = m[k-1][k-1][j];
						m[k][i][j] = Math.min(Math.min(val1, val2), val3);
					}
				}
			}
		}
		
		return m[V];
	}

}

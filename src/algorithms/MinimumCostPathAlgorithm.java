package algorithms;

import data_structures.Graph;

public interface MinimumCostPathAlgorithm {
	
	/**
	 * Calculates the matrix with minimum costs between every vertex of the given graph.
	 * @param g Input graph.
	 * @return Matrix where the value at [i][j] represents the minimum cost for paths from the vertex i to j.
	 */
	public int[][] findMinimumCostMatrix(Graph g);
}

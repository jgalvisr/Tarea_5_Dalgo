package data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Graph data structure.
 */
public class Graph {
	/**
	 * Number of vertices.
	 */
	private int n;
	
	/**
	 * Number of edges.
	 */
	private int e;
	
	/**
	 * Adjacency matrix.
	 */
	private int[][] adjMatrix;
	
	// ----------------------------------------------------------------------------
	// -------------------------------- Methods -----------------------------------
	// ----------------------------------------------------------------------------
	
	/**
	 * Constructor method.
	 * @param adjMatrix
	 */
	public Graph(int numVertices) {
		n = numVertices;
		e = 0;
		adjMatrix = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) adjMatrix[i][j] = 0;
				else adjMatrix[i][j] = -1;
			}
		}
	}
	
	/**
	 * Adds an edge between vertices i and j.
	 * @param i First vertex
	 * @param j Second vertex
	 * @param cost Edge cost
	 */
	public void addEdge(int i, int j, int cost) {
		adjMatrix[i][j] = cost;
		e ++;
	}
	
	/**
	 * Returns the number of vertices in the graph.
	 * @return the number of vertices
	 */
	public int getNumVertices() {
		return n;
	}
	
	/**
	 * Returns the number of edges in the graph.
	 * @return the number of edges
	 */
	public int getNumEdges() {
		return e;
	}
	
	/**
	 * Returns whether there is an edge between two vertices i and j.
	 * @param i First vertex
	 * @param j Second vertex
	 * @return True if there is an edge, false otherwise
	 */
	public boolean hasEdge(int i, int j) {
		return adjMatrix[i][j] > 0;
	}
	
	/**
	 * Returns the edge cost between two vertices i and j.
	 * @param i First vertex
	 * @param j Second vertex
	 * @return Edge cost
	 */
	public int getEdgeCost(int i, int j) {
		return adjMatrix[i][j];
	}
	
	/**
	 * Returns the edge cost list of all vertices in relation to the vertex i.
	 * @param i
	 * @return
	 */
	public int[] getAdjacentVerticesCosts(int i) {
		return adjMatrix[i];
	}
	
	public void dfs(int start, boolean[] visited)
	{
		System.out.println(start);
		visited[start] = true;
		
		for(int i = 0; i < n; i++)
		{
			if(adjMatrix[start][i] == 1 && (!visited[i]))
			{
				dfs(i, visited);
			}
		}
	}
	
	public void bfs(int v)
	{
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		List<Integer> q = new ArrayList<>();
		q.add(v);
		visited[v] = true;
		
		int vis;
		while(!q.isEmpty()) 
		{
			vis = q.get(0);
			System.out.println(vis);
			q.remove(q.get(0));
			for(int i = 0; i < v; i++)
			{
				if (adjMatrix[vis][i] == 1 && (!visited[i]))
				{
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
	}
}

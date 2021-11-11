package algorithms;

import java.util.Arrays;

public class DFS 
{
	
	static class Graph
	{
		int v;
		
		int e;
		
		int[][] adj;
		
		Graph(int v, int e)
		{
			this.v = v;
			this.e = e;
			adj = new int[v][v];
			for(int i = 0; i < v; i++)
			{
				Arrays.fill(adj[i], 0);
			}
		}
		
		void addEdge(int v, int e)
		{
			adj[v][e] = 1;
			adj[e][v] = 1;
		}

		void dfs(int start, boolean[] visited)
		{
			System.out.println(start);
			visited[start] = true;
			
			for(int i = 0; i < v; i++)
			{
				if(adj[start][i] == 1 && (!visited[i]))
				{
					dfs(i, visited);
				}
			}
		}
		
		
		
	}

}

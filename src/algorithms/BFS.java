package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFS {
	
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
		
		void BFS(int v)
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
					if (adj[vis][i] == 1 && (!visited[i]))
					{
						q.add(i);
						visited[i] = true;
					}
				}
			}
			
		}
		
	}
	
	

}

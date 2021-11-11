package main;

import java.io.File;
import java.util.Scanner;

import algorithms.BellmanFordAlgorithm;
import algorithms.DijkstraAlgorithm;
import algorithms.FloydWarshallAlgorithm;
import algorithms.MinimumCostPathAlgorithm;
import data_structures.Graph;

public class Main {
	
	private static Graph g = null;
	
	public static void main(String[] args) {
		loadData();
		printMenu();
		Scanner sc = new Scanner(System.in);
		String opc = sc.nextLine();
		while(!opc.equals("4"))
		{
			if(opc.equals("1"))
			{
				MinimumCostPathAlgorithm algoritmo = null;
				printMenuParte1();
				opc = sc.nextLine();
				switch (opc) {
				case "a":
					algoritmo = new DijkstraAlgorithm();
					break;
				case "b":
					algoritmo = new BellmanFordAlgorithm();
					break;
				case "c": 
					algoritmo = new FloydWarshallAlgorithm();
					break;
				}
				try {
					//printResult(algoritmo.findMinimumCostMatrix(g));
					algoritmo.findMinimumCostMatrix(g);
				} catch (Exception e) {
					System.out.println("Input invalido.");
					e.printStackTrace();
				}
			}
			else if(opc.equals("2"))
			{
	
			}
			else if(opc.equals("3"))
			{
				
			}
		}

	}
	
	public static void loadData()
	{
		try
		{	
			System.out.print("Ingresa el nombre del archivo que quieres cargar: ");
			Scanner sc = new Scanner(System.in);
			String path = sc.nextLine();
			File f = new File("./data/"+path+".txt");
			Scanner sc_f = new Scanner(f);
			String data;
			int i = 0;
			
			while( sc_f.hasNextLine() && (data = sc_f.nextLine()) != null)
			{
				String[] elements = data.replaceAll("\\s+", ",").split(",");
				if(g == null)
				{
					g = new Graph(elements.length);
				}
				for (int j = 0; j < elements.length; j++)
				{
					g.addEdge(i, j, Integer.parseInt(elements[j]));
				}
				i += 1;
			}
//			sc_f.close();
//			sc.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void printMenu()
	{
		System.out.println("1. Parte 1");
		System.out.println("2. Parte 2");
		System.out.println("3. Parte 3");
		System.out.println("4. Salir");
		System.out.print("Opcion: ");
	}
	
	public static void printMenuParte1() {
		System.out.println("Elige el algoritmo a utilizar: ");
		System.out.println("a. Dijkstra");
		System.out.println("b. Bellman-Ford");
		System.out.println("c. Floyd-Warshall");
		System.out.print("Opcion: ");
	}
	
	public static void printResult(int[][] minCosts) {
		System.out.println("\nCostos de caminos de costo minimo:");
		for (int i = 0; i < minCosts.length; i++) {
			for (int j = 0; j < minCosts.length; j++) {
				String v = minCosts[i][j] == Integer.MAX_VALUE ? "i" : minCosts[i][j]+"";
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}
}

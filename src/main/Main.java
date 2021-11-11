package main;

import java.io.File;
import java.util.Scanner;

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
			System.out.println("Ingresa el nombre del archivo que quieres cargar: ");
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
			sc_f.close();
			sc.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void printMenu()
	{
		System.out.println("\n\n\n\n\n\n\n\n");
		System.out.println("1. Parte 1");
		System.out.println("2. Parte 2");
		System.out.println("3. Parte 3");
		System.out.println("4. Salir");
	}
}

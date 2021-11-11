package main;

import java.io.File;
import java.util.Scanner;

import data_structures.Graph;

public class Main {
	
	
	public static void main(String[] args) {
		loadData();
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
			Graph g = null;
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
			sc.close();
			sc_f.close();
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

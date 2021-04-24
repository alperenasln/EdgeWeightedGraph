import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//-----------------------------------------------------
//Title: Driver1
//Author:Alperen Aslan
//Definition : This class is the driver class for Part 1.
public class Driver1 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		try {
			//Reading the input
			File inputFile = new File("part1.txt");
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			String line;
			String parts[];
			int i = 0;
			int start = 0;
			//Reading first line and initializes.
			line = reader.readLine();
			parts = line.split(" ");
			int schools = Integer.parseInt(parts[0]);
			int connections = Integer.parseInt(parts[1]);
			EdgeWeightedGraph ewg = null;
			ewg = new EdgeWeightedGraph(connections);
			
			while ((line = reader.readLine()) != null) {
				//Adding edges into EdgeWeightedGraph
				parts = line.split(" ");
				int v = Integer.parseInt(parts[0]);
				int w = Integer.parseInt(parts[1]);
				int weight = Integer.parseInt(parts[2]);
				Edge e = new Edge(v, w, weight);
				ewg.addEdge(e);

			}
			//Creating PrimMST
			PrimMST pmst = new PrimMST(ewg);
			//Printing the cost of cheapest connection plan.
			System.out.println((int) pmst.weight());
			int a = 1;
			//Printing the cheapest connection plan.
			for (Edge e : pmst.edges()) {
				System.out.print(e);
				if (a < schools - 1) {
					System.out.print(",");
					a++;
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File cannot found");
		}

	}
}

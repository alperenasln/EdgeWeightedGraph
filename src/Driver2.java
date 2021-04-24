import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//-----------------------------------------------------
//Title: Driver2
//Author:Alperen Aslan
//ID: 27226264696
//Section: 2
//Assignment: 4
//Definition : This class is the driver class for Part 2.
public class Driver2 {

	public static void main(String[] args) throws IOException {

		// Reading the input
		File inputFile = new File("part2.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		String line;
		String parts[];
		// Reading the first 2 lines and initializes.
		int i = 0;
		int j = 0;
		line = reader.readLine();
		int schools = Integer.parseInt(line);
		line = reader.readLine();
		int connections = Integer.parseInt(line);
		//Creating the EdgeWeightedGraph with number of schools.
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(schools);
		
		while (i < connections) {
			//Reading the edge inputs.
			line = reader.readLine();
			parts = line.split(" ");
			//Adding edges into EdgeWeightedGraph
			int v = Integer.parseInt(parts[0]);
			int w = Integer.parseInt(parts[1]);
			int weight = Integer.parseInt(parts[2]);
			Edge e = new Edge(v, w, weight);
			ewg.addEdge(e);
			i++;
		}
		//Initializing variables.
		// t = Number of stores
		int t = Integer.parseInt(reader.readLine());
		int v1 = 0, v2 = 0, v3 = 0;
		int s = 0;
		try {
			//Reading inputs until it finishes.
			while (j < t) {

				v1 = Integer.parseInt(reader.readLine());
				v2 = Integer.parseInt(reader.readLine());
				v3 = Integer.parseInt(reader.readLine());
				j++;
			}
		} catch (NumberFormatException e) {

		}
		//Creating DijkstraUndirectedSP
		DijkstraUndirectedSP usp = new DijkstraUndirectedSP(ewg, s);
		for (int q = 0; q < t; q++) {
			//Finding possible shortest paths with method in the DijkstraUndirectedSP class.
			usp.findSP(ewg, q, q + 1);
			}
		//Using it again in case of not adding exceptional value
		usp.findSP(ewg, v3, s);
		//Printing the length of shortest possible path.
		System.out.println((int)usp.total);
	}

}

package com.ICPCChallenge2020Practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Map {
	private HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	
	public static ArrayList<Node> nodes = new ArrayList<>();
	
	public Map(int[][] pairs) throws IOException {
		 for(int[] pair : pairs){
			ArrayList<Integer> adjNodes = new ArrayList<>();
			if(!map.containsKey(pair[0])) {
				adjNodes.add(pair[1]);
				map.put(pair[0], adjNodes);
			} else {
				adjNodes = map.get(pair[0]);
				adjNodes.add(pair[1]);
				map.put(pair[0], adjNodes);
			}
		}
		
		generateNodes();
		writeOut();
	}
	
	public HashMap<Integer, ArrayList<Integer>> getMap(){
		return map;
	}
	
	private void generateNodes() {
		map.keySet().forEach(i -> {
			nodes.add(new Node(i, map.get(i)));
		});
		
		for (int i = 1; i < UndirectedGraphAnalysis.vertexCount + 1; i++) {
			if(!map.containsKey(i)) {
				nodes.add(new Node(i, new ArrayList<>()));
			}
		}
	}

	private void writeOut() throws IOException {
		FileWriter output = new FileWriter(UndirectedGraphAnalysis.inputName + "OutHashmap.txt");
		
		nodes.forEach(i -> {
			try {
				output.write(i + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		output.close();
	}
	
}

package com.ICPCChallenge2020Practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IndependentSets {
	private int size;
	
	private ArrayList<Integer> nodesInSet = new ArrayList<>();
	private ArrayList<Integer> blackList = new ArrayList<>();
	private Map map;
	
	public IndependentSets(Map map) throws IOException {
		this.map = map;
		findNodesInSet();
		size = nodesInSet.size();
		//makeMaximal();
		//size = nodesInSet.size();
		writeOut();
		writeOutNodesIn();
	}
	
	private void writeOut() throws IOException {
		FileWriter output = new FileWriter(UndirectedGraphAnalysis.inputName + "Answer.txt");
		int zeroCount = 0;
		
		String toWrite = "";
		toWrite += (size + "\n");
		
		for(Node node : Map.nodes){
			if(nodesInSet.contains(node.getValue())) {
				toWrite += 1 + " ";
			} else {
				toWrite += 0 + " ";
				zeroCount++;
			}
		} 
		System.out.println(zeroCount);
		output.write(toWrite);
		output.close();
	}
	
	private void writeOutNodesIn() throws IOException {
		FileWriter output = new FileWriter(UndirectedGraphAnalysis.inputName + "NodesIn.txt");
		
		String toWrite = "";
		toWrite += (size + "\n");
		
		for(Integer i : nodesInSet){
			toWrite += i.toString() + " ";
		} 
		output.write(toWrite);
		output.close();
	}
	
	private void findNodesInSet() {
		for(Node node: Map.nodes) {
			if(!blackList.contains(node.getValue())){
				nodesInSet.add(node.getValue());
				node.getAdjacentNodes().forEach(i -> {
					blackList.add(i);
				});
			}
		}
	}
	
	private void makeMaximal(){
		int[][] pairs = UndirectedGraphAnalysis.map;
		
		ArrayList<Integer> toAdd = new ArrayList<>();
		
		for(int i = 0; i < pairs.length; i++) {
			if(!nodesInSet.contains(pairs[i][0]) && !nodesInSet.contains(pairs[i][1])) {
				toAdd.add(pairs[i][0]);
			}
		}
		
		nodesInSet.addAll(toAdd);
	}

}

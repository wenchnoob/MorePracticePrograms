package com.ICPCChallenge2020Practice;

import java.util.ArrayList;

public class Node {
	
	private int value, amountOfEdges;
	private ArrayList<Integer> adjacentNodes = new ArrayList<>();
	
	public Node(int value, ArrayList<Integer> adjacentNodes) {
		this.value = value;
		this.adjacentNodes = adjacentNodes;
	}
	
	public int getValue() {
		return value;
	}
	
	public void addAdjacentNode(Integer node) {
		adjacentNodes.add(node);
	}
	
	public void removeAdjacentNode(Integer node) {
		try{
			adjacentNodes.remove(node);
		} catch (Exception e) {
			System.out.println("node is not adjacent");
		}
		
	}
	
	public ArrayList<Integer> getAdjacentNodes() {
		return adjacentNodes;
	}
	
	public void countEdges() {
		amountOfEdges = adjacentNodes.size();
	}
	
	public int getEdgeCount() {
		return amountOfEdges;
	}
	
	public int compare(Node n1, Node n2) {
		return amountOfEdges;
	}
	
	public String toString() {
		String toReturn = "";
		toReturn += getValue() + "\t";
		toReturn += getAdjacentNodes().toString();
		return toReturn;
	}
}

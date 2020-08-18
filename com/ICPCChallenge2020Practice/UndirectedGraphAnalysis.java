package com.ICPCChallenge2020Practice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UndirectedGraphAnalysis {
	public static final String inputName = "C:/Users/Student/Desktop/b1";
	public static final File input = new File(inputName + ".in");
	public static int [][] map;
	public static int size;
	public static int vertexCount;
	
	public UndirectedGraphAnalysis() throws IOException {
		Scanner scan = new Scanner(input);
		
		String firstLine = scan.nextLine();
		size = Integer.parseInt(firstLine.substring(firstLine.indexOf(" ") + 1));
		vertexCount = Integer.parseInt(firstLine.substring(0, firstLine.indexOf(" ")));
		
		map = new int[size][2];
		
		for(int i = 0; i < size; i++) {
			String line = scan.nextLine();
			map[i][0] = Integer.parseInt(line.substring(0, line.indexOf(" ")));
			map[i][1] = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
		} scan.close();
		
		new IndependentSets(new Map(map));
	}
	
	
	public static void main(String[] args) throws IOException {
		new UndirectedGraphAnalysis();
	}
}

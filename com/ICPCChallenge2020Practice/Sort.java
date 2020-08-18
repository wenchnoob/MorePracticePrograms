package com.ICPCChallenge2020Practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Sort {
	public static  void main(String[] args) throws IOException {
		File input = new File("C:/Users/Student/Desktop/sort.in");
		Scanner scan = new Scanner(input);
		
		int size = scan.nextInt();
		
		int []data = new int[size];
		
		for(int i = 0; i < size; i++) {
			data[i] = scan.nextInt();
		} scan.close();
		
		selectionSort(data);
		
		FileWriter output = new FileWriter("C:/Users/Student/Desktop/out.txt");
		
		for(int i = 0; i < size; i++) {
			output.write(data[i] + "\n");
		} output.close();
		
	}
	
	
	public static void selectionSort(int[] data) {
		int smallest = Integer.MAX_VALUE;
		int index = 0;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = i; j < data.length; j++) {
				if(data[j] < smallest) {
					smallest = data[j];
					index = j;
				}
			}
			int temp = data[i];
			data[i] = smallest;
			data[index] = temp;
			smallest = Integer.MAX_VALUE;
		}
	}
}

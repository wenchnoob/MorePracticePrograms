package GoogleStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution2 {
	static ArrayList<String> cycleList = new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println(solution("1211", 10));
		cycleList.forEach(System.out::println);
	}
	
	
	 
	public static int solution(String n, int b) {
		findCycle(n, b, 100);
		int count = analyzeCycle();
		return count;
	}
	
	private static int analyzeCycle() {
		int amountRepeated = 0;
		int length = 1;
		
		while(amountRepeated == 0) {
			if(cycleList.get(cycleList.size() - 1).equals(cycleList.get(cycleList.size() - (1+length)))) {
				amountRepeated = length;
			}
			length++;
		}
		
		return amountRepeated;
	}
	
	private static void findCycle(String n, int b, int cycles) {
		for(int j = 0; j < cycles; j++) {
			int amountOfDigits = n.length();
			Integer[] arrayRepresentationOfNum = new Integer[amountOfDigits];
			
			
			for(int i = 0; i < amountOfDigits; i++) arrayRepresentationOfNum[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
			
			Integer[] ascSortOfArray = Arrays.copyOf(arrayRepresentationOfNum, amountOfDigits);
			Arrays.parallelSort(ascSortOfArray);
			
			Integer[] descSortOfArray = Arrays.copyOf(arrayRepresentationOfNum, amountOfDigits);
			Arrays.parallelSort(descSortOfArray, Collections.reverseOrder());
			
			String y = "";
			for(int i = 0; i < amountOfDigits; i++) y += ascSortOfArray[i];
			String x = "";
			for(int i = 0; i < amountOfDigits; i++) x += descSortOfArray[i];
			
			String z = String.valueOf(makeBase(b, makeBase10(x, b) - makeBase10(y, b)));
			
			
			if(z.length() != amountOfDigits) {
				int necPads = amountOfDigits - z.length();
				String pad = "";
				for(int i = 0; i < necPads; i++) {
					pad += 0;
				}
				z = pad + z;
			}
			
			cycleList.add(z);
			n = z;
		}
		
	}
	
	private static Integer makeBase10(String n, int b) {
		int amountOfDigits = n.length();
		Integer[] arrayRepresentationOfNum = new Integer[amountOfDigits];
		Integer[] arr = arrayRepresentationOfNum;
		for(int i = 0; i < amountOfDigits; i++) arrayRepresentationOfNum[i] = Integer.parseInt(String.valueOf(n.charAt(i)));
		
		int baseTen = 0;
		int exponent = amountOfDigits - 1;
		for(int i = 0; i < amountOfDigits; i++) {
			baseTen += arr[i] * Math.pow(b, exponent);
			exponent--;
		}
		
		return Integer.valueOf(baseTen);
	}

	private static String makeBase(int b, Integer n) {
		String newRepresentation = "";
		
		int exponent = 0;
		ArrayList<Integer> digits = new ArrayList<>();
		
		while(n > 0) {
			if(n % Math.pow(b, exponent) == 0) {
				exponent++;
			} else {
				digits.add((int)(n % b));
				n = (int) (n / b);
			}
		}
		
		Collections.reverse(digits);
		for(Integer d: digits) {
			newRepresentation += d;
		}
		
		return newRepresentation;
	}
	
}

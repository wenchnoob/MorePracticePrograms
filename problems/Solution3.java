package GoogleStuff;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Solution3 {
	
	public static Random r = new Random();
	
	static int[] test1 = {2,0,2,2,0};
	static int[] test2 = {-2,-3,-5, 0, 0};//4, 6, 12};
	static int[] test3 = {-3};
	
	
	
	
	public static void main(String[] args) {
		int size = 50;
		
		int[] randomTest = new int[size];
		for(int i = 0; i < size; i++) {
			randomTest[i] = r.nextInt(11) - 5;
		}
		
		System.out.println(solution(randomTest));
		System.out.println(solution(test2));
		System.out.println(solution(test3));
	}
	
	
	
	
	
	
	public static String solution(int[] xs) {
		if(xs.length == 1 && Math.abs(xs[0]) != xs[0]) return new BigInteger(String.valueOf(xs[0])).toString();
		
		ArrayList<Integer> listOfPosPanels = new ArrayList<Integer>();
		for(int a : xs)
			if(a != 0 && Math.abs(a) == a) listOfPosPanels.add(a);
		
		ArrayList<Integer> listOfNegPanels = new ArrayList<Integer>();
		for(int a : xs)
			if(Math.abs(a) != a) listOfNegPanels.add(a);
		
		Collections.sort(listOfNegPanels);
		
		
		System.out.println(listOfPosPanels.toString());
		System.out.println(listOfNegPanels.toString());
		
		BigInteger largest = new BigInteger("0");
		BigInteger largestNeg = findLargestProduct(listOfNegPanels);
		BigInteger largestPos = findProduct(listOfPosPanels);
		
		if(largestNeg.compareTo(new BigInteger("0")) == 1) {
			if(!(largestPos.compareTo(new BigInteger("0")) == 0)) {
				largest = largestPos.multiply(largestNeg);
			} else {
				largest = largestNeg;
			}
			
		} else if(largestNeg.compareTo(new BigInteger("0")) == 0) {
			if(!(largestPos.compareTo(new BigInteger("0")) == 0)) {
				largest = largestPos;
			}
		} else if(largestNeg.compareTo(new BigInteger("0")) == -1) {
			if(!(largestPos.compareTo(new BigInteger("0")) == 0)) {
				largest = largestPos;
			}
		}
		
		return largest.toString();
	}
	
	public static BigInteger findProduct(ArrayList<Integer> list) {
		if(list.size() == 0) return new BigInteger("0");
		
		BigInteger product = new BigInteger("1");
		for(Integer n : list) {
			product = product.multiply(new BigInteger(n.toString()));
		}
		return product;
	}
	
	public static BigInteger findLargestProduct(ArrayList<Integer> list)  {
		BigInteger largest = new BigInteger(String.valueOf(0));
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size() - i; j++) {
				ArrayList<Integer> temp = new ArrayList<>();
				Object[] set =  Arrays.copyOfRange(list.toArray(), i, list.size() - j);
				for(Object n : set) {
					temp.add(Integer.valueOf(n.toString()));
				}
				if(findProduct(temp).compareTo(largest) == 1) {
					largest = findProduct(temp);
				}
			}
		}
		
		return largest;
	}
}

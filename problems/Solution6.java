package GoogleStuff;

import java.util.Arrays;

public class Solution6 {
	
	public static void main(String[] args) {
		System.out.println(solution(7));
	}
	
	public static int solution(int n) {
		
		int[] coefficients = new int[n + 1];
		coefficients[0] = 1;
		
		for(int i = 1; i < n+1; i++) {
			for(int j = n; j > i - 1; j--) {
				coefficients[j] += coefficients[j-i];
			}
		}
		
		return coefficients[n] - 1;
    }
	
	public static int determineRank(int n) {
		int rank = 0;
		if(n < 3) return rank;
		
		int r = 1;
		boolean found = false;
		
		while(!found && r < 100) {
			r++;
			
			int firstInRank = (r % 2 == 0) ?   (r/2) * (r+1) : ((r+1)/2) * r;
			
			if(n / firstInRank == 1 && n % firstInRank <= r) {
				rank = r;
				found = true;
			}
			
		}
		
		
		return rank;
	}
	
	public static int checkTwo(int n) {
		if(n%2 == 0) return n/2 - 1;
		return (n+1)/2 -1;
	}
	
	public static int checkThree(int n){
		return 0;
	}
}

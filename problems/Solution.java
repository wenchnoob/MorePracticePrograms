package GoogleStuff;

import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		
		System.out.println(solution("dogcatdogcatb"));
		
		
	}
	
	
	 
	public static int solution(String x) {
		int charCount = x.length();
		
		int end = 1;
		
		String repeatedString = null;
		boolean found = false;
		int amountOfRepeats;
		
		while(!found) {
			repeatedString = x.substring(0,end);
			amountOfRepeats = charCount/repeatedString.length();
			
			ArrayList<String> parts = new ArrayList<>();
			for(int i = 0; i < amountOfRepeats - 1; i++) {
				parts.add(x.substring(i * repeatedString.length(), (i + 1) * repeatedString.length()));
			} 
			parts.add(x.substring(x.length() - repeatedString.length()));
			
			parts.forEach(System.out::println);
			
			for(String i: parts) {
				if(!i.equals(repeatedString)) {
					found = false;
					break;
				} else {found = true;}
			}
			
			if(found) break;
			
			end++;
		}
		
		return x.length()/repeatedString.length();
	 }
}

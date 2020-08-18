package GoogleStuff;

import java.math.BigInteger;

public class Solution5 {
	static BigInteger cycle = BigInteger.ZERO;
	
	public static void main(String[] args) {
		System.out.println(BigInteger.valueOf(10).divide(BigInteger.valueOf(3)).min(BigInteger.valueOf(1)));
		System.out.println(solution("4", "7"));
	}
	
	
	
	
	public static String solution(String x, String y) {
    	BigInteger m = new BigInteger(x);
    	BigInteger f = new BigInteger(y);
    	
    	while(!(m.compareTo(BigInteger.ONE) == 0  && f .compareTo(BigInteger.ONE) == 0)) {
    		 if( f.compareTo(BigInteger.ZERO) == 0 || m.compareTo(BigInteger.ZERO) == 0)
    	            return "impossible";
    		 
    	     if(f.compareTo(BigInteger.ONE) == 0) {
    	    	 return cycle.add(m).subtract(BigInteger.ONE).toString();
    	     } else {
    	    	 cycle = cycle.add(m.divide(f));
    	    	 BigInteger temp = m;
    	    	 m = f; 
    	    	 f =  temp.mod(f);
    	     }     
    	}
    	
    	return cycle.toString();
    }
}

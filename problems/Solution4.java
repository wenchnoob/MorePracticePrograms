package GoogleStuff;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution4 {
	
	private static int[][] test1 = 
			{{0, 2, 1, 0, 0}, 
			{0, 0, 0, 3, 4}, 
			{0, 0, 0, 0, 0}, 
			{0, 0, 0, 0,0}, 
			{0, 0, 0, 0, 0}};
	
	private static int[][] test2 = 
			{{0, 1, 0, 0, 0, 1}, 
			{4, 0, 0, 3, 2, 0}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0}};
	
	private static int[][] test3 = 
		{{0, 1, 1}, 
		{0, 0,  0},
		{0, 1, 0}};
		
	public static void main(String[] args) {
		
		
		//System.out.println(solution(test1));
		//System.out.println();
		//System.out.println();
		//System.out.println(solution(test2));
		//System.out.println();
		//System.out.println();
		solution(test3);
		//solution(test1);
		//System.out.println(solution(test3));
	}
	
	
	
	
	
	
	public static int[] solution(int[][] xs) {
		int[] answer = null;
		
		Fraction[] originalStateMatrix = new Fraction[xs.length];
		originalStateMatrix[0] = new Fraction(1, 1);
		for(int i = 1; i < originalStateMatrix.length; i++) {
			originalStateMatrix[i] = new Fraction();
		}
		
		String fileContent = ""; 
		FileWriter writer;
		
		fileContent += ("Original \n");
		for(int[] n: xs) {
			fileContent += Arrays.toString(n) + "\n";
		}
		
		
		
		int[][] transposedMatrix = transpose(xs);
		fileContent += ("Transposed \n");
		for(int[] n: transposedMatrix) {
			fileContent += Arrays.toString(n) + "\n";
		}
		
		Fraction[][] transformedMatrix= transform(xs);
		fileContent += ("Fraction \n");
		for(Fraction[] n: transformedMatrix) {
			fileContent += Arrays.toString(n) + "\n";
		}
		
		Fraction[][] transposedTransformed = transpose(transformedMatrix);
		fileContent += ("Transposed Fraction \n");
		for(Fraction[] n: transposedTransformed) {
			fileContent += Arrays.toString(n) + "\n";
		}
		
		Fraction[][] stateMatrix = multiplyMatrices(originalStateMatrix, transformedMatrix);
		fileContent += ("State 1 Matrix \n");
		for(Fraction[] n: stateMatrix) {
			fileContent += Arrays.toString(n) + "\n";
		}
		
		try {
			writer = new FileWriter("/Users/Student/Desktop/Mat.txt");
			writer.write(fileContent);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return answer;
	} 
	
	private static int[][] transpose(int[][] xs){
		int[][] transposed = new int[xs[0].length][xs.length];
		
		for(int i = 0; i < xs.length; i++) {
			for(int j = 0; j < xs[i].length; j++) {
				transposed[j][i] = xs[i][j];
			}
		}
		return transposed;
	}
	
	private static Fraction[][] transpose(Fraction[][] xs){
		Fraction[][] transposed = new Fraction[xs[0].length][xs.length];
		for(int i = 0; i < xs.length; i++) {
			for(int j = 0; j < xs[i].length; j++) {
				transposed[j][i] = xs[i][j];
			}
		}
		return transposed;
	}
	
	private static Fraction[][] transform(int[][] xs){
		Fraction[][] transformed = new Fraction[xs[0].length][xs.length];
		
		int[] sum = new int[xs.length];
		for(int i = 0; i < xs.length; i++) {
			sum[i] = sum(xs[i]);
		}
		
		for(int i = 0; i < xs.length; i++) {
			for(int j = 0; j < xs[i].length; j++) {
				if(sum[i] != 0) {
					transformed[i][j] = new Fraction(xs[i][j], sum[i]);;
				} else {
					transformed[i][j] = new Fraction(xs[i][j], 1);;
				}
				
			}
		}
		return transformed;
	}
	
	public static Fraction[][] multiplyMatrices( Fraction[] originalStateMatrix,  Fraction[][] secondMatrix) {
        
		Fraction[][] product = new  Fraction[originalStateMatrix.length][secondMatrix.length];
		
		for(Fraction[] af: product) {
			for(int i = 0; i < af.length; i++) {
				af[i] = new Fraction();
			}
		}
        
        for(int i = 0; i < originalStateMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {
                for (int k = 0; k < secondMatrix.length; k++) {
                    product[i][j].add(originalStateMatrix[i].multiply(secondMatrix[k][j]));
                }
            }
        }

        return product;
    }
	
	@SuppressWarnings("unused")
	private static int sum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

}

/**********************************************************
Fraction.java - a Java representation of a fraction

Author: Diane Kramer
History:
   Created:   9/25/01
   Modified: 10/16/01 - added gcd method to reduce fraction
   Modified: 02/19/06 - include licence terms in comments

Description:  This class provides storage for internal
representation of, and methods to manipulate fractions.
A fraction consists of two integers, one for numerator
and one for denominator.  An example fraction is 3/4.
A valid fraction must not have zero in the denominator.

This software is licensed "as-is" under a non-exclusive,
worldwide, royalty-free right to reproduce the software,
prepare derivative works of the software and distribute
the software or any derivative works created.  The user
bears the risk of using it.  No express warranties,
guarantees or conditions are implied.
***********************************************************/

class Fraction
{
   private int numerator, denominator;
   
   //original constructor
   public Fraction()
   {
      numerator =0;
      denominator = 1;
   }
   
   //Modified constuctor
   
   public Fraction(int numerator, int denominator) {
	   this.numerator = numerator;
	   this.denominator = denominator;
   }

   
   public int getNumerator()
   {
      return numerator;
   }
   
   public void setNumerator(int num)
   {
      numerator=num;
   }
   
   public int getDenominator()
   {
      return denominator;
   }
   
   public void setDenominator(int den)
   {
      denominator=den;
   }

   public Fraction add(Fraction b)
   {
      // check preconditions
      if ((denominator == 0) || (b.denominator == 0))
         throw new IllegalArgumentException("invalid denominator");
      // find lowest common denominator
      int common = lcd(denominator, b.denominator);
      // convert fractions to lcd
      Fraction commonA = new Fraction();
      Fraction commonB = new Fraction();
      commonA = convert(common);
      commonB = b.convert(common);
      // create new fraction to return as sum
      Fraction sum = new Fraction();
      // calculate sum
      sum.numerator = commonA.numerator + commonB.numerator;
      sum.denominator = common;
      // reduce the resulting fraction
      sum = sum.reduce();
      return sum;
   }

   public Fraction subtract(Fraction b)
   {
      // check preconditions
      if ((denominator == 0) || (b.denominator == 0))
         throw new IllegalArgumentException("invalid denominator");
      // find lowest common denominator
      int common = lcd(denominator, b.denominator);
      // convert fractions to lcd
      Fraction commonA = new Fraction();
      Fraction commonB = new Fraction();
      commonA = convert(common);
      commonB = b.convert(common);
      // create new fraction to return as difference
      Fraction diff = new Fraction();
      // calculate difference
      diff.numerator = commonA.numerator - commonB.numerator;
      diff.denominator = common;
      // reduce the resulting fraction
      diff = diff.reduce();
      return diff;
   }

   public Fraction multiply(Fraction b)
   {
      // check preconditions
      if ((denominator == 0) || (b.denominator == 0))
         throw new IllegalArgumentException("invalid denominator");
      // create new fraction to return as product
      Fraction product = new Fraction();
      // calculate product
      product.numerator = numerator * b.numerator;
      product.denominator = denominator * b.denominator;
      // reduce the resulting fraction
      product = product.reduce();
      return product;
   }

   public Fraction divide(Fraction b)
   {
      // check preconditions
      if ((denominator == 0) || (b.numerator == 0))
         throw new IllegalArgumentException("invalid denominator");
      // create new fraction to return as result
      Fraction result = new Fraction();
      // calculate result
      result.numerator = numerator * b.denominator;
      result.denominator = denominator * b.numerator;
      // reduce the resulting fraction
      result = result.reduce();
      return result;
   }
   
   
   public String toString()
   {
      String buffer = numerator + "/" + denominator;
      return buffer;
   }

   private int lcd(int denom1, int denom2)
   {
      int factor = denom1;
      while ((denom1 % denom2) != 0)
         denom1 += factor;
      return denom1;
   }

   
   private int gcd(int denom1, int denom2)
   {
      int factor = denom2;
      while (denom2 != 0) {
         factor = denom2;
         denom2 = denom1 % denom2;
         denom1 = factor;
      }
      return denom1;
   }

   
   private Fraction convert(int common)
   {
      Fraction result = new Fraction();
      int factor = common / denominator;
      result.numerator = numerator * factor;
      result.denominator = common;
      return result;
   }

   private Fraction reduce()
   {
      Fraction result = new Fraction();
      int common = 0;
      // get absolute values for numerator and denominator
      int num = Math.abs(numerator);
      int den = Math.abs(denominator);
      // figure out which is less, numerator or denominator
      if (num > den)
         common = gcd(num, den);
      else if (num < den)
         common = gcd(den, num);
      else  // if both are the same, don't need to call gcd
         common = num;

      // set result based on common factor derived from gcd
      result.numerator = numerator / common;
      result.denominator = denominator / common;
      return result;
   }
}

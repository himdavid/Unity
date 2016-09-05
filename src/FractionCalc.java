import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class will perform mathematical operations on fractions
 * Second one of the following operations follow by 2 valid fractions.
 * @author David Him
 *
 */
public class FractionCalc {
	
	/**
	 * No argument constructor
	 */
	public FractionCalc() {
		
	}
	
	/**
	 * Compute the total of two fractions
	 */
	public void compute() {
		
		int numer = 0;
		int denom = 0;

		//The operation menu
		System.out.println("Hello welcome to the fraction calculator \n"
							+ "What would you like to do today? \n"
							+ "1. Add \n"
							+ "2. Subtract \n"
							+ "3. Multiply \n"
							+ "4. Divide \n");
		
		
		Scanner input = new Scanner(System.in);
		String operation = input.nextLine();
		
		System.out.println("Enter the first fraction (example: 1/2): ");
		String first_fraction = input.nextLine().trim();
	
		while(!isValidFraction(first_fraction)){
			System.out.println(first_fraction + " is not valid, please enter a valid fraction");
			first_fraction = input.nextLine();
		}
		String[] first_fraction_array = first_fraction.split("/");
		
		
		System.out.println("Enter the second fraction (example: 2/4): ");
		String second_fraction = input.nextLine().trim();
		while(!isValidFraction(second_fraction)){
			System.out.println(second_fraction + " is not valid, please enter a valid fraction");
			second_fraction = input.nextLine();
		}
		String[] second_fraction_array = second_fraction.split("/");
		
		int numerator1 = Integer.parseInt(first_fraction_array[0]);
		int denominator1 = Integer.parseInt(first_fraction_array[1]);
		int numerator2 = Integer.parseInt(second_fraction_array[0]);
		int denominator2 = Integer.parseInt(second_fraction_array[1]);
		int gcd = commonDivisor(denominator1, denominator2);
		
		switch(operation) {
			case "1": //Addition
				numer = (numerator1*denominator2) + (denominator1*numerator2);
				denom = (denominator1*denominator2);
				break;
			case "2": //Subtraction
				numer = (numerator1*denominator2) - (denominator1*numerator2);
				denom = (denominator1*denominator2);
				break;
			case "3": //Multiplication
				numer = (numerator1*numerator2);
				denom = (denominator1*denominator2);
				break;
			case "4": //Division
				if(denominator1 ==0 || denominator2 == 0){
					System.out.println("Error, cannot divide by 0");
					input.close();
					return;
				}
				numer = (numerator1*denominator2);
				denom = (denominator1*numerator2);
				break;
				
		}
		input.close();
		System.out.println("Total: " + numer/gcd + "/" + denom/gcd);
	}
	
	/**
	 * Find the common divisor for both fractions
	 * @param a the first fraction's denominator
	 * @param b the second fraction's denominator
	 * @return the common divisor
	 */
	public int commonDivisor(int a, int b){
		   if (b==0) return a;
		   return commonDivisor(b,a%b);
		}

	/**
	 * Determine if the fraction follows the expected pattern for a valid fraction
	 * @param str the fraction provided
	 * @return true if valid, false if not
	 */
	public boolean isValidFraction(String str) {
		boolean valid = false;
		Pattern FRACTION_PATTERN = Pattern.compile("(?:(\\d+)\\s+)?(\\d+)/(\\d+)");
		Matcher m = FRACTION_PATTERN.matcher(str);
		
		if(m.matches())	valid = true;
		
	return valid;
}

	public static void main(String[] args) {
		FractionCalc cal = new FractionCalc();
		cal.compute();
	}
}

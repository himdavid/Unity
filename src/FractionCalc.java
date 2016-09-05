import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FractionCalc {
	
	public FractionCalc() {
		
	}
	
	public double compute() {
		
		double total = 0.0;
		double numer = 0.0;
		double denom = 0.0;

		
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
			System.out.println("Please enter a valid fraction");
			first_fraction = input.nextLine();
		}
		
		String[] first_fraction_array = first_fraction.split("/");
		
		System.out.println("Enter the second fraction (example: 2/4): ");
		String second_fraction = input.nextLine();
		String[] second_fraction_array = second_fraction.split("/");
		
		double numerator1 = Double.parseDouble(first_fraction_array[0]);
		double denominator1 = Double.parseDouble(first_fraction_array[1]);
		double numerator2 = Double.parseDouble(second_fraction_array[0]);
		double denominator2 = Double.parseDouble(second_fraction_array[1]);
		
		double gcd = commonDivisor(denominator1, denominator2);
		System.out.println("GCD is: " + gcd);
		
		//Scanner input2 = new Scanner(System.in);
		//String first_fraction = input2.hasNext();
		
		switch(operation) {
			case "1":
				numer = (numerator1*denominator2) + (denominator1*numerator2);
				denom = (denominator1*denominator2);
				total = numer / denom;
				break;
			case "2":
				numer = (numerator1*denominator2) - (denominator1*numerator2);
				denom = (denominator1*denominator2);
				total = numer / denom;
				break;
			case "3":
				numer = (numerator1*numerator2);
				denom = (denominator1*denominator2);
				total = numer / denom;
				break;
			case "4":
				numer = (numerator1*denominator2);
				denom = (denominator1*numerator2);
				total = numer / denom;
				break;
				
		}
		input.close();
		System.out.println(numer/gcd + "/" + denom/gcd);
		return total;
	}
	
	public double commonDivisor(double a, double b){
		   if (b==0) return a;
		   return commonDivisor(b,a%b);
		}
	
	public boolean isValidFraction(String str) {
		boolean valid = false;
		Pattern FRACTION_PATTERN = Pattern.compile("(?:(\\d+)\\s+)?(\\d+)/(\\d+)");
	
	Matcher m = FRACTION_PATTERN.matcher(str);
		if(m.matches()){
			valid = true;
		}
	return valid;
}

	public static void main(String[] args) {
		FractionCalc cal = new FractionCalc();
		cal.compute();

	}

}

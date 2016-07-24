
public class SquareRoot {

	public static void main(String[] args) {
		double n = 16;
		double precision = .00500;
		
		double result = squareRoot(n, precision);
		System.out.println("Number: " + n);
		System.out.println("Precision: " + precision);
		System.out.println("Result: " + result);
	}
	
	public static double squareRoot(double n, double precision) {
		double guess = n/2;
		double result = (guess + n/guess)/2;
		//while (Double.compare(Math.abs(n - Math.pow(result, 2)), precision) > 0) {
		while (Math.abs(n - Math.pow(result, 2)) > precision) {
			guess = result;
			result = (guess + n/guess)/2;
		}
		return result;
	}
}

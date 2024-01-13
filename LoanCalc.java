/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) { //computes ending balance of an n-period loan in bruteForce
		double g = loan / n;
		iterationCounter = 0;
		while (endBalance(loan, rate, n, g) >= 0) {
			iterationCounter++;
			g += epsilon;
			endBalance(loan, rate, n, g); // #feedback - this call for the endBalance function is redundant.
		}
		return g;
	}
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  //computes ending balance of an n-period loan in biSection
		double l = loan / n; //>0
		double h = loan + 1; //<0
		double g = (l+h)/2;

		iterationCounter = 0;

		while ((h - l) > epsilon) {
			if (endBalance(loan, rate, n, g) >= 0) {
				l = g;
			} else {
				h = g;
			}
			g = (l+h)/2;
			iterationCounter++;
		}
		return g;
    }
	private static double endBalance(double loan, double rate, int n, double payment) {
		for (int i = 0; i < n; i++) {
			loan = (loan - payment) * (1 + (rate / 100));
		}
		return loan;
	}
}

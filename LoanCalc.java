/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc 
{
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
	public static void main(String[] args) 
	{		
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
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) 
    {  
    	double loanB = loan;
		double rateB = rate;
		int nB = n;
		double epsilonB = epsilon;
		double g = loanB / nB;

		double endB = 0;

		iterationCounter = 0;

		while(endB >= 0)
		{
			iterationCounter++;
			endB = endBalance(loanB, rateB, nB, g);
			g += epsilonB;
		}

		return g;
	}
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) 
    {  
    	double loanB = loan;
		double rateB = rate;
		int nB = n;
		double epsilonB = epsilon;

		double l = loanB / nB; //>0
		double h = loanB + 1; //<0
		double g = (l+h)/2;

		iterationCounter = 0;

		while((h - l) > epsilonB)
		{
			if(endBalance(loanB, rateB, nB, g) >= 0)
			{
				l = g;
			}
			else
			{
				h = g;
			}

			g = (l+h)/2;

			iterationCounter++;
		}
		return g;
    }
	
	private static double endBalance(double loan, double rate, int n, double payment) 
	{
		double loanE = loan;
    	double rateE = rate;
    	int nE = n;
    	double paymentE = payment;

		for(int i = 0; i < nE; i++)
		{
			loanE = (loanE - paymentE) * (1 + (rateE/100));
		}

		return loanE;
	}
}
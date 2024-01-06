public class test //prints end balance. pelet: loan,  rate,  n,  payment.
{
	public static void main(String[] args) 
	{
		double loanB = Double.parseDouble(args[0]);
		double rateB = Double.parseDouble(args[1]);
		int nB = Integer.parseInt(args[2]);
		double epsilonB = Double.parseDouble(args[3]);
		int iterationCounter = 0;
		double g = loanB / nB;

		double endB = 0;

		iterationCounter = 0;

		while(endB >= 0)
		{
			endB = endBalance(loanB, rateB, nB, g);
			g += epsilonB;
			iterationCounter++;
		}

		System.out.println(g);
		System.out.println(iterationCounter);


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



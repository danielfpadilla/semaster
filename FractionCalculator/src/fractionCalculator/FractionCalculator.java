package fractionCalculator;

public class FractionCalculator {
	private double numerator=1;
	private double denominator=1;
		
	public FractionCalculator() {
		
	}

	public FractionCalculator(double num, double denom) {
		numerator=num;
		denominator=denom;
	}

	public double getNumerator() {
		
		return numerator;
	}

	public double getDenominator() {
		
		return denominator;
	}

	public void setNumeratorAndDenominator(int inNum, int inDeno) {
		numerator=inNum;
		denominator=inDeno;
		
	}

	public String showFraction() {
		
		return numerator+"/"+denominator;
	}

	public void reduce() {
		// TODO Auto-generated method stub
		
	}

	



	
	

}

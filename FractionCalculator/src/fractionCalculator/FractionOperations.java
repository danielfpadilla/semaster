package fractionCalculator;

public class FractionOperations { 
	private FractionCalculator n1=new FractionCalculator();
	private FractionCalculator n2=new FractionCalculator();
	private FractionCalculator result=new FractionCalculator();
	
	public FractionOperations()
	{
		n1.setNum(0);
		n1.setDenom(0);
		n2.setNum(0);
		n2.setDenom(0);
		result.setNum(0);
		result.setDenom(0);
		
	}

	public FractionOperations(FractionCalculator fraction1) {
		n1.setNum(fraction1.getNumerator());
		n1.setDenom(fraction1.getDenominator());
		n2.setNum(0);
		n2.setDenom(0);
		result.setNum(0);
		result.setDenom(0);
	}

	public FractionOperations(FractionCalculator num1, FractionCalculator num2) {
		n1.setNum(num1.getNumerator());
		n1.setDenom(num1.getDenominator());
		n2.setNum(num2.getNumerator());
		n2.setDenom(num2.getDenominator());
		result.setNum(0);
		result.setDenom(0);
	}

	public void addFractions() {
		result.setNum((n1.getNumerator()*n2.getDenominator()) + n2.getNumerator()*n1.getDenominator());
		result.setDenom(n1.getDenominator()*n2.getDenominator());
		//((a*d)+(c*b))/(b*d)
	}

	public void subtractFractions() {
		result.setNum((n1.getNumerator()*n2.getDenominator()) - n2.getNumerator()*n1.getDenominator());
		result.setDenom(n1.getDenominator()*n2.getDenominator());
		//((a*d)-(c*b))/(b*d)
		
	}

	public void multiplyFractions() {
		result.setNum(n1.getNumerator()*n2.getNumerator());
		result.setDenom(n1.getDenominator()*n2.getDenominator());
		//(a*c)/(b*d)
		
	}

	public void divideFractions() {
		if(n2.getNumerator()!=0)
		{
			result.setNum(n1.getNumerator()*n2.getDenominator());
			result.setDenom(n1.getDenominator()*n2.getNumerator());
		}
		else
		{
			System.out.println("operation undefined!");
		}
		//(a*d)/(b*c)
		
	}
	
	
	
	

}

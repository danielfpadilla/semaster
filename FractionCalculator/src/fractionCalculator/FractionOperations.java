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

	public String addFractions(FractionCalculator n1,FractionCalculator n2) {
	    result.setNum((n1.getNumerator()*n2.getDenominator()) + n2.getNumerator()*n1.getDenominator());
		result.setDenom(n1.getDenominator()*n2.getDenominator());
		//((a*d)+(c*b))/(b*d)
		return result.getNumerator()+"/"+result.getDenominator();
		
		 
	}

	public String subtractFractions(FractionCalculator n1, FractionCalculator n2) {
		result.setNum((n1.getNumerator()*n2.getDenominator()) - n2.getNumerator()*n1.getDenominator());
		result.setDenom(n1.getDenominator()*n2.getDenominator());
		//((a*d)-(c*b))/(b*d)
		return result.getNumerator()+"/"+result.getDenominator();
		
	}

	public String multiplyFractions(FractionCalculator n1, FractionCalculator n2) {
		result.setNum(n1.getNumerator()*n2.getNumerator());
		result.setDenom(n1.getDenominator()*n2.getDenominator());
		//(a*c)/(b*d)
		return result.getNumerator()+"/"+result.getDenominator();
		
	}

	public String divideFractions(FractionCalculator n1, FractionCalculator n2) {
		if(n2.getNumerator()!=0)
		{
			result.setNum(n1.getNumerator()*n2.getDenominator());
			result.setDenom(n1.getDenominator()*n2.getNumerator());
			return result.getNumerator()+"/"+result.getDenominator();
		}
		else
		{
			System.out.println("operation undefined!");
			return "null";
		}
		//(a*d)/(b*c)
		
		
	}
	
	
	
	

}

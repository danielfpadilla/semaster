package fractionCalculator;

public class Fraction implements IFraction
{
	private int m_numerator;
	private int m_denominator;
	final double DELTA = 0.001;

	public Fraction()
	{
		m_numerator = 0;
		m_denominator = 1;
	}

	public Fraction(int numerator, int denominator)

	{
		if (denominator != 0)
		{
			m_numerator = numerator;
			m_denominator = denominator;
		}
		else
			throw new IllegalArgumentException("invalid denominator");

	}

	public int getNumerator()
	{

		return m_numerator;

	}

	public int getDenominator()
	{

		return m_denominator;

	}

	public void setNumerator(int numerator)
	{

		m_numerator = numerator;
	}

	public void setDenominator(int denominator)
	{

		m_denominator = denominator;
	}

	public String toString()
	{

		return m_numerator + "/" + m_denominator;

	}

	public  void reduceFraction(Fraction myFraction)
	{
		int greatestCommonDivisor = 1;
		int x;
		if (myFraction.m_numerator > myFraction.m_denominator)
		{
			x = myFraction.m_denominator;
		}
		else
		{
			x = myFraction.m_numerator;
		}
		greatestCommonDivisor = x;
		while (!((myFraction.m_numerator % greatestCommonDivisor) == 0)
				&& ((myFraction.m_denominator % greatestCommonDivisor) == 0))
		{

			x--;
			greatestCommonDivisor = x;

		}

		myFraction.m_numerator = myFraction.m_numerator / greatestCommonDivisor;
		myFraction.m_denominator = myFraction.m_denominator
				/ greatestCommonDivisor;

	}

	public double convertToDouble(Fraction fraction)
	{
		double result = (double) fraction.m_numerator
				/ (double) fraction.m_denominator;
		return result;
	}

	public boolean equals(Object otherObject)
	{
		Fraction otherNumber = (Fraction) otherObject;
		if (Math.abs(m_numerator - otherNumber.m_numerator) < DELTA
				&& Math.abs(m_denominator - otherNumber.m_denominator) < DELTA)
			return true;
		else
			return false;

	}

	public  Fraction addFractions(Fraction n1, Fraction n2)
	{   Fraction result = new Fraction();
		result.setNumerator((n1.getNumerator() * n2.getDenominator())
				+ n2.getNumerator() * n1.getDenominator());
		result.setDenominator(n1.getDenominator() * n2.getDenominator());
		// ((a*d)+(c*b))/(b*d)
		result.reduceFraction(result);
		return result;

	}

	public  Fraction subtractFractions(Fraction n1, Fraction n2)
	{
		Fraction result = new Fraction();
		result.setNumerator((n1.getNumerator() * n2.getDenominator())
				- n2.getNumerator() * n1.getDenominator());
		result.setDenominator(n1.getDenominator() * n2.getDenominator());
		// ((a*d)-(c*b))/(b*d)
		result.reduceFraction(result);
		return result;

	}

	public Fraction multiplyFractions(Fraction n1, Fraction n2)
	{   
		Fraction result = new Fraction();
		result.setNumerator(n1.getNumerator() * n2.getNumerator());
		result.setDenominator(n1.getDenominator() * n2.getDenominator());
		// (a*c)/(b*d)
		result.reduceFraction(result);
		return result;

	}

	public  Fraction divideFractions(Fraction n1, Fraction n2)
	{  
		Fraction result = new Fraction();
		if (n2.getNumerator() != 0)
		{
			result.setNumerator(n1.getNumerator() * n2.getDenominator());
			result.setDenominator(n1.getDenominator() * n2.getNumerator());
			// (a*d)/(b*c)
			result.reduceFraction(result);
			return result;
		}

		else
		{
			throw new IllegalArgumentException("invalid denominator");

		}

	}

}



public class Fraction implements IFraction
{
	private int m_numerator;
	private int m_denominator;
	final double DELTA = 0.001;

	public Fraction()
	{
		m_numerator = 1;
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

	public static int greatestCommonDivisor(int a, int b)
	{

		if (b == 0)
			return a;
		else
			return greatestCommonDivisor(b, a % b);
	}

	public void reduceFraction()
	{
		int num = greatestCommonDivisor(m_numerator,
				m_denominator);

		m_numerator = m_numerator / num;
		m_denominator = m_denominator / num;

	}

	public double toDouble()
	{
		double result = (double) m_numerator
				/ (double) m_denominator;
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

	public Fraction addFractions(Fraction myFraction)
	{
		Fraction result = new Fraction();
		result.setNumerator((myFraction.getNumerator() * this.getDenominator())
				+ this.getNumerator() * myFraction.getDenominator());
		result.setDenominator(myFraction.getDenominator() * this.getDenominator());
		// ((a*d)+(c*b))/(b*d)
		result.reduceFraction();
		return result;

	}

	public Fraction subtractFractions(Fraction fraction1)
	{
		Fraction result = new Fraction();
		result.setNumerator((fraction1.getNumerator() * this.getDenominator())
				- this.getNumerator() * fraction1.getDenominator());
		result.setDenominator(fraction1.getDenominator() * this.getDenominator());
		// ((a*d)-(c*b))/(b*d)
		result.reduceFraction();
		return result;

	}

	public Fraction multiplyFractions(Fraction fraction1)
	{
		Fraction result = new Fraction();
		result.setNumerator(fraction1.getNumerator() * this.getNumerator());
		result.setDenominator(fraction1.getDenominator() * this.getDenominator());
		// (a*c)/(b*d)
		result.reduceFraction();
		return result;

	}

	public Fraction divideFractions(Fraction fraction1)
	{
		Fraction result = new Fraction();
		if (this.getNumerator() != 0)
		{
			result.setNumerator(fraction1.getNumerator() * this.getDenominator());
			result.setDenominator(fraction1.getDenominator() * this.getNumerator());
			// (a*d)/(b*c)
			result.reduceFraction();
			return result;
		}

		else
		{
			throw new IllegalArgumentException("invalid denominator");

		}

	}

}
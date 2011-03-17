package fractionCalculator;

public class FractionOperations
{
	Fraction fraction1 = new Fraction();
	Fraction fraction2 = new Fraction();
	static Fraction result = new Fraction();

	public FractionOperations()
	{
		fraction1.setNumerator(0);
		fraction1.setDenominator(0);
		fraction2.setNumerator(0);
		fraction2.setDenominator(0);
		result.setNumerator(0);
		result.setDenominator(0);

	}

	public FractionOperations(Fraction fraction)
	{
		fraction1.setNumerator(fraction.getNumerator());
		fraction1.setDenominator(fraction.getDenominator());
		fraction2.setNumerator(0);
		fraction2.setDenominator(0);
		result.setNumerator(0);
		result.setDenominator(0);
	}

	public FractionOperations(Fraction num1, Fraction num2)
	{
		fraction1.setNumerator(num1.getNumerator());
		fraction1.setDenominator(num1.getDenominator());
		fraction2.setNumerator(num2.getNumerator());
		fraction2.setDenominator(num2.getDenominator());
		result.setNumerator(0);
		result.setDenominator(0);
	}

	public static Fraction addFractions(Fraction n1, Fraction n2)
	{
		result.setNumerator((n1.getNumerator() * n2.getDenominator())
				+ n2.getNumerator() * n1.getDenominator());
		result.setDenominator(n1.getDenominator() * n2.getDenominator());
				// ((a*d)+(c*b))/(b*d)
		Fraction.reduceFraction(result);
		return result;

	}

	public static Fraction subtractFractions(Fraction n1, Fraction n2)
	{
		result.setNumerator((n1.getNumerator() * n2.getDenominator())
				- n2.getNumerator() * n1.getDenominator());
		result.setDenominator(n1.getDenominator() * n2.getDenominator());
		// ((a*d)-(c*b))/(b*d)
		Fraction.reduceFraction(result);
		return result;

	}

	public static Fraction multiplyFractions(Fraction n1, Fraction n2)
	{
		result.setNumerator(n1.getNumerator() * n2.getNumerator());
		result.setDenominator(n1.getDenominator() * n2.getDenominator());
		// (a*c)/(b*d)
		Fraction.reduceFraction(result);
		return result;

	}

	public static Fraction divideFractions(Fraction n1, Fraction n2)
	{
		if (n2.getNumerator() != 0)
		{
			result.setNumerator(n1.getNumerator() * n2.getDenominator());
			result.setDenominator(n1.getDenominator() * n2.getNumerator());
			// (a*d)/(b*c)
			Fraction.reduceFraction(result);
			return result;
		}

		else
		{
			throw new IllegalArgumentException("invalid denominator");

		}

	}

}

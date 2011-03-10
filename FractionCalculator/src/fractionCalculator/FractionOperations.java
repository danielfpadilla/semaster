package fractionCalculator;

public class FractionOperations {
	Fraction n1 = new Fraction();
	Fraction n2 = new Fraction();
	static Fraction result = new Fraction(1, 2);

	public FractionOperations() {
		n1.setNumerator(0);
		n1.setDenominator(0);
		n2.setNumerator(0);
		n2.setDenominator(0);
		result.setNumerator(0);
		result.setDenominator(0);

	}

	public FractionOperations(Fraction fraction1) {
		n1.setNumerator(fraction1.getNumerator());
		n1.setDenominator(fraction1.getDenominator());
		n2.setNumerator(0);
		n2.setDenominator(0);
		result.setNumerator(0);
		result.setDenominator(0);
	}

	public FractionOperations(Fraction num1, Fraction num2) {
		n1.setNumerator(num1.getNumerator());
		n1.setDenominator(num1.getDenominator());
		n2.setNumerator(num2.getNumerator());
		n2.setDenominator(num2.getDenominator());
		result.setNumerator(0);
		result.setDenominator(0);
	}

	public String addFractions(Fraction n1, Fraction n2) {
		result.setNumerator((n1.getNumerator() * n2.getDenominator())
				+ n2.getNumerator() * n1.getDenominator());
		result.setDenominator(n1.getDenominator() * n2.getDenominator());
		// ((a*d)+(c*b))/(b*d)
		// result.getNumerator() + "/" + result.getDenominator()
		return result.getNumerator() + "/" + result.getDenominator();

	}

	public String subtractFractions(Fraction n1, Fraction n2) {
		result.setNumerator((n1.getNumerator() * n2.getDenominator())
				- n2.getNumerator() * n1.getDenominator());
		result.setDenominator(n1.getDenominator() * n2.getDenominator());
		// ((a*d)-(c*b))/(b*d)
		return result.getNumerator() + "/" + result.getDenominator();

	}

	public String multiplyFractions(Fraction n1, Fraction n2) {
		result.setNumerator(n1.getNumerator() * n2.getNumerator());
		result.setDenominator(n1.getDenominator() * n2.getDenominator());
		// (a*c)/(b*d)
		return result.getNumerator() + "/" + result.getDenominator();

	}

	public static String divideFractions(Fraction n1, Fraction n2) {
		if (n2.getNumerator() != 0) {
			result.setNumerator(n1.getNumerator() * n2.getDenominator());
			result.setDenominator(n1.getDenominator() * n2.getNumerator());
			return result.getNumerator() + "/" + result.getDenominator();
		}

		else {
			throw new IllegalArgumentException("invalid denominator");

		}
		// (a*d)/(b*c)

	}

}

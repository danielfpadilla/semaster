package fractionCalculator;

public class Fraction {
	private int numerator;
    private int denominator;

	public Fraction() {
		numerator = 0;
		denominator = 1;
	}

	public Fraction(int num, int denom) 
	
	{
		if (denom != 0) {

			numerator = num;
			denominator = denom;
		} else
			throw new IllegalArgumentException ("invalid denominator");

	}

	public int getNumerator() {

		return numerator;

	}

	public int getDenominator() {

		return denominator;

	}

	public void setNumerator(int inNum) {

		numerator = inNum;
	}

	public void setDenominator(int inDenom) {

		denominator = inDenom;
	}

	public String toString() {

		return numerator + "/" + denominator;

	}

	public String reduceFraction() {

		int greatestCommonDivisor = 1;
		int x;
		if (numerator > denominator) {
			x = denominator;
		} else {
			x = numerator;
		}
		greatestCommonDivisor = x;
		while (!((numerator % greatestCommonDivisor) == 0) && ((denominator % greatestCommonDivisor) == 0)) {

			x--;
			greatestCommonDivisor = x;

		}

		numerator = numerator / greatestCommonDivisor;
		denominator = denominator / greatestCommonDivisor;
		return numerator + "/" + denominator;

	}

	}
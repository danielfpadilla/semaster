package fractionCalculator;

public class Fraction {
    private int numerator;
	private int denominator;
	double delta = 0.001;

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
			throw new IllegalArgumentException("invalid denominator");

	}

	public int getNumerator() {

		return numerator;

	}

	public int getDenominator() {

		return denominator;

	}

	public  void setNumerator(int inNum) {

		numerator = inNum;
	}

	public  void setDenominator(int inDenom) {

		denominator = inDenom;
	}

	public String toString() {

		return numerator + "/" + denominator;

	}

	public static void reduceFraction(Fraction myFraction) {
		int greatestCommonDivisor = 1;
		int x;
		if (myFraction.numerator > myFraction.denominator) {
			x = myFraction.denominator;
		} else {
			x = myFraction.numerator;
		}
		greatestCommonDivisor = x;
		while (!((myFraction.numerator % greatestCommonDivisor) == 0)
				&& ((myFraction.denominator % greatestCommonDivisor) == 0)) {

			x--;
			greatestCommonDivisor = x;

		}

		myFraction.numerator = myFraction.numerator / greatestCommonDivisor;
		myFraction.denominator = myFraction.denominator / greatestCommonDivisor;

	}

	public double convertToDouble(Fraction fraction) {
		double result = (double) fraction.numerator
				/ (double) fraction.denominator;
		return result;
	}

	public boolean equals(Object otherObject) {
		Fraction otherNumber = (Fraction) otherObject;
		if (Math.abs(numerator - otherNumber.numerator) < delta
				&& Math.abs(denominator - otherNumber.denominator) < delta)
			return true;
		else
			return false;

	}

	public Fraction clone() {
		Fraction fraction=new Fraction();
		fraction.numerator=numerator;
		fraction.denominator=denominator;
		return fraction;
	}

}
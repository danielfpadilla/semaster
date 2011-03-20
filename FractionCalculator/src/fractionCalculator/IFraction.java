package fractionCalculator;

public interface IFraction
{
	public void reduceFraction(Fraction myFraction);
	public double convertToDouble(Fraction fraction);
	public Fraction addFractions(Fraction n1, Fraction n2);
	public Fraction subtractFractions(Fraction n1, Fraction n2);
	public Fraction multiplyFractions(Fraction n1, Fraction n2);
	public Fraction divideFractions(Fraction n1, Fraction n2);

}

package edu.Semaster.FractionCalculator.Model;

public interface IFraction
{
	public void reduce();

	public double toDouble();

	public IFraction add(IFraction fraction2);

	public IFraction subtract(IFraction fraction2);

	public IFraction multiply(IFraction fraction2);

	public IFraction divide(IFraction fraction1);

	public int getNumerator();

	public int getDenominator();

	public void setNumerator(int i);

	public void setDenominator(int i);

}

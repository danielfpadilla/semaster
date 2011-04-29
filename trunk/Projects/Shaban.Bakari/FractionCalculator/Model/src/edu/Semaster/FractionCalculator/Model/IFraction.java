package edu.Semaster.FractionCalculator.Model;

public interface IFraction
{
	public void reduce();

	public double toDouble();

	public Fraction add(Fraction fraction1);

	public Fraction subtract(Fraction fraction1);

	public Fraction multiply(Fraction fraction1);

	public Fraction divide(Fraction fraction1);

}

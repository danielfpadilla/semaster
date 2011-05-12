package edu.Semaster.FractionCalculator.Model.Tests;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import edu.Semaster.FractionCalculator.Model.Fraction;

public class FractionTest
{
	private int m_numerator = 1;
	private int m_denominator = 1;
	private final double DELTA = 0.002;

	@Test
	public void createFraction()
	{
		Fraction fraction = new Fraction();
		Assert.assertNotNull(fraction);
	}

	@Test
	public void canInitializeFraction()
	{
		Fraction fraction = new Fraction(m_numerator, m_denominator);
		Assert.assertNotNull(fraction);

	}

	@Test
	public void canGetNumerator()
	{

		Fraction fractionCalculator = new Fraction();

		Assert.assertEquals(1, fractionCalculator.getNumerator());

	}

	@Test
	public void canGetDenominator()
	{

		Fraction fractionCalculator = new Fraction();

		Assert.assertEquals(m_denominator, fractionCalculator.getDenominator());
	}

	@Test
	public void canSetNumerator()
	{

		Fraction fractionCalculator = new Fraction();

		fractionCalculator.setNumerator(m_numerator);

		Assert.assertEquals(m_numerator, fractionCalculator.getNumerator());
	}

	@Test
	public void canSetDenomenator()
	{

		Fraction fractionCalculator = new Fraction();

		fractionCalculator.setDenominator(m_denominator);

		Assert.assertEquals(m_denominator, fractionCalculator.getDenominator());
	}

	@Test
	public void canThrowExceptionIfDenomenatorIsZero() throws Exception
	{
		try
		{
			new Fraction(1, 0);
			fail("denominator is zero");
		}
		catch (IllegalArgumentException expected)
		{
		}
	}

	@Test
	public void canShowTheFraction()
	{

		Fraction fractionCalculator = new Fraction(m_numerator, m_denominator);

		Assert.assertEquals("1/1", fractionCalculator.toString());
	}

	@Test
	public void canCalculateGcdOfTwoNumbers()
	{
		Fraction fraction = new Fraction(6, 18);

		int result = Fraction.greatestCommonDivisor(fraction.getNumerator(),
				fraction.getDenominator());
		Assert.assertEquals(6, result);
	}

	@Test
	public void canReduceFractionToSimplestForm()
	{
		Fraction fraction2 = new Fraction(6, 8);
		fraction2.reduce();
		Assert.assertEquals(3, fraction2.getNumerator());
		Assert.assertEquals(4, fraction2.getDenominator());
	}

	@Test
	public void canAddFractions()
	{
		Fraction fraction = new Fraction();
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fractionSum = new Fraction(3, 2);

		Assert.assertEquals(fractionSum, fraction.add(fraction1));
	}

	@Test
	public void canSubstract()
	{
		Fraction fraction = new Fraction();
		Fraction fraction1 = new Fraction(1, 4);
		Fraction fractionSubtraction = new Fraction(-3, 4);

		Assert.assertEquals(fractionSubtraction, fraction.subtract(fraction1));
	}

	@Test
	public void canMultiplyFractions()
	{
		Fraction fraction = new Fraction();
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fractionMultiplication = new Fraction(1, 2);

		Assert.assertEquals(fractionMultiplication,
				fraction.multiply(fraction1));
	}

	@Test
	public void canDivideFractions()
	{
		Fraction fraction = new Fraction();
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fractionDivision = new Fraction(1, 2);

		Assert.assertEquals(fractionDivision, fraction.divide(fraction1));
	}

	@Test
	public void canThrowExceptionWhenDividingByZero() throws Exception
	{
		try
		{
			Fraction fraction = new Fraction();
			Fraction fraction1 = new Fraction(1, 0);
			fraction.divide(fraction1);
			fail("can not divide by zero");
		}
		catch (IllegalArgumentException expected)
		{
		}
	}

	@Test
	public void canConvertTheFractionToDoubleValue()
	{
		Fraction fraction = new Fraction(1, 2);
		double result = fraction.toDouble();
		Assert.assertEquals(0.5, result, DELTA);
	}

}

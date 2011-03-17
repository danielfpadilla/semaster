package fractionCalculator;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;

import fractionCalculator.Fraction;

public class FractionTest {
	private int m_numerator = 0;
	private int m_denominator = 1;
	private final double DELTA = 0.002;

	@Test
	public void createFractionCalculator()

	{

		Fraction fractionCalculator = new Fraction();

		Assert.assertNotNull(fractionCalculator);

	}

	@Test
	public void canInitializeFractionCalculator()

	{
		Fraction fractionCalculator = new Fraction(m_numerator, m_denominator);
		Assert.assertNotNull(fractionCalculator);

	}

	@Test
	public void canGetNumerator()

	{

		Fraction fractionCalculator = new Fraction();

		Assert.assertEquals(0, fractionCalculator.getNumerator());

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
	public void canThrowExceptionIfDenomenatorIsZero() throws Exception {
		try {
			new Fraction(1, 0);
			fail("denominator is zero");
		} catch (IllegalArgumentException expected) {
		}
	}

	@Test
	public void canShowTheFraction()

	{

		Fraction fractionCalculator = new Fraction(m_numerator, m_denominator);

		Assert.assertEquals("0/1", fractionCalculator.toString());

	}

	@Test
	public void canReduceFractionToSimplestForm()

	{
		Fraction fraction2 = new Fraction(4, 8);
		Fraction.reduceFraction(fraction2);
		Assert.assertEquals(1, fraction2.getNumerator());
		Assert.assertEquals(2, fraction2.getDenominator());

	}

	@Test
	public void createFractionOperations() {
		FractionOperations fractionOperations = new FractionOperations();
		Assert.assertNotNull(fractionOperations);
	}

	@Test
	public void canInitializeFractionOperations() {
		Fraction fractionCalculator = new Fraction();
		FractionOperations fractionOperations = new FractionOperations(
				fractionCalculator);
		Assert.assertNotNull(fractionOperations);

	}

	@Test
	public void canInitializewithTwoOjects() {
		Fraction fraction1 = new Fraction();
		Fraction fraction2 = new Fraction();
		FractionOperations fractionOperations = new FractionOperations(
				fraction1, fraction2);
		Assert.assertNotNull(fractionOperations);
	}

	@Test
	public void canAddFractions() {
		Fraction fraction1 = new Fraction(1, 4);
		Fraction fraction2 = new Fraction(1, 4);
		Fraction fractionSum = new Fraction(1, 2);

		Assert.assertEquals(fractionSum,
				FractionOperations.addFractions(fraction1, fraction2));

	}

	@Test
	public void canSubstract() {
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(1, 4);
		Fraction fractionSubtraction = new Fraction(1, 4);

		Assert.assertEquals(fractionSubtraction,
				FractionOperations.subtractFractions(fraction1, fraction2));
	}

	@Test
	public void canMultiplyFractions() {
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(1, 4);
		Fraction fractionMultiplication = new Fraction(1, 8);

		Assert.assertEquals(fractionMultiplication,
				FractionOperations.multiplyFractions(fraction1, fraction2));
	}

	@Test
	public void canDivideFractions() {
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(1, 4);
		Fraction fractionDivision = new Fraction(2, 1);

		Assert.assertEquals(fractionDivision,
				FractionOperations.divideFractions(fraction1, fraction2));
	}

	@Test
	public void canThrowExceptionWhenDividingByZero() throws Exception {
		try {
			Fraction fraction1 = new Fraction(1, 2);
			Fraction fraction2 = new Fraction(0, 3);
			FractionOperations.divideFractions(fraction1, fraction2);
			fail("can not divide by zero");
		} catch (IllegalArgumentException expected) {
		}
	}

	@Test
	public void canConvertTheFractionToDoubleValue() {
		Fraction fraction = new Fraction(1, 2);
		double result = fraction.convertToDouble(fraction);
		Assert.assertEquals(0.5, result, DELTA);
	}
	
}

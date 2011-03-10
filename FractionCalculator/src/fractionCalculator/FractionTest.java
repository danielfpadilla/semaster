package fractionCalculator;

import static org.junit.Assert.*;

import org.junit.Test;
import junit.framework.Assert;

import fractionCalculator.Fraction;

public class FractionTest {
	int number = 0;
	int denominator = 1;
	double delta = 0.00001;

	@Test
	public void createFractionCalculator()

	{

		Fraction fractionCalculator = new Fraction();

		Assert.assertNotNull(fractionCalculator);

	}

	@Test
	public void canInitializeFractionCalculator()

	{
		Fraction fractionCalculator = new Fraction(number, denominator);
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

		Assert.assertEquals(denominator, fractionCalculator.getDenominator());

	}

	@Test
	public void canSetNumerator()

	{

		Fraction fractionCalculator = new Fraction();

		fractionCalculator.setNumerator(number);

		Assert.assertEquals(number, fractionCalculator.getNumerator());

	}

	@Test
	public void canSetDenomenator()

	{

		Fraction fractionCalculator = new Fraction();

		fractionCalculator.setDenominator(denominator);

		Assert.assertEquals(denominator, fractionCalculator.getDenominator());

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

		Fraction fractionCalculator = new Fraction(number, denominator);

		Assert.assertEquals("0/1", fractionCalculator.toString());

	}

	@Test
	public void canReduceFractionToSimplestForm()

	{

		Fraction fractionCalculator = new Fraction(4, 8);

		Assert.assertEquals("1/2", fractionCalculator.reduceFraction());

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
		FractionOperations fractionOperations = new FractionOperations();
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(2, 2);
		// Fraction fractionSum = new Fraction(6, 4);

		Assert.assertEquals("6/4",
				fractionOperations.addFractions(fraction1, fraction2));

	}

	@Test
	public void canSubstract() {
		FractionOperations fractionOperations = new FractionOperations();
		Fraction fraction1 = new Fraction(0, 2);
		Fraction fraction2 = new Fraction(1, 4);

		Assert.assertEquals("-2/8",
				fractionOperations.subtractFractions(fraction1, fraction2));
	}

	@Test
	public void canMultiplyFractions() {
		FractionOperations fractionOperations = new FractionOperations();
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(1, 4);

		Assert.assertEquals("1/8",
				fractionOperations.multiplyFractions(fraction1, fraction2));
	}

	@Test
	public void canDivideFractions() {
		// FractionOperations fractionOperations = new FractionOperations();
		Fraction fraction1 = new Fraction(1, 2);
		Fraction fraction2 = new Fraction(1, 4);

		Assert.assertEquals("4/2",
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

}

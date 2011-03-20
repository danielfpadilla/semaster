import org.junit.Test;
import junit.framework.Assert;

public class ComplexNumberTest
{

	public final double delta = 0.001;

	@Test
	public void canCreateComplexNumberWithInitialValues()
	{
		ComplexNumber number = new ComplexNumber(1, 1);
		Assert.assertNotNull(number);
	}

	@Test
	public void canSetInitialRealValue()
	{
		ComplexNumber number = new ComplexNumber(1, 2);
		Assert.assertEquals(1.0, number.getReal(), delta);
	}

	@Test
	public void canSetInitialImaginaryValue()
	{
		ComplexNumber number = new ComplexNumber(1, 2);
		Assert.assertEquals(2.0, number.getImaginary(), delta);
	}

	@Test
	public void areEqualNumbersEqual()
	{
		ComplexNumber number1 = new ComplexNumber(3.14, 2.73);
		ComplexNumber number2 = new ComplexNumber(3.14, 2.73);
		Assert.assertTrue(number1.equals(number2));
	}

	@Test
	public void areNumbersWithDifferentRealPartNotEqual()
	{
		ComplexNumber number1 = new ComplexNumber(1.00, 2.73);
		ComplexNumber number2 = new ComplexNumber(3.14, 2.73);
		Assert.assertFalse(number1.equals(number2));
	}

	@Test
	public void areNumbersWithDifferentImaginaryPartNotEqual()
	{
		ComplexNumber number1 = new ComplexNumber(3.14, 1.00);
		ComplexNumber number2 = new ComplexNumber(3.14, 2.73);
		Assert.assertFalse(number1.equals(number2));
	}

	@Test
	public void canAddNumbers()
	{
		ComplexNumber number1 = new ComplexNumber(1, 2);
		ComplexNumber number2 = new ComplexNumber(3, 4);
		ComplexNumber sum = number1.add(number2);
		Assert.assertEquals(new ComplexNumber(4, 6), sum);
	}

	@Test
	public void canAddNumbersWithNegativePart()
	{
		ComplexNumber number1 = new ComplexNumber(-1, 2);
		ComplexNumber number2 = new ComplexNumber(3, -4);
		ComplexNumber sum = number1.add(number2);
		Assert.assertTrue(sum.equals(new ComplexNumber(2, -2)));
	}

	@Test
	public void canMultiplyNumbers()
	{
		ComplexNumber number1 = new ComplexNumber(1, 2);
		ComplexNumber number2 = new ComplexNumber(3, 4);
		ComplexNumber sum = number1.multiply(number2);
		Assert.assertEquals(new ComplexNumber(-5, 10), sum);
	}

	@Test
	public void canConvertToString()
	{
		ComplexNumber number = new ComplexNumber(1, 2);
		Assert.assertEquals("1.0 + 2.0i", number.toString());
	}

	@Test
	public void canConvertFloatingComplexNumberToString()
	{
		ComplexNumber number = new ComplexNumber(3.14, 2);
		Assert.assertEquals("3.14 + 2.0i", number.toString());
	}

	@Test
	public void canConvertScientificFormatToString()
	{
		ComplexNumber number = new ComplexNumber(1, 1.2456e-2);
		Assert.assertEquals("1.0 + 0.012456i", number.toString());
	}

	@Test
	public void canConvertNegativeRealPartToString()
	{
		ComplexNumber number = new ComplexNumber(-1, 1);
		Assert.assertEquals("-1.0 + 1.0i", number.toString());
	}

	@Test
	public void canConvertNegativeImaginaryPartToString()
	{
		ComplexNumber number = new ComplexNumber(1, -1);
		Assert.assertEquals("1.0 - 1.0i", number.toString());
	}
}

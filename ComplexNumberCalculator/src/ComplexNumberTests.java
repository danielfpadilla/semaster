import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;


public class ComplexNumberTests
{
	private double delta = 0.01;
	@Test
	public void CanCreateComplexNumber()
	{
		ComplexNumber number = new ComplexNumber();
		Assert.assertNotNull(number);
	}
	
	@Test
	public void CanInitializeComplexNumberWithRealAndImaginaryPart()
	{
		ComplexNumber number = new ComplexNumber(4, 2);
		Assert.assertNotNull(number);
	}
	
	@Test
	public void CanSetRealPartOfComplexNumber()
	{
		ComplexNumber number = new ComplexNumber(4, 2);
		Assert.assertEquals(4, number.real, delta);
	} 
	@Test
	public void CanSetImaginaryPartOfComplrxNumber()
	{
		ComplexNumber number = new ComplexNumber(4, 2);
		Assert.assertEquals(2, number.m_imaginary, delta);
	}
	
	@Test
	public void AreEqualComplexNumbersEqual()
	{
		ComplexNumber number1 = new ComplexNumber(4, 2);
		ComplexNumber number2 = new ComplexNumber(4, 2);
		Assert.assertEquals(number1, number2);
	}
	@Test
	public void AreNotEqualCOmplexNumbers()
	{
		ComplexNumber number1=new ComplexNumber(4,2);
		ComplexNumber number2=new ComplexNumber(3,2);
		//Assert.failNotEquals("",number1, number2);
		Assert.assertTrue(!number1.equals(number2));
	}
}

import org.junit.Test;
import junit.framework.Assert;

public class CalculatorTest
{

	private final double delta = 0.001;

	@Test
	public void ReturnOneTest()
	{
		Calculator calculator = new Calculator();
		Assert.assertEquals(1, calculator.ReturnOne());
	}

	@Test
	public void CanAdd2n2()
	{
		Calculator calculator = new Calculator();
		Assert.assertEquals(4.0, calculator.Add(2.0, 2.0), delta);
	}

	@Test
	public void CanAdd1Minus1()
	{
		Calculator calculator = new Calculator();
		Assert.assertEquals(0.0, calculator.Add(1.0, -1.0), delta);
	}
}
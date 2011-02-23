package surfaceAreaCalculator;

import org.junit.Assert;
import org.junit.Test;

public class SurfaceAreaCalculatorTest {
	@Test
	public void CanCreateASurfaceAreaCalculator()
	{
		SurfaceAreaCalculator calculator = new SurfaceAreaCalculator();
		Assert.assertNotNull(calculator);
	}

}

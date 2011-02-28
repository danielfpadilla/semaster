package surfaceAreaTestingFrameWork;
import surfaceAreaCalculator.SurfaceAreaCalculator;

import org.junit.Assert;


public class surfaceAreaTest {
	public void CanCreateASurfaceAreaCalculator()
	{
		SurfaceAreaCalculator calculator = new SurfaceAreaCalculator();
		Assert.assertNotNull(calculator);
		
	}

}

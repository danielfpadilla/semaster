import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ThirdInitialMomentForEquiprobabilityDistributionTest 
{	Statistics statistics = new Statistics();
	private final double DELTA = 1e-8;
	
	@Test public void CanCalculateInitialMoment()
	{	double[] array;
		array = new double[1];
		array[0] = 1.0;
		double third = statistics.thirdInitialMomentForEquiprobabilityDistribution(array);
		assertEquals(1.0, third, DELTA);		
	}
	
	@Test public void CanCalculateInitialMomentForArray()
	{	double[] array;
		array = new double[3];
		array[0] = 1.0; array[1] = 2.0; array[2] = 3.0;
		double third = statistics.thirdInitialMomentForEquiprobabilityDistribution(array);
		assertEquals(12.0, third, DELTA);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class) 
	public void ThrowExceptionIfSizeLessThen1()
	{	double[] array;
		array = new double[0];
		array[0] = 1.0;
		double third = statistics.thirdInitialMomentForEquiprobabilityDistribution(array);
		assertEquals(1.0, third, DELTA);
	}

}
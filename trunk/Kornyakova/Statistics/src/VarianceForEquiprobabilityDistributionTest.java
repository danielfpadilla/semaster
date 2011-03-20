import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VarianceForEquiprobabilityDistributionTest 
{	private final double DELTA = 1e-8;
	Statistics statistics = new Statistics();
	
	@Test public void CanCalculateVariance()
	{	double[] array;
		array = new double[1];
		array[0] = 1.0;
		double variance = statistics.varianceForEquiprobabilityDistribution(array);
		assertEquals(0.0, variance, DELTA);
	}
	
	@Test public void CanCalculateVarianceForArray()
	{	double[] array;
		array = new double[3];
		array[0] = 1.0; 
		array[1] = 2.0; 
		array[2] = 3.0;
		double variance = statistics.varianceForEquiprobabilityDistribution(array);
		assertEquals( 0.666666666, variance, DELTA);
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class)
	public void ThrowExceptionIfSizeLess1()
	{	double[] array;
		array = new double[0];
		double variance = statistics.varianceForEquiprobabilityDistribution(array);
		assertEquals( 0.666666666, variance, DELTA);
	}
}

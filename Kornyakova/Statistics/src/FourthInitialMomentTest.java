import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FourthInitialMomentTest
{
	Statistics statistics = new Statistics();
	private final double DELTA = 1e-8;
	
	@Test public void CanCalculateInitialMoment()
	{	double[] array;
		array = new double[1];
		array[0] = 1.0;
		double fourth = statistics.thirdInitialMoment(array);
		assertEquals(1.0, fourth, DELTA);
	}
	
	@Test public void CanCalculateInitialMomentForArray()
	{	double[] array;
		array = new double[3];
		array[0] = 1.0; array[1] = 2.0; array[2] = 3.0;
		double fourth = statistics.fourthInitialMoment(array);
		assertEquals(32.66666666666666, fourth, DELTA);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void ThrowExceptionIfSizeLessThen1()
	{	double[] array;
		array = new double[0];
		array[0] = 1.0;
		double fourth = statistics.fourthInitialMoment(array);
		assertEquals(1.0, fourth, DELTA);
	}
}

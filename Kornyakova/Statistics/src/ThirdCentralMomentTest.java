import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ThirdCentralMomentTest 
{	private final double DELTA = 1e-8;
	Statistics statistics = new Statistics();
	
	@Test public void CanCalculateThirdMoment()
	{	double[] array;
		array = new double[1];
		array[0] = 1.0;
		double third = statistics.ThirdCentralMoment(array);
		assertEquals(0.0, third, DELTA);
	}
	
	@Test public  void CanCalculateThirdMomentForArray()
	{	double[] array;
		array = new double[2];
		array[0] = 1.0; array[1] = 2.0;
		double third = statistics.ThirdCentralMoment(array);
		assertEquals(0.0, third, DELTA);
	}

}

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VarianceTest {
	private final double delta = 1e-8;
	Statistics stat = new Statistics();
	
	@Test public void CanCalculateVariance(){
		double[] array;
		array = new double[1];
		array[0] = 1.0;
		double variance = stat.Variance(array);
		assertEquals(0.0, variance, delta);
	}
	
	@Test public void CanCalculateVarianceForArray(){
		double array[];
		array = new double[3];
		array[0] = 1.0; array[1] = 2.0; array[2] = 3.0;
		double variance = stat.Variance(array);
		assertEquals( 0.666666666, variance, delta);
	}
	
	@Test (expected = ArrayIndexOutOfBoundsException.class) public void ThrowExceptionIfSizeLess1(){
		double array[];
		array = new double[0];
		double variance = stat.Variance(array);
		assertEquals( 0.666666666, variance, delta);
	}
}

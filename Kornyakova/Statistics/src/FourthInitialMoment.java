import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FourthInitialMoment {
	Statistics stat = new Statistics();
	private final double delta = 1e-8;
	
	@Test public void CanCalculateInitialMoment(){
		double[] array;
		array = new double[1];
		array[0] = 1.0;
		double fourth = stat.ThirdInitialMoment(array);
		assertEquals(1.0, fourth, delta);
		
	}
	
	@Test public void CanCalculateInitialMomentForArray(){
		double[] array;
		array = new double[3];
		array[0] = 1.0; array[1] = 2.0; array[2] = 3.0;
		double fourth = stat.FourthInitialMoment(array);
		assertEquals(32.66666666666666, fourth, delta);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class) public void ThrowExceptionIfSizeLessThen1(){
		double[] array;
		array = new double[0];
		array[0] = 1.0;
		double fourth = stat.FourthInitialMoment(array);
		assertEquals(1.0, fourth, delta);
	}

}

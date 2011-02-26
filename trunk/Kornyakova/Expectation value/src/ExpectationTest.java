import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ExpectationTest {
	
	private final double delta = 1e-8;	
	Statistics stat = new Statistics();

	@Test public void CanCalcualteExpectation() {
		double[] array;
        array = new double[3];
        array[0] = 0.0;
        array[1] = -1.0;
        array[2] = 1.0;
              
		double expectation = stat.Expectation(array);
		assertEquals(0.0, expectation, delta);
	}
	
	@Test public void CanCalcualteExpectationForArrayOfDoubles() {
		double[] array;
        array = new double[6];
        array[0] = 1.0; array[1] = 1.0; array[2] = 1.0;
        array[3] = 1.0; array[4] = 1.0; array[5] = 1.0;
              
		double expectation = stat.Expectation(array);
		assertEquals(1.0, expectation, delta);
	}
	
	@Test (expected = IndexOutOfBoundsException.class) public void ThrowExceptionIfSizeLessThen1(){
		
		double[] array;
		array = new double[0];
		double expectation = stat.Expectation(array);
	}
}

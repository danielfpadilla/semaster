import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ExpectationTest {

	@Test public void CanSetValue1(){
		
		int value1 = 1;
		assertEquals(1, value1);
	}
	
	@Test public void CanSetValue2(){
		
		int value2 = 2;
		assertEquals(2, value2);
	}

	@Test public void CanSetProbability1(){
		
		double probability1 = 0.3;
		assertEquals(0.3,  probability1, 1e-8);
	}
	
	@Test public void CanSetProbability2(){
		
		double probability2 = 0.7;
		assertEquals(0.7,  probability2, 1e-8);
	}
	
	@Test public void CanSetNegativeProbability1() throws IndexOutOfBoundsException/**/{
		
		Expectation expectation = new Expectation(1, 2, 1.3, 0.8);
							
	}
	
	@Test public void CanSetSum(){
		
		Expectation expectation = new Expectation(2, 3, 0.4, 0.6);
	}
	
	@Test public void CanSetNegativeSum() throws IndexOutOfBoundsException{
		
		Expectation expectation = new Expectation(1, 2, 0.4, 0.6);
	}
	
	@Test public void CanSetExpectation(){
		
		Expectation expectation = new Expectation(1, 1, 0.6, 0.4);
		assertEquals(0.2, expectation);
	}
}

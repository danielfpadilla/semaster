import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ExpectationForDiscreteDistributionTest 
{	private final double DELTA = 1e-8;	
	Statistics statistics = new Statistics();
	
	@Test public void canCalculateExpectationForDiscreteDistribution()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfProbability = new double[1];
		arrayOfValue = new double[1];
		arrayOfProbability[0] = 1.0;
		arrayOfValue[0] = 1.0;
		
		double expectation = statistics.expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability);
		assertEquals(1.0, expectation, DELTA);		
	}
	
	@Test public void canCalculateExpectationForArrayOfDiscrete()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[3];
		arrayOfProbability = new double[3];
		arrayOfValue[0] = 1.0; 
		arrayOfValue[1] = 2.0; 
		arrayOfValue[2] = 3.0;
		arrayOfProbability[0] = 0.5; 
		arrayOfProbability[1] = 0.35; 
		arrayOfProbability[2] = 0.15;
		
		double expectation = statistics.expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability);
		assertEquals(1.65, expectation, DELTA);		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void throwExceptionIfSizeArrayOfValueLessThen1()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[0];
		arrayOfProbability = new double[1];
		
		double expectation = statistics.expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void throwExceptionIfSizeArrayOfProbabilityLessThen1()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[1];
		arrayOfProbability = new double[0];
		
		double expectation = statistics.expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability);
	}
	
	@Test (expected = RuntimeException.class) 
	public void throwExceptionIfNegativeProbability()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[2];
		arrayOfProbability = new double[2];
		arrayOfProbability[0] = 0.5; 
		arrayOfProbability[0] = 3.0; 
		
		double expectation = statistics.expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability);		
	}
	
	@Test (expected = RuntimeException.class)
	public void throwExceptionIfSumProbabilityIsNotEqual1()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[2];
		arrayOfProbability = new double[2];
		arrayOfProbability[0] = 0.5; 
		arrayOfProbability[0] = 0.6; 
		
		double expectation = statistics.expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability);		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void throwExceptionIfLengthsOfArraysAreNotEqual()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[2];
		arrayOfProbability = new double[3];
				
		double expectation = statistics.expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability);		
	}
}

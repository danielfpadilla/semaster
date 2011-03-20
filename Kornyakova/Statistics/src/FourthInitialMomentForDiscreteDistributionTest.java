import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FourthInitialMomentForDiscreteDistributionTest 
{	private final double DELTA = 1e-8;
	Statistics statistics = new Statistics();
	
	@Test public void CanCalculateFourthInitialMoment()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfProbability = new double[1];
		arrayOfValue = new double[1];
		arrayOfProbability[0] = 1.0;
		arrayOfValue[0] = 1.0;
	
	double fourth = statistics.fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);
	assertEquals(1.0, fourth, DELTA);		
	}
	
	@Test public void CanCalculateFourthInitialMomentForArrayOfDiscrete()
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
		
		double fourth = statistics.fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);
		assertEquals(18.25, fourth, DELTA);		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void ThrowExceptionIfSizeArrayOfValueLessThen1()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[0];
		arrayOfProbability = new double[1];
		
		double fourth = statistics.fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void ThrowExceptionIfSizeArrayOfProbabilityLessThen1()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[1];
		arrayOfProbability = new double[0];
		
		double fourth = statistics.fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);
	}
	
	@Test (expected = RuntimeException.class) 
	public void ThrowExceptionIfNegativeProbability()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[2];
		arrayOfProbability = new double[2];
		arrayOfProbability[0] = 0.5; 
		arrayOfProbability[0] = 3.0; 
		
		double fourth = statistics.fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);		
	}
	
	@Test (expected = RuntimeException.class)
	public void ThrowExceptionIfSumProbabilityIsNotEqual1()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[2];
		arrayOfProbability = new double[2];
		arrayOfProbability[0] = 0.5; 
		arrayOfProbability[0] = 0.6; 
		
		double fourth = statistics.fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void ThrowExceptionIfLengthsOfArraysAreNotEqual()
	{	double[] arrayOfValue;
		double[] arrayOfProbability;
		arrayOfValue = new double[2];
		arrayOfProbability = new double[3];
				
		double fourth = statistics.fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability);		
	}
}

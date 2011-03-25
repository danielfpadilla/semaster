
public class Statistics 
{
	public Statistics(){}	
	
	public double expectationForEquiprobabilityDistribution(double[] array) 
	{	
		if(array.length == 0)
		{
			throw new IndexOutOfBoundsException();
		}
		
		double expectation = 0.0;
		for (int i = 0; i < array.length; i++)
		{
			expectation += array[i];
		}
		expectation /= array.length;		 
		
		return expectation;
	}	
	
	public double expectationForDiscreteDistribution(double[]arrayOfValue, double[] arrayOfProbability)
	{	
		if(arrayOfValue.length == 0 || arrayOfProbability.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	
		if(arrayOfValue.length != arrayOfProbability.length)
		{
			throw new ArrayIndexOutOfBoundsException();			
		}
	
		for(int i = 0; i < arrayOfProbability.length; i++)
		{
			if(arrayOfProbability[i] > 1.0 || arrayOfProbability[i] < 0.0)
			{ 
				throw new IllegalArgumentException();
			}
		}
		
		double sum = 0.0;
		for(int i = 0; i < arrayOfProbability.length; i++)
		{
			sum += arrayOfProbability[i];
		}
		if(sum != 1)
		{ 
			throw new IllegalArgumentException();
		}
		
		double expectation = 0.0;
		for(int i = 0; i < arrayOfValue.length; i++)
		{
			expectation += arrayOfValue[i] * arrayOfProbability[i];
		}
		return expectation;
	}
	
	public double varianceForEquiprobabilityDistribution(double[] array)
	{	
		if(array.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		double variance = 0.0;
		for (int i = 0; i < array.length; i++)
		{
			variance += Math.pow(array[i], 2);  
		}
		variance /= array.length;
		variance -= Math.pow(expectationForEquiprobabilityDistribution(array), 2);

		return variance;
	}
	
	public double varianceForDiscreteDistribution(double[] arrayOfValue, double[] arrayOfProbability)
	{	
		double variance = 0.0;
		for (int i = 0; i < arrayOfValue.length; i++)
		{
			variance += Math.pow(arrayOfValue[i], 2) * arrayOfProbability[i];  
		}
		variance -= Math.pow(expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability), 2);

		return variance;
	}
	
	public double thirdInitialMomentForEquiprobabilityDistribution(double[] array)
	{	
		if(array.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		double third = 0.0;
		for(int i = 0; i < array.length; i++)
		{
			third += Math.pow(array[i], 3);
 		}
		third /= array.length;
		return third;
	}
	
	public double thirdInitialMomentForDiscreteDistribution(double[] arrayOfValue, double[] arrayOfProbability)
	{
		if(arrayOfValue.length == 0 || arrayOfProbability.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}

		if(arrayOfValue.length != arrayOfProbability.length)
		{
			throw new ArrayIndexOutOfBoundsException("equal");			
		}

		for(int i = 0; i < arrayOfProbability.length; i++)
		{
			if(arrayOfProbability[i] > 1.0 || arrayOfProbability[i] < 0.0)
			{ 
				throw new IllegalArgumentException();
			}
		}
	
		double sum = 0.0;
		for(int i = 0; i < arrayOfProbability.length; i++)
		{
			sum += arrayOfProbability[i];
		}	
		if(sum != 1)
		{ 
			throw new IllegalArgumentException();
		}
		
		double third = 0.0;
		for(int i = 0; i < arrayOfValue.length; i++)
		{
			third += Math.pow(arrayOfValue[i], 3) * arrayOfProbability[i];
 		}
		return third;
	}
	
	public double thirdCentralMoment(double[] arrayOfValue, double[] arrayOfProbability)
	{	
		double third = 0.0;
		third = thirdInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability) - 
				3 * expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability) * 
				varianceForDiscreteDistribution(arrayOfValue, arrayOfProbability) + 
				2 * Math.pow(expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability), 3);
			
		return third;
	}
	
	public double fourthInitialMomentForEquiprobabilityDistribution(double[] array)
	{	
		if(array.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		double fourth = 0.0;
		for(int i = 0; i < array.length; i++)
		{
			fourth += Math.pow(array[i], 4);
 		}
		fourth /= array.length;
		return fourth;
	}
	
	public double fourthInitialMomentForDiscreteDistribution(double[] arrayOfValue, double[] arrayOfProbability)
	{	
		if(arrayOfValue.length == 0 || arrayOfProbability.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}

		if(arrayOfValue.length != arrayOfProbability.length)
		{
			throw new ArrayIndexOutOfBoundsException("equal");			
		}

		for(int i = 0; i < arrayOfProbability.length; i++)
		{
			if(arrayOfProbability[i] > 1.0 || arrayOfProbability[i] < 0.0)
			{ 
				throw new IllegalArgumentException();
			}
		}
	
		double sum = 0.0;
		for(int i = 0; i < arrayOfProbability.length; i++)
		{
			sum += arrayOfProbability[i];
		}	
		if(sum != 1)
		{ 
			throw new IllegalArgumentException();
		}
	
		double fourth = 0.0;
		for(int i = 0; i < arrayOfValue.length; i++)
		{
			fourth += Math.pow(arrayOfValue[i], 4) * arrayOfProbability[i];
 		}
		return fourth;	
	}
	
	public double fourthCentralMoment(double[] arrayOfValue, double[] arrayOfProbability)
	{
		double fourth = 0.0;
		fourth = fourthInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability) -
			4 * expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability) * 
			thirdInitialMomentForDiscreteDistribution(arrayOfValue, arrayOfProbability) + 
			6 * varianceForDiscreteDistribution(arrayOfValue, arrayOfProbability) * 
			Math.pow(expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability), 2) - 
			3 * Math.pow(expectationForDiscreteDistribution(arrayOfValue, arrayOfProbability), 4);
			
		return fourth;	
	}
	
	public double skewness(double[] arrayOfValue, double[] arrayOfProbability)
	{ 	
		double sigma = 0.0;
		double skewness = 0.0;
				
		sigma = Math.pow(varianceForDiscreteDistribution(arrayOfValue, arrayOfProbability), 0.5);
		if(sigma == 0.0)
		{
			throw new ArithmeticException();
		}
		skewness = thirdCentralMoment(arrayOfValue, arrayOfProbability) / Math.pow(sigma, 3);
		
		return skewness;	
	}
	
	public double excess(double[] arrayOfValue, double[] arrayOfProbability)
	{	
		double sigma = 0.0;
		double excess = 0.0;
		
		sigma = Math.pow(varianceForDiscreteDistribution(arrayOfValue, arrayOfProbability), 0.5);
		if(sigma == 0.0)
		{
			throw new ArithmeticException();
		}
		excess = fourthCentralMoment(arrayOfValue, arrayOfProbability) / Math.pow(sigma, 4) - 3.0;
		
		return excess;	
	}
}

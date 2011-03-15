
public class Statistics 
{
	public Statistics(){}		
		
	public double Expectation(double[] array) 
	{	if(array.length == 0)
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
	
	public double Variance(double[] array)
	{	if(array.length == 0)
		{
			throw new ArrayIndexOutOfBoundsException();
		}
		
		double variance = 0.0;
		for (int i = 0; i < array.length; i++)
		{
			variance += Math.pow(array[i], 2);  
		}
		variance /= array.length;
		variance -= Expectation(array) * Expectation(array);

		return variance;
	}
	
	public double ThirdCentralMoment(double[] array)
	{	double third =  0.0;
		double temp = 0.0;
		for(int i = 0; i < array.length; i++)
		{
			third += Math.pow(array[i], 3);
			temp += Math.pow(array[i], 2);
		}
		third /= array.length;
		temp /=array.length;
		third -= 3 * temp * Expectation(array) - 2 * Math.pow(Expectation(array), 3);
			
		return third;
	}
	
	public double ThirdInitialMoment(double[] array)
	{	if(array.length == 0)
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
	
	public double FourthInitialMoment(double[] array)
	{	if(array.length == 0)
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
}


public class Statistics {

	public Statistics(){}		
		
	public double Expectation(double[] array) {
		if(array.length == 0){
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
	
	public double Variance(double[]array){
		double variance = 0.0;
		for (int i = 0; i < array.length; i++)
		{
			variance += array[i] * array[i];  
		}
		variance /= array.length;
		variance -= Expectation(array) * Expectation(array);

		return variance;
	}
}

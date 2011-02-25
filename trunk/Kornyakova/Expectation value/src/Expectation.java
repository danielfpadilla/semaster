
public class Expectation {

	public int value1, value2;
	public double probability1;
	public double probability2;
	double sum;
	double expectation;		
		
		
	public Expectation(int value1, int value2, double probability1, double probability2){
		
		sum = probability1 + probability2;
		
		if (((probability1 - 1.0) > 1e-8) || (probability1 < 1e-8)){
			
			throw new IndexOutOfBoundsException("Wrong probability1!");
		}
	
		if (((probability2 - 1.0) > 1e-8) || (probability2 < 1e-8)){
			
			throw new IndexOutOfBoundsException("Wrong probability2!");
		}
		 
		if (sum!=1.0){
			
			throw new IndexOutOfBoundsException("Error3!");
		}
	
		expectation = value1*probability1 + value2*probability2;
	}
	
	
}

package surfaceAreaCalculator;

public class SquareBasedPyramid {
	private double s_baseLength;
	private double s_height;
	private final int numOfSides = 2;
    public SquareBasedPyramid(double baseLength, double height)
	{  
		if(baseLength <= 0.0 || height <= 0.0)
		 throw new IllegalArgumentException("Negative baseLenght or Height");
		 s_baseLength= baseLength;
		 s_height = height;
    }

	public double getBaselength()
	{
	   return s_baseLength;  
	}
	public double getHeight() {
		return s_height;
	}
    public double calculateArea() {
    	double slantHeight = Math.hypot(0.5 * s_baseLength, s_height);
		double baseArea = Math.pow(s_baseLength, 2);
		double lateralArea = numOfSides * s_baseLength * slantHeight;
		double result = lateralArea + baseArea;
		return result;
    }	
}

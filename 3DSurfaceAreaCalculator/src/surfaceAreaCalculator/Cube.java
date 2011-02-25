package surfaceAreaCalculator;

public class Cube {
	public double c_faceLength;
	public Cube()
	{
		
	}
	public Cube(double facelength)
	{
		c_faceLength = facelength;
	}
	public boolean equals(Object firstObject)
	{
		Cube secondObject = (Cube)firstObject;
		if(secondObject.c_faceLength == c_faceLength)
			return true;
		else
			return false;
	}
	public double calculateArea() {
		double faceArea = c_faceLength * c_faceLength;
		double result = faceArea * 6;
		
		return result;
	}
	
	
	  

}

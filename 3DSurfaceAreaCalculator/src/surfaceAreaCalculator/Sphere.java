package surfaceAreaCalculator;

public class Sphere {
	public double s_radius; 
	public Sphere() 
	{
		
	}

	public Sphere(double radius) 
	{
		s_radius = radius;
	}
	public boolean equals(Object firstObject)
	{
		Sphere secondObject = (Sphere)firstObject;
		if(secondObject.s_radius == s_radius)
			return true;
		else
			return false;
	}

	public double calculateArea() 
	{
		double result = 4 * Math.PI * s_radius * s_radius;
		return result;
	}
   
} 

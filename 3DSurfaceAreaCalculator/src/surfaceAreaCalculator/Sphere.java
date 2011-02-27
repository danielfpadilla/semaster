package surfaceAreaCalculator;

public class Sphere {
	public double s_radius; 
	public Sphere() 
	{}
	public Sphere(double radius) 
	{
		if(radius <= 0.0)
			throw new IllegalArgumentException("Negative radius not Alloed.");
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
	public double getRadius() {
		return s_radius;
	}
	public double calculateArea() 
	{
		double result = 4 * Math.PI * Math.pow(s_radius, 2);
		return result;
	}

	
   
} 

package surfaceAreaCalculator;

public class Cylinder {
	private double c_radius;
	private double c_height;
	private final int numOfSurfaces = 2;
	public Cylinder()
	{}
	public Cylinder(double radius, double height)
	{
		if(radius <= 0.0 || height <= 0.0)
		 throw new IllegalArgumentException("Negative radius or height");
		c_radius = radius;
		c_height = height;	
	}
	 public boolean equals(Object firstObject)
	 {
		 Cylinder secondObject= (Cylinder)firstObject;
		if ((c_radius - secondObject.c_radius)==(c_height - secondObject.c_height))
			 return true;
		 else
			 return false;
	 }
		public double getRadius()
		{
			return c_radius;
		}
		public double getHeight() 
		{
		  return c_height;
		}
	 public double calculateArea()
	 {
		 double baseAndTopArea = numOfSurfaces * Math.PI *Math.pow(c_radius, 2);
		 double lateralArea =numOfSurfaces * Math.PI * c_radius * c_height;
		 double result = baseAndTopArea + lateralArea;
		 return result;
	 }

	}


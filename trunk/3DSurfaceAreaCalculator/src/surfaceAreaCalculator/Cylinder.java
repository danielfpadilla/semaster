package surfaceAreaCalculator;

public class Cylinder {
	public double c_radius;
	public double c_height;
	public Cylinder()
	{}
	public Cylinder(double radius, double height)
	{
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
	 public double calculateArea()
	 {
		 double baseAndTopArea = 2 * Math.PI *c_radius *c_radius;
		 double lateralArea = 2 * Math.PI * c_radius * c_height;
		 double result = baseAndTopArea + lateralArea;
		 return result;
	 }

}

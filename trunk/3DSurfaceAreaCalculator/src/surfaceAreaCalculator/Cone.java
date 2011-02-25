package surfaceAreaCalculator;

public class Cone 
{
	 public double c_radius;
	 public double c_height;
  public Cone(double radius, double height)
  {
	  c_radius  = radius;
	  c_height = height;
  }
  public Cone()
  {
	  
  }
  
 public boolean equals(Object firstObject)
 {
	 Cone secondObject= (Cone)firstObject;
	if ((c_radius - secondObject.c_radius)==(c_height - secondObject.c_height))
		 return true;
	 else
		 return false;
	 
 }

 public double calculateArea()
 {
	 double hypotenuse  = Math.sqrt(c_height * c_height + c_radius * c_radius);
	 double lateralSurfaceArea = Math.PI * c_radius * hypotenuse;
     double baseArea = Math.PI * c_radius * c_radius;
     double resultArea = baseArea  + lateralSurfaceArea ;
     return resultArea;	
	
}

 }

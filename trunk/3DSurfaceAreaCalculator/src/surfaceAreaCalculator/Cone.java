package surfaceAreaCalculator;

import static org.junit.Assert.fail;

import org.junit.Test;

public class Cone 
{
	 private double c_radius;
	 private double c_height;
  public Cone(double radius, double height)
  {
	  if(radius <= 0.0 ||height <= 0.0)
		  throw new IllegalArgumentException("Invalid radius and height");
	  c_radius  = radius;
	  c_height = height;
  }
  public Cone()
  {} 
 public boolean equals(Object firstObject)
 {
	 Cone secondObject= (Cone)firstObject;
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
	 double hypotenuse  = Math.hypot(c_radius, c_height);
	 double lateralSurfaceArea = Math.PI * c_radius * hypotenuse;
     double baseArea = Math.PI * Math.pow(c_radius, 2);
     double resultArea = baseArea  + lateralSurfaceArea ;
     return resultArea;	
   }


}

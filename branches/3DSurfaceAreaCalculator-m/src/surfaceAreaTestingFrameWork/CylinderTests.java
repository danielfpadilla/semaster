package surfaceAreaTestingFrameWork;

import surfaceAreaCalculator.Cylinder;

import static org.junit.Assert.*;
import org.junit.Test;


public class CylinderTests {
	Cylinder cylinder  = new Cylinder(7,10);
    private final double delta = 0.0001;

 @ Test public void CanCreateACylinder()
   {
	assertNotNull(cylinder);	
  }
 @Test public void canSetRadiusAndHeightOfCylinder()
  {
	assertNotNull(cylinder);
  }
 @Test public void canSetRadiusofCylinder()
 {
	 assertEquals(7,cylinder.getRadius(), delta);
	
 }
 @Test public void canSetheightOfCylinder()
 {
	 assertEquals(10, cylinder.getHeight(), delta);
 }
@Test
public void CanCalculateAreaOfCylinderWithRadiusEqualsToSevenAndHeightEqualsToTen()
{
	double actual = cylinder.calculateArea();
	double expected = 747.6990;
	assertEquals(expected, actual, delta);
}
@Test public void CalculateAreaOfCylinderWithRadiusEqualsTo50Point75AndHeightEqualsTo70Point35()
{
	Cylinder cylinder= new Cylinder(50.75,70.35);
	double actual = cylinder.calculateArea();
	double expected = 38615.357343;
	assertEquals(expected, actual, delta);
}
@Test public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
throws Exception
{
	  try
	  {
		   new Cylinder(-10, 10);
		  fail("Negative radius");
	  }
	  catch (IllegalArgumentException expected)
	  {}
}
@Test public void CheckWhetherAnExceptionIsThrownWhenHeightIsLessThanOrEqualToZero()throws Exception
{  try
{
	  new Cylinder(10, -10);
	  fail("Negative height");
}
     catch (IllegalArgumentException expected)
        {}
}

}

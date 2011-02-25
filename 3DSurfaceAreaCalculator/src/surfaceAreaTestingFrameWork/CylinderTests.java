package surfaceAreaTestingFrameWork;

import surfaceAreaCalculator.Cylinder;

import org.junit.Assert;
import org.junit.Test;


public class CylinderTests {
private final double delta = 0.0001;
 @ Test
  public void CanCreateACylinder()
   {
	Cylinder cylinder = new Cylinder();
	Assert.assertNotNull(cylinder);	
  }
 @Test
  public void canSetRadiusAndHeightOfCylinder()
  {
	Cylinder cylinder  = new Cylinder(7,10);
	Assert.assertNotNull(cylinder);
  }
 @Test
  
 public void canSetRadiusofCylinder()
 {
	 Cylinder cylinder  = new Cylinder(7,10);
	 Assert.assertEquals(7,cylinder.c_radius, delta);
	
 }
 @Test
 public void canSetheightOfCylinder()
 {
	 Cylinder cylinder = new Cylinder(7, 10);
	 Assert.assertEquals(10, cylinder.c_height, delta);
 }
 @Test
 public void AreTheTwoCylinderEqual()
 {
	  Cylinder cylinder1 = new Cylinder(12.5, 23.4);
	  Cylinder cylinder2 = new Cylinder(12.5, 23.4);
	 Assert.assertEquals(cylinder1,cylinder2);
	  
 }
 
 @Test
 public void TwoCylinderAreNotEqual()
 {
	  Cylinder cylinder1 = new Cylinder(15, 23.4);
	  Cylinder cylinder2 = new Cylinder(12.5, 23.4);
	  Assert.assertTrue(!cylinder1.equals(cylinder2));
 }
@Test
public void CanCalculateAreaOfCylinderWithRadiusEqualsToSevenAndHeightEqualsToTen()
{
	Cylinder cylinder= new Cylinder(7,10);
	double actual = cylinder.calculateArea();
	double expected = 747.6990;
	Assert.assertEquals(expected, actual, delta);
}
@Test
public void CalculateAreaOfCylinderWithRadiusEqualsTo50Point75AndHeightEqualsTo70Point35()
{
	Cylinder cylinder= new Cylinder(50.75,70.35);
	double actual = cylinder.calculateArea();
	double expected = 38615.357343;
	Assert.assertEquals(expected, actual, delta);
}
@Test
public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()throws Exception
{
	  //TODO
}
public void CheckWhetherAnExceptionIsThrownWhenHeightIsLessThanOrEqualToZero()throws Exception
{
	  //TODO
}

}

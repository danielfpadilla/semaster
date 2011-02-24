package surfaceAreaTestingFrameWork;
import surfaceAreaCalculator.Cone;

import org.junit.Assert;
import org.junit.Test;

public class ConeTest  {
	private double delta = 0.00001;

	@Test
	public void CanSetRadiusAndHeightOfCone()
	{
		Cone cone = new Cone(7.0, 10.0);
		Assert.assertNotNull(cone);
	}
	@Test 
	public void CanSetRadiusOfCone()
	{
		Cone cone  = new Cone(7.0,10.0);
		Assert.assertEquals(7,cone.c_radius, delta);
	}
  @Test
  public void CanSetHeightOfCone()
  {
	  Cone cone = new Cone(7.0,10.0);
	  Assert.assertEquals(10, cone.c_height, delta);
  }
  @Test
  public void AreTheTwoConesEqual()
  {
	  Cone cone1 = new Cone(12.5, 23.4);
	  Cone cone2 = new Cone(12.5, 23.4);
	 Assert.assertEquals(cone1,cone2);
	  
  }
  @Test
  public void TwoConesAreNotEqual()
  {
	  Cone cone1 = new Cone(15, 23.4);
	  Cone cone2 = new Cone(12.5, 23.4);
	  Assert.assertTrue(!cone1.equals(cone2));
  }
  @Test 
  public void CanCalculateAreaOfConeGivenRadiusEquals3pointZeroAndHeightEquals4pointZero()
  {
	  Cone cone = new Cone(3.0,4.0);
	  double actual = cone.calculateArea();
	  double expected = 75.398223;
	  Assert.assertEquals(expected,actual ,delta);

  }
  @Test 
  public void CanCalculateAreaOfConeGivenRadiusEquals10point85AndHeightEquals45point897()
  {
	  Cone cone = new Cone(10.85,45.897);
	  double actual = cone.calculateArea();
	  double expected = 1977.41433;
	  Assert.assertEquals(expected,actual ,delta);

  }

  @Test
  public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()throws Exception
  {
	 //TODO - Exception little bit complicated
	  
  }
}

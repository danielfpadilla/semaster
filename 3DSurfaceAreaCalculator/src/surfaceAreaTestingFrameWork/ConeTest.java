package surfaceAreaTestingFrameWork;
import surfaceAreaCalculator.Cone;
import static org.junit.Assert.*;

import org.junit.Test;

public class ConeTest  {
	Cone cone = new Cone(3.0,4.0);
	private double delta = 0.00001;
	@Test public void CanCreateACone()
	{
		Cone cone = new Cone();
		assertNotNull(cone);	
	}
	@Test public void CanSetRadiusAndHeightOfCone()
	{
	    assertNotNull(cone);
	}
	@Test public void CanSetRadiusOfCone()
	{
		assertEquals(3,cone.getRadius(), delta);
	}

  @Test public void CanSetHeightOfCone()
  {
	  assertEquals(4, cone.getHeight(), delta);
  }
  @Test public void AreTheTwoConesEqual()
  {
	  Cone cone1 = new Cone(12.5, 23.4);
	  Cone cone2 = new Cone(12.5, 23.4);
	  assertEquals(cone1,cone2); 
  }
  @Test public void TwoConesAreNotEqual()
  {
	  Cone cone1 = new Cone(15, 23.4);
	  Cone cone2 = new Cone(12.5, 23.4);
	  assertTrue(!cone1.equals(cone2));
  }
  @Test public void CanCalculateAreaOfConeGivenRadiusEquals3pointZeroAndHeightEquals4pointZero()
  {
	  double actual = cone.calculateArea();
	  double expected = 75.398223;
	  assertEquals(expected,actual ,delta);
  }
  @Test  public void CanCalculateAreaOfConeGivenRadiusEquals10point85AndHeightEquals45point897()
  {
	  Cone cone = new Cone(10.85,45.897);
	  double actual = cone.calculateArea();
	  double expected = 1977.41433;
	  assertEquals(expected,actual ,delta);
  }

  @Test  public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
  throws Exception
  {
	  try
	  {
		  Cone cone= new Cone(-10, 19);
		  fail("Negative radius");
	  }
	  catch (IllegalArgumentException expected)
	  {}
  }
  @Test public void CheckWhetherAnExceptionIsThrownWhenHeightIsLessThanOrEqualToZero()
  throws Exception
  {
	  try
	  {
		  Cone cone= new Cone(10, -19);
		  fail("Negative Height");
	  }
	  catch (IllegalArgumentException expected)
	  {}
  }
}

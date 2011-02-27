package surfaceAreaTestingFrameWork;
import static org.junit.Assert.*;

import org.junit.Test;
import surfaceAreaCalculator.Sphere;

public class SphereTests {
	private final double delta = 0.0001;
	@Test public void canCreateASphere()
	{
		Sphere sphere = new Sphere();
		assertNotNull(sphere);
	}
	@Test public void canSetRadiusOfASphere()
	{
		Sphere sphere = new Sphere(7);
		assertEquals(7.0, sphere.getRadius(), delta);
		
	}
	@Test public void AreTwoConesEqual()
	{
		Sphere sphere1 = new Sphere(10);
		Sphere sphere2 = new Sphere(10);
		assertEquals(sphere1, sphere2);
	}
	@Test public void AreTwoConesNotEqual()
	{
		Sphere sphere1 = new Sphere(10);
		Sphere sphere2 = new Sphere(20);
		assertTrue(!sphere1.equals(sphere2));
	}
	@Test public void CanCalculateAreaOfSphereGivenRadiusEquals10()
	  {
		  Sphere sphere = new Sphere(10.0);
		  double actual = sphere.calculateArea();
		  double expected = 1256.6371;
		  assertEquals(expected,actual ,delta);
	  }

	 @Test  public void CanCalculateAreaOfSphereGivenRadiusEquals43pointEightFive()
	  {
		  Sphere sphere = new Sphere(43.85);
		  double actual = sphere.calculateArea();
		  double expected = 24162.9001;
		  assertEquals(expected,actual ,delta);
	  }
	 @Test  public void CheckWhetherAnExceptionIsThrownWhenRadiusIsLessThanOrEqualToZero()
	  throws Exception
	  {
		  try
		  {
			  Sphere sphere= new Sphere(-10);
			  fail("Negative radius");
		  }
		  catch (IllegalArgumentException expected)
		  {}
	  }
}

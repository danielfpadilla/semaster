package surfaceAreaTestingFrameWork;

import org.junit.Test;

import surfaceAreaCalculator.Sphere;

import junit.framework.Assert;


public class SphereTests {
	private final double delta = 0.0001;
	@Test
	public void canCreateASphere()
	{
		Sphere sphere = new Sphere();
		Assert.assertNotNull(sphere);
	}
	@Test
	public void canSetRadiusOfASphere()
	{
		Sphere sphere = new Sphere(7);
		Assert.assertEquals(7.0, sphere.s_radius);
		
	}
	@Test
	public void AreTwoConesEqual()
	{
		Sphere sphere1 = new Sphere(10);
		Sphere sphere2 = new Sphere(10);
		Assert.assertEquals(sphere1, sphere2);
	}
	@Test
	public void AreTwoConesNotEqual()
	{
		Sphere sphere1 = new Sphere(10);
		Sphere sphere2 = new Sphere(20);
		Assert.assertTrue(!sphere1.equals(sphere2));
	}
	@Test 
	  public void CanCalculateAreaOfSphereGivenRadiusEquals10()
	  {
		  Sphere sphere = new Sphere(10.0);
		  double actual = sphere.calculateArea();
		  double expected = 1256.6371;
		  Assert.assertEquals(expected,actual ,delta);

	  }

	  @Test 
	  public void CanCalculateAreaOfSphereGivenRadiusEquals43pointEightFive()
	  {
		  Sphere sphere = new Sphere(43.85);
		  double actual = sphere.calculateArea();
		  double expected = 24162.9001;
		  Assert.assertEquals(expected,actual ,delta);

	  }

}

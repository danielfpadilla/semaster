import org.junit.Test;
import junit.framework.Assert;

public class SphereTest 
{
	int radius = 7;
	double volume = 4/3 * Math.PI * Math.pow(radius, 3);
	double delta = 0.000001;
	@Test public void CanCreateSphere()
	{
		Sphere sphere = new Sphere();
		Assert.assertNotNull(sphere);
	}
	@Test public void CanInitializeSphere()
	{
		Sphere sphere = new Sphere(radius);
		Assert.assertNotNull(sphere);
	}
	@Test public void CanGetSphereRadius()
	{
		Sphere sphere = new Sphere(radius);
		Assert.assertEquals(radius, sphere.GetRadius());
	}
	@Test public void CanSetSphereRadius()
	{
		Sphere sphere = new Sphere();
		sphere.SetRadius(radius);
		Assert.assertEquals(radius, sphere.GetRadius());
	}
	@Test public void CanCalculateSphereVolume()
	{
		Sphere sphere = new Sphere(radius);
		Assert.assertEquals(volume, sphere.CalculateVolume(), delta);
	}
	
}

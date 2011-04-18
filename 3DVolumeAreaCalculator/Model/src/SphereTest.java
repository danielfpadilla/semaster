import org.junit.Test;
import junit.framework.Assert;

public class SphereTest 
{
	int radius = 7;
	int NegativeRadius = -7;
	int ZeroRadius = 0;
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
	@Test(expected = ParameterValueException.class) 
	public void CanCheckExceptionWithNegativeSphereRadius() throws ParameterValueException
	{
		Sphere sphere = new Sphere(NegativeRadius);
		sphere.ValidateRadius();
	}
	@Test public void CanCalculateSphereVolumeWithNegativeRadius()
	{
		Sphere sphere = new Sphere(NegativeRadius);
		Assert.assertEquals(volume, sphere.CalculateVolume(), delta);
	}
	@Test public void CanCalculateSphereVolumeWithZeroRadius()
	{
		Sphere sphere = new Sphere(ZeroRadius);
		Assert.assertEquals(volume, sphere.CalculateVolume(), delta);
	}
}

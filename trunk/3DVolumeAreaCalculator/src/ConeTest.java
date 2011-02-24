import org.junit.Test;
import junit.framework.Assert;
//import junit.framework.TestCase;

public class ConeTest 
{
	int radius = 2;
	int height = 4;
	double volume = 1/3 * Math.PI * (double)Math.pow(radius, 2) * height;
	double delta = 0.00002;
	@Test public void CanCreateCone()
	{
		Cone cone = new Cone();
		Assert.assertNotNull(cone);
	}
	@Test public void CanInitializeCone()
	{
		Cone cone = new Cone(radius, height);
		Assert.assertNotNull(cone);
	}
	@Test public void CanGetConeRadius()
	{
		Cone cone = new Cone(radius, height);
		Assert.assertEquals(radius, cone.GetRadius());
	}
	@Test public void CanGetConeHeight()
	{
		Cone cone = new Cone(radius, height);
		Assert.assertEquals(height, cone.GetHeight());
	}
	@Test public void CanSetConeRadius()
	{
		Cone cone = new Cone();
		cone.SetRadius(radius);
		Assert.assertEquals(radius, cone.GetRadius());
	}
	@Test public void CanSetConeHeight()
	{
		Cone cone = new Cone();
		cone.SetHeight(height);
		Assert.assertEquals(height, cone.GetHeight());
	}
	@Test public void CanCalculateVolume()
	{
		Cone cone = new Cone(radius, height);
		Assert.assertEquals(volume, cone.CalculateVolume(), delta);
	}
}

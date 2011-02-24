import org.junit.Test;
import junit.framework.Assert;

public class CylinderTest 
{
	int radius = 3;
	int height = 5;
	double volume = Math.PI * Math.pow(radius, 2) * height;
	double delta = 0.0002;
	@Test public void CanCreateCylinder()
	{
		Cylinder cylinder = new Cylinder();
		Assert.assertNotNull(cylinder);
	}
	@Test public void CanInitializeCylinder()
	{
		Cylinder cylinder = new Cylinder(radius, height);
		Assert.assertNotNull(cylinder);
	}
	@Test public void CanGetCylinderRadius()
	{
		Cylinder cylinder = new Cylinder(radius, height);
		Assert.assertEquals(radius, cylinder.GetRadius());
	}
	@Test public void CanGetCylinderHeight()
	{
		Cylinder cylinder = new Cylinder(radius, height);
		Assert.assertEquals(height, cylinder.GetHeight());
	}
	@Test public void CanSetCylinderRadius()
	{
		Cylinder cylinder = new Cylinder();
		cylinder.SetRadius(radius);
		Assert.assertEquals(radius, cylinder.GetRadius());
	}
	@Test public void CanSetCylinderHeight()
	{
		Cylinder cylinder = new Cylinder();
		cylinder.SetHeight(height);
		Assert.assertEquals(height, cylinder.GetHeight());
	}
	@Test public void CanCalculateCylinderVolume()
	{
		Cylinder cylinder = new Cylinder(radius, height);
		Assert.assertEquals(volume, cylinder.CalculateVolume(), delta);
	}
}
